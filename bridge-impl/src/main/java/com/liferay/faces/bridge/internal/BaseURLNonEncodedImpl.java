/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.bridge.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

import javax.portlet.BaseURL;
import javax.portlet.PortletSecurityException;


/**
 * This class represents a non-encoded {@link BaseURL}, meaning an implementation that simply decorates a URI without
 * providing any encoding.
 *
 * @author  Neil Griffin
 */
public class BaseURLNonEncodedImpl implements BaseURL {

	// Private Data Members
	private BridgeURI bridgeURI;

	public BaseURLNonEncodedImpl(BridgeURI bridgeURI) {
		this.bridgeURI = bridgeURI;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return bridgeURI.getParameterMap();
	}

	@Override
	public void setParameter(String name, String value) {
		bridgeURI.setParameter(name, value);
	}

	@Override
	public void setParameter(String name, String[] values) {
		bridgeURI.setParameter(name, values);
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {

		Map<String, String[]> parameterMap = bridgeURI.getParameterMap();
		parameterMap.clear();

		Set<Map.Entry<String, String[]>> entrySet = parameters.entrySet();

		for (Map.Entry<String, String[]> mapEntry : entrySet) {
			parameterMap.put(mapEntry.getKey(), mapEntry.getValue());
		}
	}

	@Override
	public void setProperty(String key, String value) {
		// no-op
	}

	@Override
	public void setSecure(boolean secure) throws PortletSecurityException {
		// no-op
	}

	@Override
	public void addProperty(String key, String value) {
		// no-op
	}

	@Override
	public String toString() {
		return bridgeURI.toString();
	}

	@Override
	public void write(Writer out) throws IOException {
		write(out, true);
	}

	@Override
	public void write(Writer out, boolean escapeXML) throws IOException {

		String uri = bridgeURI.toString();

		if (escapeXML) {

			char[] tokens = new char[] { '<', '>', '&', '"', '\'', '\u00bb', '\u2013', '\u2014' };
			String[] replacements = new String[] {
					"&lt;", "&gt;", "&amp;", "&#034;", "&#039;", "&#187;", "&#x2013;", "&#x2014;"
				};

			for (int i = 0; i < tokens.length; i++) {
				String token = new String(new char[] { tokens[i] });
				String replacement = replacements[i];
				uri = uri.replace(token, replacement);
			}
		}

		out.write(uri);
	}
}