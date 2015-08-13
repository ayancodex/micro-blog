package org.codex.dao;

import java.util.List;

import org.codex.model.User;

public interface UserDAO {
	
	public Long createUser(User user);
	public void updateUser(User user);
	public Long deleteUser(Long userId);
	public List<User> getUsers();
	public User getUserById(Long userId);
	public boolean isUserExists(Long userId);
	

}
