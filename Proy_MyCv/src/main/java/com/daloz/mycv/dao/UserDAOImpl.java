package com.daloz.mycv.dao;

import org.springframework.stereotype.Repository;

import com.daloz.mycv.business.IUserDAO;
import com.daloz.mycv.domain.UserDTO;

@Repository
public class UserDAOImpl extends AbstractJpaDAO<UserDTO> implements IUserDAO
{
	public UserDAOImpl()
	{
		setClazz(UserDTO.class);
	}

	@Override
	public UserDTO validateUser(UserDTO userDTO)
	{
		return selectOne(userDTO, "name = :name and password = :password");
	}
}
