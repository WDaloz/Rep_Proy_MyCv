package com.daloz.mycv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daloz.mycv.business.IUserDAO;
import com.daloz.mycv.domain.UserDTO;
import com.daloz.mycv.service.ISecurityService;

@Service("iSecurityService")
@Transactional
public class SecurityServiceImpl implements ISecurityService
{
	@Autowired
	IUserDAO iUserDAO;

	@Override
	public UserDTO validateUser(UserDTO userDTO)
	{
		return iUserDAO.validateUser(userDTO);
	}

}
