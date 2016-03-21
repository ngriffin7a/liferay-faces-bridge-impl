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
package com.liferay.faces.bridge.application.internal;

import java.util.List;
import java.util.Map;

import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewDeclarationLanguage;
import javax.portlet.faces.Bridge;
import javax.portlet.faces.Bridge.PortletPhase;
import javax.portlet.faces.BridgeUtil;

import com.liferay.faces.bridge.internal.BridgeExt;
import com.liferay.faces.util.product.ProductConstants;
import com.liferay.faces.util.product.ProductMap;


/**
 * This class provides a compatibility layer that isolates differences between JSF1 and JSF2.
 *
 * @author  Neil Griffin
 */
public abstract class ViewHandlerCompatImpl extends ViewHandlerWrapper {

	/**
	 * Mojarra 1.x does not have the ability to process faces-config navigation-rule entries with to-view-id containing
	 * EL-expressions. This method compensates for that shortcoming by evaluating the EL-expression that may be present
	 * in the specified viewId.
	 *
	 * @param   facesContext  The current FacesContext.
	 * @param   viewId        The viewId that may contain an EL expression.
	 *
	 * @return  If an EL-expression was present in the specified viewId, then returns the evaluated expression.
	 *          Otherwise, returns the specified viewId unchanged.
	 */
	protected String evaluateExpressionJSF1(FacesContext facesContext, String viewId) {

		// This method has overridden behavior for JSF 1 but simply returns the specified viewId for JSF 2
		return viewId;
	}

	protected ViewHandler getFacesRuntimeViewHandler() {

		ViewHandler viewHandler = getWrapped();

		while (viewHandler instanceof ViewHandlerWrapper) {
			ViewHandlerWrapper viewHandlerWrapper = (ViewHandlerWrapper) viewHandler;
			viewHandler = viewHandlerWrapper.getWrapped();
		}

		return viewHandler;
	}

	@Override
	public String getRedirectURL(FacesContext facesContext, String viewId, Map<String, List<String>> parameters,
		boolean includeViewParams) {

		PortletPhase portletRequestPhase = BridgeUtil.getPortletRequestPhase(facesContext);

		// Determine whether or not it is necessary to work-around the patch applied to Mojarra in JAVASERVERFACES-3023.
		// NOTE: The detection of Mojarra is normally done with a static private constant, but that is not possible on
		// WildFly so the detection must be done here. For more information, see FACES-2621.
		boolean MOJARRA_DETECTED = ProductMap.getInstance().get(ProductConstants.JSF).getTitle().equals(
				ProductConstants.MOJARRA);
		boolean workaroundMojarra = (MOJARRA_DETECTED) &&
			((portletRequestPhase == Bridge.PortletPhase.ACTION_PHASE) ||
				(portletRequestPhase == Bridge.PortletPhase.EVENT_PHASE));

		ExternalContext externalContext = facesContext.getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();

		if (workaroundMojarra) {
			requestMap.put(BridgeExt.RESPONSE_CHARACTER_ENCODING, "UTF-8");
		}

		String redirectURL = super.getRedirectURL(facesContext, viewId, parameters, includeViewParams);

		if (workaroundMojarra) {
			requestMap.remove(BridgeExt.RESPONSE_CHARACTER_ENCODING);
		}

		return redirectURL;
	}

	@Override
	public ViewDeclarationLanguage getViewDeclarationLanguage(FacesContext context, String viewId) {

		if (viewId != null) {

			int pos = viewId.indexOf("?");

			if (pos > 0) {
				viewId = viewId.substring(0, pos);
			}
		}

		return super.getViewDeclarationLanguage(context, viewId);
	}
}
