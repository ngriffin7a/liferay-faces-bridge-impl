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
package com.liferay.faces.bridge.application.view.internal;

import javax.faces.FacesException;
import javax.faces.FacesWrapper;
import javax.portlet.MimeResponse;
import javax.portlet.faces.BridgeWriteBehindResponse;

import com.liferay.faces.bridge.config.BridgeConfig;


/**
 * @author  Neil Griffin
 */
public abstract class BridgeWriteBehindSupportFactory implements FacesWrapper<BridgeWriteBehindSupportFactory> {

	public abstract BridgeWriteBehindResponse getBridgeWriteBehindResponse(MimeResponse mimeResponse,
		BridgeConfig bridgeConfig) throws FacesException;
}
