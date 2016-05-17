package com.daloz.mycv.domain;

import java.io.Serializable;

import com.daloz.mycv.domain.helper.ITextMutableObject;

public class InterestDTO implements Serializable, ITextMutableObject
{
	private String name, description;

	public InterestDTO()
	{
		
	}

	public InterestDTO(String name, String description)
	{
		super();
		this.name = name;
		this.description = description;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}
}
