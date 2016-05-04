package com.daloz.mycv.config;

public enum SysConstants
{
	PATH("D:/UserDTO.xml");

	String path;

	private SysConstants(String path)
	{
		this.path = path;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

}
