package com.daloz.mycv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.daloz.mycv.domain.helper.ITextMutableObject;

public class CourseDTO implements Serializable, ITextMutableObject
{
	private String name, descripcion, location;
	private Date starDate, endDate;
	private List<String> contents = new ArrayList<>();

	public CourseDTO()
	{
		super();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public Date getStarDate()
	{
		return starDate;
	}

	public void setStarDate(Date starDate)
	{
		this.starDate = starDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public List<String> getContents()
	{
		return contents;
	}

	public void setContents(List<String> contents)
	{
		this.contents = contents;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}

}
