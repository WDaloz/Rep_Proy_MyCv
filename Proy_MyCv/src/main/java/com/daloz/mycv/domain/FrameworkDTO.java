package com.daloz.mycv.domain;

import java.io.Serializable;

import com.daloz.mycv.domain.helper.ITextMutableObject;

@SuppressWarnings("serial")
public class FrameworkDTO implements Serializable, ITextMutableObject
{
	private String name, level;
	private Integer valueRating;

	public FrameworkDTO()
	{
		super();
	}

	public FrameworkDTO(String name, String level, Integer valueRating)
	{
		super();
		this.name = name;
		this.level = level;
		this.valueRating = valueRating;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLevel()
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	public Integer getValueRating()
	{
		return valueRating;
	}

	public void setValueRating(Integer valueRating)
	{
		this.valueRating = valueRating;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}
}
