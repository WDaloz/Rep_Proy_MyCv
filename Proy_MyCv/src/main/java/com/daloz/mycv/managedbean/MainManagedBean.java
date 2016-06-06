package com.daloz.mycv.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.daloz.mycv.domain.EmployeeDTO;
import com.daloz.mycv.managedbean.helper.SpringUtil;
import com.daloz.mycv.service.ISecurityService;

@ManagedBean
@SessionScoped
public class MainManagedBean extends GenericManagedBean
{
	private ISecurityService iSecurityService;
	private EmployeeDTO employeeDTO = new EmployeeDTO();

	@PostConstruct
	public void init()
	{
		iSecurityService = SpringUtil.getSpringBean("iSecurityService");
		employeeDTO = iSecurityService.getUser().getEmployeeDTO();

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

}
