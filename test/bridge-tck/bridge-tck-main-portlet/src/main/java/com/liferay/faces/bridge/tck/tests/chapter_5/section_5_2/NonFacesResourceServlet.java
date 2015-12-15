/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
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
package com.liferay.faces.bridge.tck.tests.chapter_5.section_5_2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author  Michael Freedman
 */
public class NonFacesResourceServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getAttribute("javax.servlet.forward.request_uri") != null) {
			request.getSession(true).setAttribute("com.liferay.faces.bridge.tck.NonFacesResourceInvokedInForward",
				Boolean.TRUE);
		}
		else {
			request.getSession(true).setAttribute("com.liferay.faces.bridge.tck.NonFacesResourceInvokedInForward",
				Boolean.FALSE);
		}
	}

}