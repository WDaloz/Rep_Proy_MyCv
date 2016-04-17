package com.daloz.mycv.business;

import com.daloz.mycv.domain.UserDTO;

/**
 * 
 * psdt: Es innecesario extender de IGenericDAO<UserDTO>
 *       no afecta en nada
 * @author Mandraque
 * @version 1.0
 */
public interface IUserDAO extends IGenericDAO<UserDTO>
{
	UserDTO validateUser(UserDTO userDTO);
}
