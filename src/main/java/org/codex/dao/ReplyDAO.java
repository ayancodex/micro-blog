package org.codex.dao;

import java.util.List;

import org.codex.model.Post;
import org.codex.model.Reply;

public interface ReplyDAO {
	public Long createReply(Reply reply);
	public Reply getReplyById(Long id);
	public List<Reply> getAllReplies();
	public List<Reply> getAllReplyByUser(Long userId);
	public void updateReplyById(Reply reply);
	public Long deleteReplyById(Long id);
	public boolean isReplyExists(Long id);


}
