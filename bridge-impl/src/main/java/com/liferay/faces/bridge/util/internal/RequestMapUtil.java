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
package com.liferay.faces.bridge.util.internal;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;

import com.liferay.faces.bridge.config.BridgeConfig;
import com.liferay.faces.bridge.scope.BridgeRequestScope;


/**
 * @author  Neil Griffin
 */
public class RequestMapUtil {

	public static BridgeConfig getBridgeConfig(FacesContext facesContext) {
		return getBridgeConfig(facesContext.getExternalContext());
	}

	public static BridgeConfig getBridgeConfig(ExternalContext externalContext) {
		return getBridgeConfig((PortletRequest) externalContext.getRequest());
	}

	public static BridgeConfig getBridgeConfig(PortletRequest portletRequest) {
		return (BridgeConfig) portletRequest.getAttribute(BridgeConfig.class.getName());
	}

	public static BridgeRequestScope getBridgeRequestScope(FacesContext facesContext) {
		return getBridgeRequestScope(facesContext.getExternalContext());
	}

	public static BridgeRequestScope getBridgeRequestScope(ExternalContext externalContext) {
		return getBridgeRequestScope((PortletRequest) externalContext.getRequest());
	}

	public static BridgeRequestScope getBridgeRequestScope(PortletRequest portletRequest) {
		return (BridgeRequestScope) portletRequest.getAttribute(BridgeRequestScope.class.getName());
	}

	public static PortletConfig getPortletConfig(FacesContext facesContext) {
		return getPortletConfig(facesContext.getExternalContext());
	}

	public static PortletConfig getPortletConfig(ExternalContext externalContext) {
		return getPortletConfig((PortletRequest) externalContext.getRequest());
	}

	public static PortletConfig getPortletConfig(PortletRequest portletRequest) {
		return (PortletConfig) portletRequest.getAttribute(PortletConfig.class.getName());
	}
}
