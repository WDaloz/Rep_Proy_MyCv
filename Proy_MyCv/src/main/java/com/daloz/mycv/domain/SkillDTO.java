package com.daloz.mycv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.daloz.mycv.domain.helper.ITextMutableObject;

public class SkillDTO implements Serializable, ITextMutableObject
{

	private List<String> patterns = new ArrayList<>();
	private List<String> principlesPractices = new ArrayList<>();
	private List<String> technologies = new ArrayList<>();
	private List<LanguajeDTO> LanguajeDTOs = new ArrayList<>();
	private List<ToolDTO> toolDTOs = new ArrayList<>();
	private List<FrameworkDTO> frameworkDTOs = new ArrayList<>();
	private List<DataBaseDTO> dataBaseDTOs = new ArrayList<>();

	public List<DataBaseDTO> getDataBaseDTOs()
	{
		return dataBaseDTOs;
	}

	public void setDataBaseDTOs(List<DataBaseDTO> dataBaseDTOs)
	{
		this.dataBaseDTOs = dataBaseDTOs;
	}

	public List<String> getPatterns()
	{
		return patterns;
	}

	public void setPatterns(List<String> patterns)
	{
		this.patterns = patterns;
	}

	public List<String> getPrinciplesPractices()
	{
		return principlesPractices;
	}

	public void setPrinciplesPractices(List<String> principlesPractices)
	{
		this.principlesPractices = principlesPractices;
	}

	public List<String> getTechnologies()
	{
		return technologies;
	}

	public void setTechnologies(List<String> technologies)
	{
		this.technologies = technologies;
	}

	public List<LanguajeDTO> getLanguajeDTOs()
	{
		return LanguajeDTOs;
	}

	public void setLanguajeDTOs(List<LanguajeDTO> languajeDTOs)
	{
		LanguajeDTOs = languajeDTOs;
	}

	public List<ToolDTO> getToolDTOs()
	{
		return toolDTOs;
	}

	public void setToolDTOs(List<ToolDTO> toolDTOs)
	{
		this.toolDTOs = toolDTOs;
	}

	public List<FrameworkDTO> getFrameworkDTOs()
	{
		return frameworkDTOs;
	}

	public void setFrameworkDTOs(List<FrameworkDTO> frameworkDTOs)
	{
		this.frameworkDTOs = frameworkDTOs;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}

}
