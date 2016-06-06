package com.test.print;

import static org.junit.Assert.*;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyPrint
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void test() throws IOException
	{
		Desktop desktop = Desktop.getDesktop();
		
		File file = new File("c:\\b.docx");
		
		desktop.print(file);
	}

}
