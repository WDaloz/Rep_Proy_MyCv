package com.test.xml;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.daloz.libfiles.config.enums.FileTypes;
import com.daloz.libfiles.core.IFileManager;
import com.daloz.libfiles.dataobjects.FileProcessResponse;
import com.daloz.libfiles.dataobjects.ReaderEntity;
import com.daloz.libfiles.dataobjects.WriterEntity;
import com.daloz.libfiles.factoryservices.FileManagerFactory;
import com.daloz.mycv.domain.CourseDTO;
import com.daloz.mycv.domain.DataBaseDTO;
import com.daloz.mycv.domain.EducationDTO;
import com.daloz.mycv.domain.EmployeeDTO;
import com.daloz.mycv.domain.FrameworkDTO;
import com.daloz.mycv.domain.IdiomDTO;
import com.daloz.mycv.domain.InterestDTO;
import com.daloz.mycv.domain.LanguajeDTO;
import com.daloz.mycv.domain.SkillDTO;
import com.daloz.mycv.domain.SocialNetworkDTO;
import com.daloz.mycv.domain.ToolDTO;
import com.daloz.mycv.domain.UserDTO;
import com.daloz.mycv.domain.WorkExperienceDTO;
import com.daloz.mycv.managedbean.helper.EncryptingString;
import com.daloz.mycv.managedbean.helper.HashTypes;

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
		EducationDTO educationDTO = new EducationDTO();
		educationDTO.setStartDate(new Date());
		educationDTO.setEndDate(new Date());
		educationDTO.setName("CIBERTEC");
		educationDTO.setLocation("Lima - Peru");
		educationDTO.setProfession("Desarrollador Java");
		educationDTO.setGrade("Tecnico");
		
		List<EducationDTO> educationDTOs = new ArrayList<>(Arrays.asList(educationDTO));
		
		List<IdiomDTO> idiomDTOs = new ArrayList<>(Arrays.asList(new IdiomDTO("Ingles", "Basico")));
		
		List<InterestDTO> interestDTOs = new ArrayList<>(
				Arrays.asList(
						new InterestDTO("Anime", "Me gusta los animes"),
						new InterestDTO("Musica", "Me gusta los animes")
						     )
				);
		
		List<SocialNetworkDTO> socialNetworkDTOs = new ArrayList<>(
				Arrays.asList(
						new SocialNetworkDTO("https://www.facebook.com/girard.santos", "/icon/fb-icon.png"),
						new SocialNetworkDTO("https://pe.linkedin.com/in/paraguaycristhianp", "/icon/linkedin-icon.png")
						)
				);
		
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setName("Spring");
		courseDTO.setDescripcion("Aprender a manejar");
		courseDTO.setLocation("Lima - Peru");
		courseDTO.setStarDate(new Date());
		courseDTO.setEndDate(new Date());
		courseDTO.setContents(new ArrayList<>(
				            Arrays.asList(new String("-Spring"))
						                     )
				             );
		
		List<CourseDTO> courseDTOs = new ArrayList<>(Arrays.asList(courseDTO));
		
		
		SkillDTO skillDTO = new SkillDTO();
		
		List<String> patterns = new ArrayList<>();
		patterns.add("Mvc");
		patterns.add("Dao");
		patterns.add("Singleton");
		patterns.add("Factory");
		patterns.add("Strategy");
		patterns.add("IoC");
		
		List<String> principlesPractices = new ArrayList<>();
		principlesPractices.add("BDD");
		principlesPractices.add("TDD");
		
		List<String> technologies = new ArrayList<>();
		technologies.add("REST");
		technologies.add("SOAP");
		
		
		List<LanguajeDTO> languajeDTOs =new ArrayList<>
		(
				Arrays.asList
				(
						new LanguajeDTO("Java EE", "Avanzado", 7),
						new LanguajeDTO("Java Android", "Avanzado", 7),
						new LanguajeDTO("Ruby", "Basico", 2),
						new LanguajeDTO("Html 5", "Avanzado", 7),
						new LanguajeDTO("JavaScript 5", "Avanzado", 5),
						new LanguajeDTO("Css", "Basico", 3)
		        )
		);
		
		List<ToolDTO> toolDTOs =new ArrayList<>
		(
				Arrays.asList
				(
						new ToolDTO("Eclipse EE Mars", "Avanzado", 7),
						new ToolDTO("Android Studio", "Basico", 7),
						new ToolDTO("NetBeans", "Basico", 2),
						new ToolDTO("IReport", "Basico", 7),
						new ToolDTO("Maven", "Avanzado", 5),
						new ToolDTO("Git", "Basico", 3),
						new ToolDTO("GitHub", "Basico", 3),
						new ToolDTO("JUnit", "Basico", 3),
						new ToolDTO("Log4j", "Basico", 3)

		        )
		);
		
		List<FrameworkDTO> frameworkDTOs =new ArrayList<>
		(
				Arrays.asList
				(
						new FrameworkDTO("MyBatis", "Avanzado", 7),
						new FrameworkDTO("Spring", "Basico", 7),
						new FrameworkDTO("Hibernate", "Basico", 2),
						new FrameworkDTO("Struts 2", "Basico", 7),
						new FrameworkDTO("Java Server Faces", "Avanzado", 5),
						new FrameworkDTO("Angular", "Basico", 3)
		        )
		);
		
		List<DataBaseDTO> dataBaseDTOs =new ArrayList<>
		(
				Arrays.asList
				(
						new DataBaseDTO("MyBatis", "Avanzado", 7),
						new DataBaseDTO("Spring", "Basico", 7),
						new DataBaseDTO("Hibernate", "Basico", 2),
						new DataBaseDTO("Struts 2", "Basico", 7),
						new DataBaseDTO("Java Server Faces", "Avanzado", 5),
						new DataBaseDTO("Angular", "Basico", 3)
		        )
		);
		
		skillDTO.setPatterns(patterns);
		skillDTO.setPrinciplesPractices(principlesPractices);
		skillDTO.setTechnologies(technologies);
		skillDTO.setLanguajeDTOs(languajeDTOs);
		skillDTO.setToolDTOs(toolDTOs);
		skillDTO.setFrameworkDTOs(frameworkDTOs);
		skillDTO.setDataBaseDTOs(dataBaseDTOs);
		
		WorkExperienceDTO workExperienceDTO = new WorkExperienceDTO();
		workExperienceDTO.setStartDate(new Date());
		workExperienceDTO.setEndDate(new Date());
		workExperienceDTO.setCompanyName("GORA SAC");
		workExperienceDTO.setPosition("Consultor junior");
		workExperienceDTO.setDescription("No se que hacia");
		
		List<WorkExperienceDTO> workExperienceDTOs = new ArrayList<>(Arrays.asList(workExperienceDTO));
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setName("Cristhian");
		employeeDTO.setLastName("Paraguay");
		employeeDTO.setMaidenName("Huincho");
		employeeDTO.setDescription("Desarrollador java");
		employeeDTO.setProfile("Estudiante de la carrera de Computación e Informática con habilidades de trabajo en equipo, innovador y con deseos de superación e interés en desarrollarse en áreas como programación web, móvil. Me motiva leer, investigar tecnologias web y hacer deportes");
		employeeDTO.setEmail("cristhianp00@gmail.com");
		employeeDTO.setPhone("013628951");
		employeeDTO.setCellPhone("960722250");
		employeeDTO.setPath("D:\\foto.jpg");
		
		
		employeeDTO.setEducationDTOs(educationDTOs);
		employeeDTO.setIdiomDTOs(idiomDTOs);
		employeeDTO.setInterestDTOs(interestDTOs);
		employeeDTO.setSocialNetworkDTOs(socialNetworkDTOs);
		employeeDTO.setCourseDTOs(courseDTOs);
		employeeDTO.setSkillDTO(skillDTO);
		employeeDTO.setWorkExperienceDTOs(workExperienceDTOs);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setEmployeeDTO(employeeDTO);
		userDTO.setName("cparaguay");
		userDTO.setPassword(EncryptingString.encriptPassword("123", HashTypes.SHA_512));
		userDTO.setStatus(true);
		
		writerEntity = new WriterEntity();
		writerEntity.setObjective(userDTO);
		writerEntity.setObjectiveClass(UserDTO.class);
		writerEntity.setPath("src/test/resources/data/output/UserDTO.xml");
		
		fResponse = iFileManager.writeFile(writerEntity);
		
		assertNotNull(fResponse);
		
		logger.info(fResponse.getReport());
		
	}
	
	@Ignore
	@Test
	public void testReadeXml()
	{
		readerEntity = new ReaderEntity();
		readerEntity.setPath("src/test/resources/data/output/UserDTO.xml");
		readerEntity.setClassTarget(UserDTO.class);
		
		fResponse = iFileManager.readFile(readerEntity);
		
		assertNotNull(fResponse);
		
		UserDTO userDTO =(UserDTO)fResponse.getData();
		
		logger.info(userDTO.getEmployeeDTO().getEducationDTOs().get(0).getStringFromMutableObject());
	}

}
