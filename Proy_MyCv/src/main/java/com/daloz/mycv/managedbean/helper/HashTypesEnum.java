package com.daloz.mycv.managedbean.helper;

public enum HashTypesEnum
{
	SHA_224("SHA-224"),SHA_256("SHA-256"), SHA_384("SHA-384"), SHA_512("SHA-512"),
	MD2("MD2"), MD4("MD4"), MD5("MD5");
	
	private String description;
	
	private HashTypesEnum(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	
	
	
}
