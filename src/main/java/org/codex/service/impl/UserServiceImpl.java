package org.codex.service.impl;

import java.beans.Transient;
import java.util.List;
import java.util.Set;

import javax.persistence.Temporal;

import org.codex.dao.UserDAO;
import org.codex.model.Post;
import org.codex.model.User;
import org.codex.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDao;
	
	@Transactional
	public Long createUser(User u) {
		return userDao.createUser(u);
		
	}
	@Transactional
	public void updateUser(User u) {
		userDao.updateUser(u);
		
	}
	@Transactional
	public Long deleteUser(Long id) {
		return userDao.deleteUser(id);
		
	}

    @Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}
    @Transactional
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}
	@Transactional
	public User getUserByUserName(String userName){
		return userDao.getUserByUserName(userName);		
	}
    
    @Transactional
    public boolean isUserExists(Long id){
    	return userDao.isUserExists(id);
    }
    
    @Transactional
    public void cteatePostByUser(Long userId,Set<Post> posts){
    	userDao.cteatePostByUser(userId, posts);
    }
	@Transactional
	public Set<Post> getAllPostsByUser(Long userId){
		return userDao.getAllPostsByUser(userId);
	}
	
	@Transactional
	public void assocaitePostWithUser(Long userId,Long postId){
		userDao.assocaitePostWithUser(userId, postId);
	}
   
	@Transactional
	public User isAuthenticatedUser(String userName,String password){
		return userDao.isAuthenticatedUser(userName,password);
	}

}
