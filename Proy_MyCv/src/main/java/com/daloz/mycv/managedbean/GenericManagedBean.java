package com.daloz.mycv.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class GenericManagedBean
{
	protected Logger logger = null;

	public String getView(String... arg)
	{
		if (arg.length == 1)
		{
			return "pages/adm/" + arg[0] + ".xhtml?faces-redirect=true";
		}
		else
		{
			return "pages/adm/" + arg[0] + "/" + arg[1] + ".xhtml?faces-redirect=true";
		}
	}

	public void setAttributeSession(String name, Object object)
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		session.setAttribute(name, object);
	}

	public Object getAttributeSession(String name)
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		Object object = session.getAttribute(name);

		return object;
	}

	public void removeAttributeSession(String name)
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		session.removeAttribute(name);
	}

	public void addMessage(UIComponent uiComponent, String message)
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(message);
		facesContext.addMessage(uiComponent.getClientId(facesContext), facesMessage);
	}

	// -------- get / set ------------
	public void setLogger(Class<?> clazz)
	{
		logger = Logger.getLogger(clazz);
	}

}
