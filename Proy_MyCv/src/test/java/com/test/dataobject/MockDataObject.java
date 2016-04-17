package com.test.dataobject;

import com.daloz.mycv.domain.helper.ITextMutableObject;

public class MockDataObject implements ITextMutableObject
{
	private Long id;
	private String code;
	private String descripcion;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}

}