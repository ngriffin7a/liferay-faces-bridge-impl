/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.bridge.context.url.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.portlet.faces.Bridge;

import com.liferay.faces.bridge.config.BridgeConfig;
import com.liferay.faces.bridge.config.internal.BridgeConfigAttributeMap;
import com.liferay.faces.bridge.context.url.BridgeURI;
import com.liferay.faces.bridge.context.url.BridgeURLBase;
import com.liferay.faces.bridge.util.internal.ViewUtil;
import com.liferay.faces.util.config.ConfiguredServletMapping;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Neil Griffin
 */
public abstract class BridgeURLInternalBase extends BridgeURLBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(BridgeURLInternalBase.class);

	// Private Data Members
	private List<ConfiguredServletMapping> configuredFacesServletMappings;

	@SuppressWarnings("unchecked")
	public BridgeURLInternalBase(BridgeURI bridgeURI, String contextPath, String namespace, String viewId,
		String viewIdRenderParameterName, String viewIdResourceParameterName, BridgeConfig bridgeConfig) {
		super(bridgeURI, contextPath, namespace, viewId, viewIdRenderParameterName, viewIdResourceParameterName);
		this.configuredFacesServletMappings = (List<ConfiguredServletMapping>) bridgeConfig.getAttributes().get(
				BridgeConfigAttributeMap.CONFIGURED_FACES_SERVLET_MAPPINGS);
	}

	@Override
	protected void log(Level level, String message, Object... arguments) {

		if (level != null) {

			if (level == Level.SEVERE) {
				logger.error(message, arguments);
			}
			else if (level == Level.WARNING) {
				logger.warn(message, arguments);
			}
			else if (level == Level.INFO) {
				logger.info(message, arguments);
			}
			else {
				logger.debug(message, arguments);
			}
		}
	}

	@Override
	protected void logError(Throwable t) {
		logger.error(t);
	}

	@Override
	protected boolean isMappedToFacesServlet(String viewPath) {

		// Try to determine the viewId by examining the servlet-mapping entries for the Faces Servlet.
		// For each servlet-mapping:
		for (ConfiguredServletMapping configuredFacesServletMapping : configuredFacesServletMappings) {

			// If the current servlet-mapping matches the viewPath, then
			logger.debug("Attempting to determine the facesViewId from {0}=[{1}]", Bridge.VIEW_PATH, viewPath);

			if (configuredFacesServletMapping.isMatch(viewPath)) {
				return true;
			}
		}

		return false;
	}
}
