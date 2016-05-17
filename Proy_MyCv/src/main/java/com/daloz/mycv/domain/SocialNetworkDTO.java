package com.daloz.mycv.domain;

import java.io.Serializable;

import com.daloz.mycv.domain.helper.ITextMutableObject;

public class SocialNetworkDTO  implements Serializable, ITextMutableObject
{
	private String link, path;

	public SocialNetworkDTO()
	{

	}

	public SocialNetworkDTO(String link, String path)
	{
		super();
		this.link = link;
		this.path = path;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}

}
