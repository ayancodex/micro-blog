package org.codex.dao;

import java.util.List;
import java.util.Set;

import org.codex.model.Post;
import org.codex.model.User;

public interface UserDAO {
	
	public Long createUser(User user);
	public void updateUser(User user);
	public Long deleteUser(Long userId);
	public List<User> getUsers();
	public User getUserById(Long userId);
	public User getUserByUserName(String userName);
	public boolean isUserExists(Long userId);
	public void cteatePostByUser(Long userId,Set<Post> posts);
	public Set<Post> getAllPostsByUser(Long userId);
	public void assocaitePostWithUser(Long userId,Long postId);
	public User isAuthenticatedUser(String userName,String password);
	
	

}
