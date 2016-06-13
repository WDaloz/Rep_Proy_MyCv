package com.daloz.mycv.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.daloz.factorymail.config.enums.EmailType;
import com.daloz.factorymail.core.IMailManager;
import com.daloz.factorymail.factoryservice.FactoryMailManager;
import com.daloz.factorymail.objects.Email;
import com.daloz.mycv.domain.EmployeeDTO;
import com.daloz.mycv.managedbean.helper.SpringUtil;
import com.daloz.mycv.service.ISecurityService;

@ManagedBean
@SessionScoped
public class MainManagedBean extends GenericManagedBean
{
	private ISecurityService iSecurityService;
	private EmployeeDTO employeeDTO = new EmployeeDTO();
	private String message = "";

	@PostConstruct
	public void init()
	{
		iSecurityService = SpringUtil.getSpringBean("iSecurityService");
		employeeDTO = iSecurityService.getUser().getEmployeeDTO();

	}

	public void sendMessage()
	{

		Email eMail = new Email();

		eMail.setFrom("medikidsm@gmail.com");
		eMail.setPassword("ggronxubhzbcdgfg");

		eMail.setRecipientTO("cristhianp00@gmail.com");
		eMail.setSubject("Contacto del Cv");
		eMail.setText(message);

		IMailManager iMailManager = FactoryMailManager.getGenericMailManager(EmailType.GMAIL);

		iMailManager.sendMail(eMail);

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

}
