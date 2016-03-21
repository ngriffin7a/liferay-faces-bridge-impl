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
package com.liferay.faces.bridge.component.inputfile.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.portlet.PortletRequest;
import javax.portlet.faces.BridgeFactoryFinder;

import com.liferay.faces.bridge.component.inputfile.InputFile;
import com.liferay.faces.bridge.context.ContextMapFactory;
import com.liferay.faces.bridge.event.FileUploadEvent;
import com.liferay.faces.bridge.model.UploadedFile;
import com.liferay.faces.util.render.internal.DelegationResponseWriter;


/**
 * @author  Neil Griffin
 */

//J-
@FacesRenderer(componentFamily = InputFile.COMPONENT_FAMILY, rendererType = InputFile.RENDERER_TYPE)
//J+
public class InputFileRenderer extends InputFileRendererCompat {

	@Override
	public void decode(FacesContext facesContext, UIComponent uiComponent) {

		InputFile inputFile = (InputFile) uiComponent;

		Map<String, List<UploadedFile>> uploadedFileMap = getUploadedFileMap(facesContext);

		if (uploadedFileMap != null) {

			String clientId = uiComponent.getClientId(facesContext);
			List<UploadedFile> uploadedFiles = uploadedFileMap.get(clientId);

			if ((uploadedFiles != null) && (uploadedFiles.size() > 0)) {

				List<com.liferay.faces.bridge.model.UploadedFile> bridgeUploadedFiles =
					new ArrayList<com.liferay.faces.bridge.model.UploadedFile>(uploadedFiles.size());

				for (UploadedFile uploadedFile : uploadedFiles) {
					bridgeUploadedFiles.add(uploadedFile);
				}

				inputFile.setSubmittedValue(bridgeUploadedFiles);

				// Queue the FileUploadEvent so that each uploaded file can be handled individually with an
				// ActionListener.
				for (UploadedFile uploadedFile : uploadedFiles) {

					FileUploadEvent fileUploadEvent = new FileUploadEvent(uiComponent, uploadedFile);
					uiComponent.queueEvent(fileUploadEvent);
				}
			}
		}
	}

	@Override
	public void encodeEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {

		ResponseWriter responseWriter = facesContext.getResponseWriter();
		DelegationResponseWriter delegationResponseWriter = new InputFileDelegationResponseWriter(responseWriter);
		super.encodeEnd(facesContext, uiComponent, delegationResponseWriter);
	}

	protected Map<String, List<UploadedFile>> getUploadedFileMap(FacesContext facesContext) {

		ContextMapFactory contextMapFactory = (ContextMapFactory) BridgeFactoryFinder.getFactory(
				ContextMapFactory.class);

		ExternalContext externalContext = facesContext.getExternalContext();
		PortletRequest portletRequest = (PortletRequest) externalContext.getRequest();

		return contextMapFactory.getUploadedFileMap(portletRequest);
	}
}
