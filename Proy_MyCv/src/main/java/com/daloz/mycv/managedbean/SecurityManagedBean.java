package com.daloz.mycv.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;

import com.daloz.mycv.domain.UserDTO;
import static com.daloz.mycv.managedbean.helper.EncryptingString.*;
import static com.daloz.mycv.managedbean.helper.HashTypes.*;
import static com.daloz.mycv.managedbean.helper.SpringUtil.*;
import com.daloz.mycv.service.ISecurityService;

@ManagedBean
@SessionScoped
public class SecurityManagedBean extends GenericManagedBean
{
	private UserDTO userDTO = new UserDTO();

	private ISecurityService iSecurityService;

	private UIComponent btnLogin;

	@PostConstruct
	public void init()
	{
		iSecurityService = getSpringBean("iSecurityService");
		setLogger(SecurityManagedBean.class);

	}

	public String validateLogin()
	{
		userDTO.setPassword(encriptPassword(userDTO.getPassword(), SHA_512));
		UserDTO userValidate = iSecurityService.validateUser(userDTO);

		if (userValidate != null)
		{
			setAttributeSession("user", userValidate);
			
			return "main.xhtml";
		}
		addMessage(btnLogin, "Error con los datos");
		
		return "login.xhtml";
	}

	public UserDTO getUserDTO()
	{
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO)
	{
		this.userDTO = userDTO;
	}

	public ISecurityService getiSecurityService()
	{
		return iSecurityService;
	}

	public void setiSecurityService(ISecurityService iSecurityService)
	{
		this.iSecurityService = iSecurityService;
	}

	public UIComponent getBtnLogin()
	{
		return btnLogin;
	}

	public void setBtnLogin(UIComponent btnLogin)
	{
		this.btnLogin = btnLogin;
	}
	
	

}
