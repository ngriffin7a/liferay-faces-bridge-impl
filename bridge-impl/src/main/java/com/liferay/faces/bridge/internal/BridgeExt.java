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
package com.liferay.faces.bridge.internal;

/**
 * @author  Neil Griffin
 */
public interface BridgeExt {

	public static final String FACES_AJAX_PARAMETER = "_jsfBridgeAjax";
	public static final String RENDER_REDIRECT = "com.liferay.faces.bridge.renderRedirect";
	public static final String RENDER_REDIRECT_AFTER_DISPATCH = "com.liferay.faces.bridge.renderRedirectAfterDispatch";
	public static final String RENDER_REDIRECT_VIEW_ID = "com.liferay.faces.bridge.renderRedirectViewId";
	public static final String RESPONSE_CHARACTER_ENCODING = "com.liferay.faces.bridge.responseCharacterEncoding";
}
