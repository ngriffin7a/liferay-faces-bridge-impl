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

import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;
import javax.portlet.faces.Bridge;


/**
 * @author  Neil Griffin
 */
public class ViewUtil {

	/**
	 * <p>Returns an immutable {@link Map} whose keys are determined by {@link PortletMode#toString()} and whose values
	 * are retrieved from the following sections of the WEB-INF/portlet.xml descriptor.</p>
	 * <code>
	 * <pre>
	 &lt;init-param&gt;
	 &lt;name&gt;javax.portlet.faces.defaultViewId.view&lt;/name&gt;
	 &lt;value&gt;/xhtml/portletViewMode.xhtml&lt;/value&gt;
	 &lt;/init-param&gt;
	 &lt;init-param&gt;
	 &lt;name&gt;javax.portlet.faces.defaultViewId.edit&lt;/name&gt;
	 &lt;value&gt;/xhtml/portletEditMode.xhtml&lt;/value&gt;
	 &lt;/init-param&gt;
	 &lt;init-param&gt;
	 &lt;name&gt;javax.portlet.faces.defaultViewId.help&lt;/name&gt;
	 &lt;value&gt;/xhtml/portletHelpMode.xhtml&lt;/value&gt;
	 &lt;/init-param&gt;
	 * </pre>
	 * </code>
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getDefaultViewIdMap(PortletConfig portletConfig) {

		String portletName = portletConfig.getPortletName();
		String attrNameDefaultViewIdMap = Bridge.BRIDGE_PACKAGE_PREFIX + portletName + "." + Bridge.DEFAULT_VIEWID_MAP;
		PortletContext portletContext = portletConfig.getPortletContext();

		return (Map<String, String>) portletContext.getAttribute(attrNameDefaultViewIdMap);
	}
}
