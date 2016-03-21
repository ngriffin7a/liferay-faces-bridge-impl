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

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.portlet.BaseURL;
import javax.portlet.faces.Bridge.PortletPhase;
import javax.portlet.faces.BridgeUtil;

import com.liferay.faces.bridge.config.BridgeConfig;
import com.liferay.faces.bridge.context.url.BridgeURI;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * @author  Neil Griffin
 */
public class BridgeBookmarkableURLImpl extends BridgeURLInternalBase {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(BridgeBookmarkableURLImpl.class);

	public BridgeBookmarkableURLImpl(BridgeURI bridgeURI, String contextPath, String namespace, String viewId,
		String viewIdRenderParameterName, String viewIdResourceParameterName, Map<String, List<String>> parameters,
		BridgeConfig bridgeConfig) {

		super(bridgeURI, contextPath, namespace, viewId, viewIdRenderParameterName, viewIdResourceParameterName,
			bridgeConfig);

		if ((bridgeURI != null) && (bridgeURI.toString() != null)) {

			if (parameters != null) {

				Map<String, String[]> parameterMap = getParameterMap();
				Set<Map.Entry<String, List<String>>> entrySet = parameters.entrySet();

				for (Map.Entry<String, List<String>> mapEntry : entrySet) {

					String key = mapEntry.getKey();
					String[] valueArray = null;
					List<String> valueList = mapEntry.getValue();

					if (valueList != null) {
						valueArray = valueList.toArray(new String[valueList.size()]);
					}

					parameterMap.put(key, valueArray);
				}
			}
		}
	}

	@Override
	public BaseURL toBaseURL() throws MalformedURLException {

		BaseURL baseURL = null;

		// If this is executing during the RENDER_PHASE or RESOURCE_PHASE of the portlet lifecycle, then
		PortletPhase portletRequestPhase = BridgeUtil.getPortletRequestPhase();

		if ((portletRequestPhase == PortletPhase.RENDER_PHASE) ||
				(portletRequestPhase == PortletPhase.RESOURCE_PHASE)) {

			BridgeURI bridgeURI = getBridgeURI();
			String uri = bridgeURI.toString();
			FacesContext facesContext = FacesContext.getCurrentInstance();
			baseURL = createRenderURL(facesContext, uri);
			baseURL.setParameters(getParameterMap());
			baseURL.setParameter(getViewIdRenderParameterName(), getViewId());
		}

		// Otherwise, log an error.
		else {
			logger.error("Unable to encode bookmarkable URL during Bridge.PortletPhase.[{0}].", portletRequestPhase);
		}

		return baseURL;
	}
}
