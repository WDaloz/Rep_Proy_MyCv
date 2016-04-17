package com.daloz.mycv.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.daloz.mycv.domain.helper.ITextMutableObject;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_user")
public class UserDTO implements Serializable, ITextMutableObject
{

	@Id
	@OneToOne
	@JoinColumn(name = "idEmployee")
	private EmployeeDTO employeeDTO = new EmployeeDTO();

	private String code, name, password;
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

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
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
