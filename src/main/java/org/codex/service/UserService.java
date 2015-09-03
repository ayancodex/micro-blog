package org.codex.service;

import java.util.List;
import java.util.Set;

import org.codex.model.Post;
import org.codex.model.User;

public interface UserService {
	
	public Long createUser(User u);
	public void updateUser(User u);
	public Long deleteUser(Long usrId);
	public List<User> getUsers();
	public User getUserById(Long userId);
	public boolean isUserExists(Long userId);
	public void cteatePostByUser(Long userId,Set<Post> posts);
	public Set<Post> getAllPostsByUser(Long userId);
	public void assocaitePostWithUser(Long userId,Long postId);

}
