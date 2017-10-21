package com.minazg.service;

import java.util.List;

import com.minazg.model.User;


public interface UserService {
	
	User findById(Long id);
	
	User findBySSO(String sso);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserBySSO(String sso);

	List<User> findAllUsers(); 
	
	boolean isUserSSOUnique(Long id, String sso);

	/**
	 * Finds user by having a role of @roleName
	 * @param roleName
	 * @return
	 */
	List<User> findUsersByRoleName(String roleName);

	User getCurrentAuthenticatedUser();

	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	boolean isUserAuthenticated();

}