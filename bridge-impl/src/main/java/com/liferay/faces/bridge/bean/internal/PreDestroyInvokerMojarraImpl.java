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
package com.liferay.faces.bridge.bean.internal;

import java.lang.reflect.Method;

import javax.portlet.PortletContext;
import javax.servlet.ServletContext;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;


/**
 * Mojarra has a vendor-specific Service Provider Interface (SPI) for dependency injection called the InjectionProvider.
 * This class provides the ability to leverage the InjectionProvider instance for invoking methods annotated with {@link
 * javax.annotation.PreDestroy}.
 *
 * @author  Neil Griffin
 */
public class PreDestroyInvokerMojarraImpl extends PreDestroyInvokerImpl {

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(PreDestroyInvokerMojarraImpl.class);

	// Private Constants
	private static final String INVOKE_PRE_DESTROY = "invokePreDestroy";

	// Private Data Members
	private Method invokePreDestroyMethod;
	private Object mojarraInjectionProvider;

	public PreDestroyInvokerMojarraImpl(ServletContext servletContext) {
		init(new ContextAdapter(servletContext));
	}

	public PreDestroyInvokerMojarraImpl(PortletContext portletContext) {
		init(new ContextAdapter(portletContext));
	}

	@Override
	public void invokeAnnotatedMethods(Object managedBean, boolean preferPreDestroy) {

		if (preferPreDestroy) {

			if (invokePreDestroyMethod != null) {

				try {
					logger.debug(
						"Invoking methods annotated with @PreDestroy: mojarraInjectionProvider=[{0}] managedBean=[{1}]",
						mojarraInjectionProvider, managedBean);
					invokePreDestroyMethod.invoke(mojarraInjectionProvider, managedBean);
				}
				catch (Exception e) {
					logger.error(e);
				}
			}
			else {
				super.invokeAnnotatedMethods(managedBean, preferPreDestroy);
			}
		}
		else {
			super.invokeAnnotatedMethods(managedBean, preferPreDestroy);
		}
	}

	@Override
	public String toString() {
		return mojarraInjectionProvider.toString();
	}

	private void init(ContextAdapter contextAdapter) {
		this.mojarraInjectionProvider = getInjectionProvider(contextAdapter);

		try {
			this.invokePreDestroyMethod = mojarraInjectionProvider.getClass().getMethod(INVOKE_PRE_DESTROY,
					new Class[] { Object.class });
		}
		catch (Exception e) {
			logger.error(e);
		}

	}

	protected Object getInjectionProvider(ContextAdapter contextAdapter) {

		try {

			Object applicationAssociate = contextAdapter.getAttribute("com.sun.faces.ApplicationAssociate");

			// If the ApplicationAssociate instance is available, then return the InjectionProvider that it knows about.
			if (applicationAssociate != null) {

				// Note that the ApplicationAssociate instance will be available during startup if the Mojarra
				// ConfigureListener executes prior to the BridgeSessionListener. It will also be available during
				// execution of the JSF lifecycle.
				Method getInjectionProviderMethod = applicationAssociate.getClass().getMethod("getInjectionProvider",
						new Class[] {});
				Object mojarraInjectionProvider = getInjectionProviderMethod.invoke(applicationAssociate,
						new Object[] {});

				logger.debug("mojarraInjectionProvider=[{0}]", mojarraInjectionProvider);

				return mojarraInjectionProvider;
			}

			// Otherwise, return null.
			else {

				// Note that the ApplicationAssociate instance will be null if this method is called during startup and
				// the BridgeSessionListener executes prior to the Mojarra ConfigureListener. This can be remedied by
				// explicitly specifying com.sun.faces.config.ConfigureListener as a listener in the WEB-INF/web.xml
				// descriptor.
				return null;
			}
		}
		catch (Exception e) {
			logger.error(e);

			return null;
		}
	}

	private static class ContextAdapter {

		private PortletContext portletContext;
		private ServletContext servletContext;

		public ContextAdapter(PortletContext portletContext) {
			this.portletContext = portletContext;
		}

		public ContextAdapter(ServletContext servletContext) {
			this.servletContext = servletContext;
		}

		public Object getAttribute(String name) {

			if (portletContext != null) {
				return portletContext.getAttribute(name);
			}
			else if (servletContext != null) {
				return servletContext.getAttribute(name);
			}
			else {
				return null;
			}
		}
	}
}
