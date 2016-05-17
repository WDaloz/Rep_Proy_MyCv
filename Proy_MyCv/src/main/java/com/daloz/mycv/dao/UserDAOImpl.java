package com.daloz.mycv.dao;

import org.springframework.stereotype.Repository;

import com.daloz.libfiles.dataobjects.FileProcessResponse;
import com.daloz.libfiles.dataobjects.ReaderEntity;
import com.daloz.libfiles.dataobjects.WriterEntity;
import com.daloz.mycv.business.IUserDAO;
import com.daloz.mycv.config.SysConstants;
import com.daloz.mycv.domain.UserDTO;

@Repository
public class UserDAOImpl extends GenericDAO implements IUserDAO
{
	public UserDAOImpl()
	{
		setLogger(UserDAOImpl.class);
		setFileManager();
	}

	@Override
	public UserDTO validateUser(UserDTO _userDTO)
	{
		ReaderEntity readerEntity = new ReaderEntity();
		readerEntity.setPath(SysConstants.PATH.getPath());
		readerEntity.setClassTarget(UserDTO.class);

		FileProcessResponse fResponse = iFileManager.readFile(readerEntity);
		UserDTO userDTO = (UserDTO) fResponse.getData();

		if (userDTO.getName().equals(_userDTO.getName()) && userDTO.getPassword().equals(_userDTO.getPassword()))
		{
			logger.info(fResponse.getReport());
			return userDTO;
		}

		return null;
	}

	@Override
	public Boolean changePassword(UserDTO _userDTO)
	{
		WriterEntity writerEntity = new WriterEntity();
		writerEntity.setObjective(_userDTO);
		writerEntity.setObjectiveClass(UserDTO.class);

		FileProcessResponse fpResponse = iFileManager.writeFile(writerEntity);

		if (fpResponse.getData() != null)
		{
			return true;
		}

		return false;
	}

	@Override
	public UserDTO getUser()
	{
		ReaderEntity readerEntity = new ReaderEntity();
		readerEntity.setPath(SysConstants.PATH.getPath());
		readerEntity.setClassTarget(UserDTO.class);

		FileProcessResponse fResponse = iFileManager.readFile(readerEntity);
		UserDTO userDTO = (UserDTO) fResponse.getData();
		
		System.out.println(userDTO.getEmployeeDTO().getEducationDTOs().get(0).getStringFromMutableObject());
		
		return (userDTO != null)?userDTO:null;
	}
}
