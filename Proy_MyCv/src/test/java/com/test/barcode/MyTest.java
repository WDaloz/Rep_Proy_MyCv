package com.test.barcode;

import org.junit.Test;

import com.daloz.barcode.config.enums.TypeBarCode;
import com.daloz.barcode.core.IBarcodeManager;
import com.daloz.barcode.dataobjects.FileProcessResponse;
import com.daloz.barcode.factoryservice.FactoryBarCodeManager;

public class MyTest
{
	@Test
	 public void test()
	{
		IBarcodeManager ib = FactoryBarCodeManager.getBarCodeManager(TypeBarCode.EAN_13);
		
		FileProcessResponse fp = ib.generateBarCode(new Long("7707777123459"), 
				"src/test/resources/data/output/cb.png");
	}
}
