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
package com.liferay.faces.bridge.component.icefaces;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.ActionSource;
import javax.faces.component.ContextCallback;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UIData;
import javax.faces.component.UIPanel;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionListener;
import javax.faces.event.FacesEvent;

import com.liferay.faces.util.helper.Wrapper;


/**
 * This class is part of a workaround for <a href="http://jira.icesoft.org/browse/ICE-6398">ICE-6398</a>.
 *
 * @author  Neil Griffin
 */
public abstract class DataPaginatorWrapper extends DataPaginator implements Wrapper<Object> {

	// Private Data Members
	private String rendererType;

	@Override
	public abstract UIData findUIData(FacesContext facesContext) throws Exception;

	@Override
	public void addActionListener(ActionListener listener) {
		((ActionSource) getWrapped()).addActionListener(listener);
	}

	@Override
	public void broadcast(FacesEvent event) throws AbortProcessingException {
		((UIComponentBase) getWrapped()).broadcast(event);
	}

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		((UIComponent) getWrapped()).encodeAll(context);
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		((UIComponentBase) getWrapped()).encodeBegin(context);
	}

	@Override
	public void encodeChildren(FacesContext context) throws IOException {
		((UIComponentBase) getWrapped()).encodeChildren(context);
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		((UIComponentBase) getWrapped()).encodeEnd(context);
	}

	@Override
	public UIComponent findComponent(String expr) {
		return ((UIComponentBase) getWrapped()).findComponent(expr);
	}

	@Override
	public String getscrollButtonCellClass() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getscrollButtonCellClass", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void gotoFastForward() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("gotoFastForward", new Class[] {});
			method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void gotoFastRewind() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("gotoFastRewind", new Class[] {});
			method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void gotoFirstPage() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("gotoFirstPage", new Class[] {});
			method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void gotoLastPage() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("gotoLastPage", new Class[] {});
			method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void gotoNextPage() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("gotoNextPage", new Class[] {});
			method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void gotoPreviousPage() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("gotoPreviousPage", new Class[] {});
			method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public boolean invokeOnComponent(FacesContext context, String clientId, ContextCallback callback)
		throws FacesException {
		return ((UIComponentBase) getWrapped()).invokeOnComponent(context, clientId, callback);
	}

	@Override
	public void processDecodes(FacesContext context) {
		super.processDecodes(context);
	}

	@Override
	public void processRestoreState(FacesContext context, Object state) {
		((UIComponentBase) getWrapped()).processRestoreState(context, state);
	}

	@Override
	public Object processSaveState(FacesContext context) {
		return ((UIComponentBase) getWrapped()).processSaveState(context);
	}

	@Override
	public void processUpdates(FacesContext context) {
		((UIComponentBase) getWrapped()).processUpdates(context);
	}

	@Override
	public void processValidators(FacesContext context) {
		((UIComponentBase) getWrapped()).processValidators(context);
	}

	@Override
	public void queueEvent(FacesEvent event) {
		((UIComponentBase) getWrapped()).queueEvent(event);
	}

	@Override
	public void removeActionListener(ActionListener listener) {
		((ActionSource) getWrapped()).removeActionListener(listener);
	}

	@Override
	public void restoreState(FacesContext context, Object state) {
		((UIComponentBase) getWrapped()).restoreState(context, state);
	}

	@Override
	public Object saveState(FacesContext context) {
		return ((UIComponentBase) getWrapped()).saveState(context);
	}

	@SuppressWarnings("deprecation")
	@Override
	public javax.faces.el.MethodBinding getAction() {
		return ((ActionSource) getWrapped()).getAction();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setAction(javax.faces.el.MethodBinding action) {
		((ActionSource) getWrapped()).setAction(action);
	}

	@SuppressWarnings("deprecation")
	@Override
	public javax.faces.el.MethodBinding getActionListener() {
		return ((ActionSource) getWrapped()).getActionListener();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setActionListener(javax.faces.el.MethodBinding actionListener) {
		((ActionSource) getWrapped()).setActionListener(actionListener);
	}

	@Override
	public ActionListener[] getActionListeners() {
		return ((ActionSource) getWrapped()).getActionListeners();
	}

	@Override
	public Map<String, Object> getAttributes() {
		return ((UIComponentBase) getWrapped()).getAttributes();
	}

	@Override
	public String getBaseStyleClass() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getBaseStyleClass", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public int getChildCount() {
		return ((UIComponentBase) getWrapped()).getChildCount();
	}

	@Override
	public List<UIComponent> getChildren() {
		return ((UIComponentBase) getWrapped()).getChildren();
	}

	@Override
	public String getClientId(FacesContext context) {
		return ((UIComponentBase) getWrapped()).getClientId(context);
	}

	@Override
	public String getComponentType() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getComponentType", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getContainerClientId(FacesContext context) {
		return ((UIComponent) getWrapped()).getContainerClientId(context);
	}

	@Override
	public boolean isDisabled() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("isDisabled", new Class[] {});

			return (Boolean) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public boolean isKeyboardNavigationEnabled() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("isKeyboardNavigationEnabled", new Class[] {});

			return (Boolean) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public boolean isRendered() {
		return ((UIComponentBase) getWrapped()).isRendered();
	}

	@Override
	public void setDisabled(boolean disabled) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setDisabled", new Class[] { boolean.class });
			method.invoke(wrappedDataPaginator, new Object[] { disabled });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getDisplayedRowsCountVar() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getDisplayedRowsCountVar", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setDisplayedRowsCountVar(String displayedRowsCountVar) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setDisplayedRowsCountVar",
					new Class[] { String.class });
			method.invoke(wrappedDataPaginator, new Object[] { displayedRowsCountVar });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public boolean isImmediate() {
		return ((ActionSource) getWrapped()).isImmediate();
	}

	@Override
	public boolean isLastPage() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("isLastPage", new Class[] {});

			return (Boolean) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public boolean isRenderFacetsIfSinglePage() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("isRenderFacetsIfSinglePage", new Class[] {});

			return (Boolean) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getEnabledOnUserRole() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getEnabledOnUserRole", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setEnabledOnUserRole(String enabledOnUserRole) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setEnabledOnUserRole",
					new Class[] { String.class });
			method.invoke(wrappedDataPaginator, new Object[] { enabledOnUserRole });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public UIComponent getFacet(String name) {
		return ((UIComponentBase) getWrapped()).getFacet(name);
	}

	@Override
	public int getFacetCount() {
		return ((UIComponentBase) getWrapped()).getFacetCount();
	}

	@Override
	public Map<String, UIComponent> getFacets() {
		return ((UIComponentBase) getWrapped()).getFacets();
	}

	@Override
	public Iterator<UIComponent> getFacetsAndChildren() {
		return ((UIComponentBase) getWrapped()).getFacetsAndChildren();
	}

	@Override
	public String getFamily() {
		return ((UIPanel) getWrapped()).getFamily();
	}

	@Override
	public UIComponent getFastForward() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getFastForward", new Class[] {});

			return (UIComponent) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setFastForward(UIComponent previous) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setFastForward",
					new Class[] { UIComponent.class });
			method.invoke(wrappedDataPaginator, new Object[] { previous });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public UIComponent getFastRewind() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getFastRewind", new Class[] {});

			return (UIComponent) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setFastRewind(UIComponent previous) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setFastRewind",
					new Class[] { UIComponent.class });
			method.invoke(wrappedDataPaginator, new Object[] { previous });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public int getFastStep() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getFastStep", new Class[] {});

			return (Integer) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setFastStep(int fastStep) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setFastStep", new Class[] { int.class });
			method.invoke(wrappedDataPaginator, new Object[] { fastStep });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public UIComponent getFirst() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getFirst", new Class[] {});

			return (UIComponent) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setFirst(UIComponent first) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setFirst", new Class[] { UIComponent.class });
			method.invoke(wrappedDataPaginator, new Object[] { first });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public int getFirstRow() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getFirstRow", new Class[] {});

			return (Integer) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getFirstRowIndexVar() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getFirstRowIndexVar", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setFirstRowIndexVar(String firstRowIndexVar) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setFirstRowIndexVar",
					new Class[] { String.class });
			method.invoke(wrappedDataPaginator, new Object[] { firstRowIndexVar });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getFor() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getFor", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setFor(String forValue) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setFor", new Class[] { String.class });
			method.invoke(wrappedDataPaginator, new Object[] { forValue });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getId() {
		return ((UIComponentBase) getWrapped()).getId();
	}

	@Override
	public void setId(String id) {
		((UIComponentBase) getWrapped()).setId(id);
	}

	@Override
	public void setImmediate(boolean immediate) {
		((ActionSource) getWrapped()).setImmediate(immediate);
	}

	@Override
	public void setKeyboardNavigationEnabled(boolean keyboardNavigationEnabled) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setKeyboardNavigationEnabled",
					new Class[] { boolean.class });
			method.invoke(wrappedDataPaginator, new Object[] { keyboardNavigationEnabled });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public boolean isVertical() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("isVertical", new Class[] {});

			return (Boolean) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public UIComponent getLast() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getLast", new Class[] {});

			return (UIComponent) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setLast(UIComponent last) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setLast", new Class[] { UIComponent.class });
			method.invoke(wrappedDataPaginator, new Object[] { last });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getLastRowIndexVar() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getLastRowIndexVar", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setLastRowIndexVar(String lastRowIndexVar) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setLastRowIndexVar",
					new Class[] { String.class });
			method.invoke(wrappedDataPaginator, new Object[] { lastRowIndexVar });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getLayout() {
		return ((HtmlPanelGroup) getWrapped()).getLayout();
	}

	@Override
	public void setLayout(String layout) {
		((HtmlPanelGroup) getWrapped()).setLayout(layout);
	}

	@Override
	public UIComponent getNext() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getNext", new Class[] {});

			return (UIComponent) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setNext(UIComponent next) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setNext", new Class[] { UIComponent.class });
			method.invoke(wrappedDataPaginator, new Object[] { next });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public int getPageCount() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getPageCount", new Class[] {});

			return (Integer) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getPageCountVar() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getPageCountVar", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setPageCountVar(String pageCountVar) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setPageCountVar", new Class[] { String.class });
			method.invoke(wrappedDataPaginator, new Object[] { pageCountVar });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public int getPageIndex() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getPageIndex", new Class[] {});

			return (Integer) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getPageIndexVar() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getPageIndexVar", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setPageIndexVar(String pageIndexVar) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setPageIndexVar", new Class[] { String.class });
			method.invoke(wrappedDataPaginator, new Object[] { pageIndexVar });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setPaginator(boolean paginator) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setPaginator", new Class[] { boolean.class });
			method.invoke(wrappedDataPaginator, new Object[] { paginator });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getPaginatorActiveColumnClass() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getPaginatorActiveColumnClass", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getPaginatorColumnClass() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getPaginatorColumnClass", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public int getPaginatorMaxPages() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getPaginatorMaxPages", new Class[] {});

			return (Integer) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setPaginatorMaxPages(int paginatorMaxPages) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setPaginatorMaxPages",
					new Class[] { int.class });
			method.invoke(wrappedDataPaginator, new Object[] { paginatorMaxPages });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getPaginatorTableClass() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getPaginatorTableClass", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public UIComponent getParent() {
		return ((UIComponentBase) getWrapped()).getParent();
	}

	@Override
	public void setParent(UIComponent parent) {
		((UIComponentBase) getWrapped()).setParent(parent);
	}

	@Override
	public UIComponent getPrevious() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getPrevious", new Class[] {});

			return (UIComponent) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setPrevious(UIComponent previous) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setPrevious", new Class[] { UIComponent.class });
			method.invoke(wrappedDataPaginator, new Object[] { previous });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public boolean isPaginator() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("isPaginator", new Class[] {});

			return (Boolean) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setRendered(boolean rendered) {
		((UIComponentBase) getWrapped()).setRendered(rendered);
	}

	@Override
	public String getRenderedOnUserRole() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getRenderedOnUserRole", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setRenderedOnUserRole(String renderedOnUserRole) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setRenderedOnUserRole",
					new Class[] { String.class });
			method.invoke(wrappedDataPaginator, new Object[] { renderedOnUserRole });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getRendererType() {
		UIComponentBase wrappedUIComponentBase = (UIComponentBase) getWrapped();

		if (wrappedUIComponentBase != null) {
			return wrappedUIComponentBase.getRendererType();
		}
		else {
			return rendererType;
		}
	}

	@Override
	public void setRendererType(String rendererType) {

		UIComponentBase wrappedUIComponentBase = (UIComponentBase) getWrapped();

		if (wrappedUIComponentBase != null) {
			wrappedUIComponentBase.setRendererType(rendererType);
		}
		else {

			// Note: This method gets called from the UIInput constructor at which time there is not yet a wrapped
			// UIInput.
			this.rendererType = rendererType;
		}
	}

	@Override
	public void setRenderFacetsIfSinglePage(boolean renderFacetsIfSinglePage) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setRenderFacetsIfSinglePage",
					new Class[] { boolean.class });
			method.invoke(wrappedDataPaginator, new Object[] { renderFacetsIfSinglePage });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public boolean getRendersChildren() {
		return ((UIComponentBase) getWrapped()).getRendersChildren();
	}

	@Override
	public int getRowCount() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getRowCount", new Class[] {});

			return (Integer) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public int getRows() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getRows", new Class[] {});

			return (Integer) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getRowsCountVar() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getRowsCountVar", new Class[] {});

			return (String) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setRowsCountVar(String rowsCountVar) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setRowsCountVar", new Class[] { String.class });
			method.invoke(wrappedDataPaginator, new Object[] { rowsCountVar });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String getStyle() {
		return ((HtmlPanelGroup) getWrapped()).getStyle();
	}

	@Override
	public void setStyle(String style) {
		((HtmlPanelGroup) getWrapped()).setStyle(style);
	}

	@Override
	public String getStyleClass() {
		return ((HtmlPanelGroup) getWrapped()).getStyleClass();
	}

	@Override
	public void setStyleClass(String styleClass) {
		((HtmlPanelGroup) getWrapped()).setStyleClass(styleClass);
	}

	@Override
	public boolean isModelResultSet() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("isModelResultSet", new Class[] {});

			return (Boolean) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public boolean isTransient() {
		return ((UIComponentBase) getWrapped()).isTransient();
	}

	@Override
	public int getTabindex() {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getTabindex", new Class[] {});

			return (Integer) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setTabindex(int tabindex) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setTabindex", new Class[] { int.class });
			method.invoke(wrappedDataPaginator, new Object[] { tabindex });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setTransient(boolean transientFlag) {
		((UIComponentBase) getWrapped()).setTransient(transientFlag);
	}

	@Override
	public UIData getUIData() throws Exception {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("getUIData", new Class[] {});

			return (UIData) method.invoke(wrappedDataPaginator, new Object[] {});
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void setUIData(UIData uiData) throws Exception {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setUIData", new Class[] { UIData.class });
			method.invoke(wrappedDataPaginator, new Object[] { uiData });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public javax.faces.el.ValueBinding getValueBinding(String name) {
		return ((UIComponentBase) getWrapped()).getValueBinding(name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setValueBinding(String name, javax.faces.el.ValueBinding binding) {
		((UIComponentBase) getWrapped()).setValueBinding(name, binding);
	}

	@Override
	public ValueExpression getValueExpression(String name) {
		return ((UIComponent) getWrapped()).getValueExpression(name);
	}

	@Override
	public void setValueExpression(String name, ValueExpression binding) {
		((UIComponent) getWrapped()).setValueExpression(name, binding);
	}

	@Override
	public void setVertical(boolean vertical) {
		UIComponent wrappedDataPaginator = (UIComponent) getWrapped();

		try {
			Method method = wrappedDataPaginator.getClass().getMethod("setVertical", new Class[] { boolean.class });
			method.invoke(wrappedDataPaginator, new Object[] { vertical });
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public abstract Object getWrapped();

}