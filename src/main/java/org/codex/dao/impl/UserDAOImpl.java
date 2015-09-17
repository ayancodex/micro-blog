package org.codex.dao.impl;

import java.util.List;
import java.util.Set;

import org.codex.dao.UserDAO;
import org.codex.model.Post;
import org.codex.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDAOImpl implements  UserDAO {


	@Autowired
	private SessionFactory sessionFactory;

	public Long createUser(User u) {
		Session session = sessionFactory.getCurrentSession();
		Long id =(Long) session.save(u);
		return id;

	}

	public void updateUser(User u){
		Session session = sessionFactory.getCurrentSession();
		session.update(u);
	}
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> usrs= query.list();
		return usrs;
	}

	public User getUserById(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		User usr=(User) session.get(User.class, userId);
		return usr;

	}
	@SuppressWarnings("unchecked")
	public User getUserByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from User where email = :userName";
		Query query = session.createQuery(hql);
		query.setParameter("userName", userName);	 
		List<User> result =  (List<User>)query.list();
		return result.get(0);
		
	}
	public Long deleteUser(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete User where id = :ID");
		query.setParameter("ID", new Long(userId));	 
		Long result = (long) query.executeUpdate();
		return result;

	}

	public boolean isUserExists(Long userId){
		if(getUserById(userId)!=null){
			return true;	
		}
		else {
		 return false;
		}
	}
	
	public void cteatePostByUser(Long userId,Set<Post> posts){
		Session session = sessionFactory.getCurrentSession();
		User usr=(User)session.get(User.class, userId);
		usr.getPosts().addAll(posts);
		
	}
	public Set<Post> getAllPostsByUser(Long userId){
		Session session = sessionFactory.getCurrentSession();
		User usr=(User)session.get(User.class, userId);
		return usr.getPosts();
	}
	
	public void assocaitePostWithUser(Long userId,Long postId){
		Session session = sessionFactory.getCurrentSession();
		User usr = (User) session.get(User.class, userId);
		Post post =(Post) session.get(Post.class, postId);
		usr.getPosts().add(post);
	}
	public User isAuthenticatedUser(String  email,String passwod){
		User validUser=null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> usrs= query.list();
		if(usrs!=null){
			for(User usr: usrs){
				if(usr.getEmail().equals(email)&&usr.getPassword().equals(passwod)){
					validUser=usr;
					break;
				}
			}
		}
		
		/*String hql="from org.codex.model.User where email like :email";
		@SuppressWarnings("unchecked")
		List<User> result=(List<User>) session.createQuery(hql)
				.setParameter("email", email)
				 .list();
		User userInDatabase =null;
		if(result!=null){
			userInDatabase=result.get(0);
		}
		if(userInDatabase!=null){
			if(passwod.equals(userInDatabase.getPassword())){
				validUser=true;
			}
		}	*/
		return validUser;
	}

	
}
