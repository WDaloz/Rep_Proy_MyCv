package com.daloz.mycv.dao;


import org.apache.log4j.Logger;

import com.daloz.libfiles.config.enums.FileTypes;
import com.daloz.libfiles.core.IFileManager;
import com.daloz.libfiles.factoryservices.FileManagerFactory;

public class GenericDAO
{
	protected static Logger logger = null;
	protected IFileManager iFileManager = null;
	
	public void setLogger(Class<?> clazz)
	{
		logger = Logger.getLogger(clazz);
	}
	
	public void setFileManager()
	{
		iFileManager = FileManagerFactory.getFileManager(FileTypes.XML_FILE);
	}
	
}
