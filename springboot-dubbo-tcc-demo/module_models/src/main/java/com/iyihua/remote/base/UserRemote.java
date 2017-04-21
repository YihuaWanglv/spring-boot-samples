
package com.iyihua.remote.base;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.iyihua.model.base.UserDTO;
import com.iyihua.model.base.user.UserConfigObject;


public interface UserRemote {

	public UserDTO findUserById(Long id);
	
	public UserDTO createUser(UserDTO user) throws NoSuchAlgorithmException, InvalidKeySpecException;
	
	public void deleteUser(Long id); 
	
	public UserDTO findUserByName(String username);
	
	public UserDTO updateUser(UserDTO user, Boolean isUpdateSelected) throws NoSuchAlgorithmException, InvalidKeySpecException;
	
	public UserConfigObject getUserConfigById(long id);

	public void saveUserConfig(long userId, UserConfigObject uco);
}
