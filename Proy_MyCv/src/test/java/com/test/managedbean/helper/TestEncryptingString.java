package com.test.managedbean.helper;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.daloz.mycv.managedbean.helper.EncryptingString;
import static com.daloz.mycv.managedbean.helper.HashTypes.*;

public class TestEncryptingString
{
	static Logger logger = null;
	
	
	@BeforeClass
	public static void beforeClass()
	{
		logger = Logger.getLogger(TestEncryptingString.class);
	}

	@Test
	public void testEncriptarPass()
	{
		logger.info(EncryptingString.encriptPassword("123", SHA_512));
	}
}
