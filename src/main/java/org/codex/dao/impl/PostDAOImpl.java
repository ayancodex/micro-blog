package org.codex.dao.impl;

import java.util.List;

import org.codex.dao.PostDAO;
import org.codex.model.Post;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("postDao")
public class PostDAOImpl implements PostDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public Long createPost(Post post) {
	  Session session=sessionFactory.getCurrentSession();
	  Long postId=(Long) session.save(post);
	  return postId;
	}

	public Post getPostById(Long postId) {
		Session session = sessionFactory.getCurrentSession();
		Post post = (Post) session.get(Post.class, postId);
		return post;
	}

	@SuppressWarnings("unchecked")
	public List<Post> getAllPosts() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Post");
		List<Post> posts= query.list();
		return posts;
	}

	@SuppressWarnings("unchecked")
	public List<Post> getAllPostByUser(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Post where userId = :usrId");
		query.setParameter("usrId", new Long(userId));	
		List<Post> posts = query.list();
		return posts;
	}

	public void updatePostById(Post post) {
		Session session = sessionFactory.getCurrentSession();
		session.update(post);
	}

	public Long deletePostbyId(Long postId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete fro Post where id :postId");
		query.setParameter("postId", new Long(postId));	
		Long result=(long) query.executeUpdate();
		return result;
	}


}
