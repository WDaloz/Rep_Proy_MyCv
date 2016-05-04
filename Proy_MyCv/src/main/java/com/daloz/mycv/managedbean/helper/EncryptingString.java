package com.daloz.mycv.managedbean.helper;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public class EncryptingString
{
	
	public static String encriptPassword(String password, HashTypes hashTypesEnum)
	{
		ConfigurablePasswordEncryptor configPassEncrypt = new ConfigurablePasswordEncryptor();
		configPassEncrypt.setAlgorithm(hashTypesEnum.getDescription());
		configPassEncrypt.setPlainDigest(true);
		
		return configPassEncrypt.encryptPassword(password);
	}
}
