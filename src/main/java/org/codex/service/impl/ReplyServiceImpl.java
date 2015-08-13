package org.codex.service.impl;

import java.util.List;

import org.codex.dao.ReplyDAO;
import org.codex.model.Reply;
import org.codex.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDao;
	
	@Transactional
	public Long createReply(Reply reply) {
		Long replyId=replyDao.createReply(reply);
		return replyId;
	}

	public Reply getReplyById(Long replyId) {
		 Reply reply=replyDao.getReplyById(replyId);
		return reply;
	}

	public List<Reply> getAllReplies() {
		List<Reply> replies= replyDao.getAllReplies();
		return replies;
	}

	public List<Reply> getAllReplyByUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateReplyById(Reply reply) {
		replyDao.updateReplyById(reply);

	}

	public Long deleteReplyById(Long replyId) {
		Long result= replyDao.deleteReplyById(replyId);
		return result;
	}

	public boolean isReplyExist(Long replyId) {
		
		return replyDao.isReplyExists(replyId);
	}
	

}
