package com.test.dao.helper;



import org.junit.BeforeClass;
import org.junit.Test;

import com.daloz.mycv.dao.helper.BagItemCondition;
import com.daloz.mycv.dao.helper.ReaperConditions;
import com.daloz.mycv.domain.UserDTO;

public class TestReaperConditions
{
	static String condition = null;
	
	@BeforeClass
	public static void setUpClass()
	{
		System.out.println("----------> Iniciando");
	}
	
	@Test
	public void testGetMethods()
	{
		condition = "name = :name and password = :password";
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName("u001");
		userDTO.setPassword("123");
		
		BagItemCondition bagItems = new ReaperConditions(condition, userDTO).getBagItems();
		
		
		for (int i = 0; i < bagItems.size(); i++)
		{
			System.out.println(bagItems.get(i).getStringFromMutableObject());
		}

	}
	

}
