package com.daloz.mycv.domain;

import java.io.Serializable;
import java.util.Date;

import com.daloz.mycv.domain.helper.ITextMutableObject;

public class EducationDTO implements Serializable, ITextMutableObject
{
	private Date startDate, endDate;
	private String name;
	private String profession;
	private String grade;
	private String location;

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getProfession()
	{
		return profession;
	}

	public void setProfession(String profession)
	{
		this.profession = profession;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}

}
