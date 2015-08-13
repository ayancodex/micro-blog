package org.codex.dao.impl;

import java.util.List;

import org.codex.dao.ReplyDAO;
import org.codex.model.Post;
import org.codex.model.Reply;
import org.codex.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("replyDao")
public class ReplyDAOImpl implements ReplyDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Long createReply(Reply reply) {
		Session session=sessionFactory.getCurrentSession();
		Long replyId=(Long) session.save(reply);
		return replyId;
		
	}

	public Reply getReplyById(Long replyId) {
		 Session session=sessionFactory.getCurrentSession();
		 Reply reply=(Reply) session.get(Reply.class, replyId);
		return reply;
	}

	public List<Reply> getAllReplies() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Reply");
		List<Reply> replies= query.list();
		return replies;
	}

	public List<Reply> getAllReplyByUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateReplyById(Reply reply) {
		Session session = sessionFactory.getCurrentSession();
		session.update(reply);	

	}

	public Long deleteReplyById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Reply where id = :ID");
		query.setParameter("ID", new Long(id));	 
		Long result = (long) query.executeUpdate();
		return result;
	}
	public boolean isReplyExists(Long id){
		if(getReplyById(id)!=null){
			return true;	
		}
		else {
		 return false;
		}
	}

}
