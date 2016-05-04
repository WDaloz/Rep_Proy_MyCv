package com.test.xml;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.daloz.libfiles.config.enums.FileTypes;
import com.daloz.libfiles.core.IFileManager;
import com.daloz.libfiles.dataobjects.FileProcessResponse;
import com.daloz.libfiles.dataobjects.ReaderEntity;
import com.daloz.libfiles.dataobjects.WriterEntity;
import com.daloz.libfiles.factoryservices.FileManagerFactory;
import com.daloz.mycv.domain.EmployeeDTO;
import com.daloz.mycv.domain.UserDTO;

public class TestCreateXml
{
	static IFileManager iFileManager = null;
	FileProcessResponse  fResponse = null;
	ReaderEntity readerEntity = null;
	WriterEntity writerEntity = null;
	
	static Logger  logger= null;
	
	@BeforeClass
	public static void setUpClass() throws Exception
	{
		iFileManager = FileManagerFactory.getFileManager(FileTypes.XML_FILE);
		logger = Logger.getLogger(TestCreateXml.class);
	}

	@Test
	public void testWriteXml()
	{
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(new Long(1));
		employeeDTO.setCode("emp001");
		employeeDTO.setName("Cristhian");
		employeeDTO.setLastName("Paraguay");
		employeeDTO.setMaidenName("Huincho");
		
		UserDTO userDTO = new UserDTO();
		userDTO.setCode("adm001");
		userDTO.setEmployeeDTO(employeeDTO);
		userDTO.setName("cparaguay");
		userDTO.setPassword("123");
		userDTO.setStatus(true);
		
		writerEntity = new WriterEntity();
		writerEntity.setObjective(userDTO);
		writerEntity.setObjectiveClass(UserDTO.class);
		writerEntity.setPath("src/main/resources/data/UserDTO.xml");
		
		fResponse = iFileManager.writeFile(writerEntity);
		
		assertNotNull(fResponse);
		
		logger.info(fResponse.getReport());
		
	}
	
	
	@Test
	public void testReadeXml()
	{
		readerEntity = new ReaderEntity();
		readerEntity.setPath("src/main/resources/data/UserDTO.xml");
		readerEntity.setClassTarget(UserDTO.class);
		
		fResponse = iFileManager.readFile(readerEntity);
		
		assertNotNull(fResponse);
		
		UserDTO userDTO =(UserDTO)fResponse.getData();
		
		logger.info(userDTO.getStringFromMutableObject());
	}

}
