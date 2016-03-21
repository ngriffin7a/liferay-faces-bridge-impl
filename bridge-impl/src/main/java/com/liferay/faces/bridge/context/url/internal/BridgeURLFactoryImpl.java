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

import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

import com.liferay.faces.bridge.config.BridgeConfig;
import com.liferay.faces.bridge.context.url.BridgeResourceURL;
import com.liferay.faces.bridge.context.url.BridgeURI;
import com.liferay.faces.bridge.context.url.BridgeURL;
import com.liferay.faces.bridge.context.url.BridgeURLFactory;
import com.liferay.faces.bridge.util.internal.RequestMapUtil;


/**
 * @author  Neil Griffin
 */
public class BridgeURLFactoryImpl extends BridgeURLFactory {

	@Override
	public BridgeURL getBridgeActionURL(FacesContext facesContext, BridgeURI bridgeURI, String viewId) {

		ContextInfo contextInfo = new ContextInfo(facesContext);

		return new BridgeActionURLImpl(bridgeURI, contextInfo.getContextPath(), contextInfo.getNamespace(), viewId,
				contextInfo.getViewIdRenderParameterName(), contextInfo.getViewIdResourceParameterName(),
				contextInfo.getBridgeConfig());
	}

	@Override
	public BridgeURL getBridgeBookmarkableURL(FacesContext facesContext, BridgeURI bridgeURI,
		Map<String, List<String>> parameters, String viewId) {

		ContextInfo contextInfo = new ContextInfo(facesContext);

		return new BridgeBookmarkableURLImpl(bridgeURI, contextInfo.getContextPath(), contextInfo.getNamespace(),
				viewId, contextInfo.getViewIdRenderParameterName(), contextInfo.getViewIdResourceParameterName(),
				parameters, contextInfo.getBridgeConfig());
	}

	@Override
	public BridgeURL getBridgePartialActionURL(FacesContext facesContext, BridgeURI bridgeURI, String viewId) {

		ContextInfo contextInfo = new ContextInfo(facesContext);

		return new BridgePartialActionURLImpl(bridgeURI, contextInfo.getContextPath(), contextInfo.getNamespace(),
				viewId, contextInfo.getViewIdRenderParameterName(), contextInfo.getViewIdResourceParameterName(),
				contextInfo.getBridgeConfig());
	}

	@Override
	public BridgeURL getBridgeRedirectURL(FacesContext facesContext, BridgeURI bridgeURI,
		Map<String, List<String>> parameters, String viewId) {

		ContextInfo contextInfo = new ContextInfo(facesContext);

		return new BridgeRedirectURLImpl(bridgeURI, contextInfo.getContextPath(), contextInfo.getNamespace(), viewId,
				contextInfo.getViewIdRenderParameterName(), contextInfo.getViewIdResourceParameterName(), parameters,
				contextInfo.getBridgeConfig());
	}

	@Override
	public BridgeResourceURL getBridgeResourceURL(FacesContext facesContext, BridgeURI bridgeURI, String viewId) {

		ContextInfo contextInfo = new ContextInfo(facesContext);

		return new BridgeResourceURLImpl(bridgeURI, contextInfo.getContextPath(), contextInfo.getNamespace(), viewId,
				contextInfo.getViewIdRenderParameterName(), contextInfo.getViewIdResourceParameterName(),
				contextInfo.getBridgeConfig());
	}

	@Override
	public BridgeURLFactory getWrapped() {

		// Since this is the factory instance provided by the bridge, it will never wrap another factory.
		return null;
	}

	private static class ContextInfo {

		// Private Data Members
		private BridgeConfig bridgeConfig;
		private String contextPath;
		private String namespace;
		private String viewIdRenderParameterName;
		private String viewIdResourceParameterName;

		public ContextInfo(FacesContext facesContext) {

			ExternalContext externalContext = facesContext.getExternalContext();
			PortletRequest portletRequest = (PortletRequest) externalContext.getRequest();
			this.bridgeConfig = RequestMapUtil.getBridgeConfig(portletRequest);
			this.contextPath = externalContext.getRequestContextPath();
			this.namespace = externalContext.encodeNamespace("");

			Map<String, Object> requestMap = externalContext.getRequestMap();
			BridgeConfig bridgeConfig = (BridgeConfig) requestMap.get(BridgeConfig.class.getName());
			this.viewIdRenderParameterName = bridgeConfig.getViewIdRenderParameterName();
			this.viewIdResourceParameterName = bridgeConfig.getViewIdResourceParameterName();
		}

		public BridgeConfig getBridgeConfig() {
			return bridgeConfig;
		}

		public String getContextPath() {
			return contextPath;
		}

		public String getNamespace() {
			return namespace;
		}

		public String getViewIdRenderParameterName() {
			return viewIdRenderParameterName;
		}

		public String getViewIdResourceParameterName() {
			return this.viewIdResourceParameterName;
		}
	}
}
