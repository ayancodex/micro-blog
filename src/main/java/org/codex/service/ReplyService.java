package org.codex.service;

import java.util.List;

import org.codex.model.Reply;

public interface ReplyService {

	public Long createReply(Reply reply);
	public Reply getReplyById(Long id);
	public List<Reply> getAllReplies();
	public List<Reply> getAllReplyByUser(Long userId);
	public void updateReplyById(Reply reply);
	public Long deleteReplyById(Long id);
	public boolean isReplyExist(Long replyId); 
}
