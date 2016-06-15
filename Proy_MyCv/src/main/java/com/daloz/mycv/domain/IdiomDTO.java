package com.daloz.mycv.domain;

import java.io.Serializable;

import com.daloz.mycv.domain.helper.ITextMutableObject;

@SuppressWarnings("serial")
public class IdiomDTO implements Serializable, ITextMutableObject
{
	private String name;
	private String nivel;

	public IdiomDTO()
	{

	}

	public IdiomDTO(String name, String nivel)
	{
		super();
		this.name = name;
		this.nivel = nivel;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getNivel()
	{
		return nivel;
	}

	public void setNivel(String nivel)
	{
		this.nivel = nivel;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}

}
