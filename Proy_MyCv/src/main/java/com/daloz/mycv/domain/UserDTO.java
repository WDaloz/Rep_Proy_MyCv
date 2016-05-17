package com.daloz.mycv.domain;


import java.io.Serializable;

import com.daloz.mycv.domain.helper.ITextMutableObject;

@SuppressWarnings("serial")
public class UserDTO implements Serializable, ITextMutableObject
{

	private EmployeeDTO employeeDTO = new EmployeeDTO();

	private String name, password;
	private Boolean status;

	// get - set
	public EmployeeDTO getEmployeeDTO()
	{
		return employeeDTO;
	}

	public void setEmployeeDTO(EmployeeDTO employeeDTO)
	{
		this.employeeDTO = employeeDTO;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Boolean getStatus()
	{
		return status;
	}

	public void setStatus(Boolean status)
	{
		this.status = status;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}

}
