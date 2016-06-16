package com.daloz.mycv.managedbean;



import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.daloz.mycv.domain.EmployeeDTO;
import com.daloz.mycv.managedbean.helper.RecapchaGoogle;
import com.daloz.mycv.managedbean.helper.SpringUtil;
import com.daloz.mycv.service.ISecurityService;




@ManagedBean
@SessionScoped
public class MainManagedBean extends GenericManagedBean
{
	private ISecurityService iSecurityService;
	private EmployeeDTO employeeDTO = new EmployeeDTO();
	private String name, email, message;
	

	@PostConstruct
	public void init()
	{
		iSecurityService = SpringUtil.getSpringBean("iSecurityService");
		employeeDTO = iSecurityService.getUser().getEmployeeDTO();

	}

	
	public void sendMessage() throws IOException
	{
		
		if(RecapchaGoogle.validateRecaptcha(getRequest().getParameter("g-recaptcha-response")))
		{
			 sendEmail(name, email, message);
			
		}
		
	}
	

	public ISecurityService getiSecurityService()
	{
		return iSecurityService;
	}

	public void setiSecurityService(ISecurityService iSecurityService)
	{
		this.iSecurityService = iSecurityService;
	}

	public EmployeeDTO getEmployeeDTO()
	{
		return employeeDTO;
	}

	public void setEmployeeDTO(EmployeeDTO employeeDTO)
	{
		this.employeeDTO = employeeDTO;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}


	
}
