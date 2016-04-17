package com.daloz.mycv.service;

import com.daloz.mycv.domain.UserDTO;

public interface ISecurityService
{
	UserDTO validateUser(UserDTO userDTO);
}
