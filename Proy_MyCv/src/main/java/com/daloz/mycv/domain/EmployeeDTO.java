package com.daloz.mycv.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.daloz.mycv.domain.helper.ITextMutableObject;

@SuppressWarnings("serial")
public class EmployeeDTO implements Serializable, ITextMutableObject
{
	@SuppressWarnings("unused")
	private String name, lastName, maidenName, fullName, address, description, profile, email, phone, cellPhone, path;

	private List<EducationDTO> educationDTOs = new ArrayList<>();
	private List<IdiomDTO> idiomDTOs = new ArrayList<>();
	private List<InterestDTO> interestDTOs = new ArrayList<>();
	private List<SocialNetworkDTO> socialNetworkDTOs = new ArrayList<>();
	private List<CourseDTO> courseDTOs = new ArrayList<>();
	private List<WorkExperienceDTO> workExperienceDTOs = new ArrayList<>();

	private SkillDTO skillDTO = new SkillDTO();

	public EmployeeDTO()
	{
		super();
	}

	// get - set
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getMaidenName()
	{
		return maidenName;
	}

	public void setMaidenName(String maidenName)
	{
		this.maidenName = maidenName;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<EducationDTO> getEducationDTOs()
	{
		return educationDTOs;
	}

	public String getProfile()
	{
		return profile;
	}

	public void setProfile(String profile)
	{
		this.profile = profile;
	}

	public void setEducationDTOs(List<EducationDTO> educationDTOs)
	{
		this.educationDTOs = educationDTOs;
	}

	public List<IdiomDTO> getIdiomDTOs()
	{
		return idiomDTOs;
	}

	public void setIdiomDTOs(List<IdiomDTO> idiomDTOs)
	{
		this.idiomDTOs = idiomDTOs;
	}

	public List<InterestDTO> getInterestDTOs()
	{
		return interestDTOs;
	}

	public void setInterestDTOs(List<InterestDTO> interestDTOs)
	{
		this.interestDTOs = interestDTOs;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getCellPhone()
	{
		return cellPhone;
	}

	public void setCellPhone(String cellPhone)
	{
		this.cellPhone = cellPhone;
	}
	
	public String getFullName()
	{
		return fullName = name.concat(" ".concat(lastName).concat(" ".concat(maidenName)));
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public List<SocialNetworkDTO> getSocialNetworkDTOs()
	{
		return socialNetworkDTOs;
	}

	public void setSocialNetworkDTOs(List<SocialNetworkDTO> socialNetworkDTOs)
	{
		this.socialNetworkDTOs = socialNetworkDTOs;
	}

	public List<CourseDTO> getCourseDTOs()
	{
		return courseDTOs;
	}

	public void setCourseDTOs(List<CourseDTO> courseDTOs)
	{
		this.courseDTOs = courseDTOs;
	}

	public SkillDTO getSkillDTO()
	{
		return skillDTO;
	}

	public void setSkillDTO(SkillDTO skillDTO)
	{
		this.skillDTO = skillDTO;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}

	public List<WorkExperienceDTO> getWorkExperienceDTOs()
	{
		return workExperienceDTOs;
	}

	public void setWorkExperienceDTOs(List<WorkExperienceDTO> workExperienceDTOs)
	{
		this.workExperienceDTOs = workExperienceDTOs;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
	
	
}
