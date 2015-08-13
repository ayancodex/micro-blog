package org.codex.dao;

import java.util.List;

import org.codex.model.Post;

public interface PostDAO {
	
	public Long createPost(Post post);
	public Post getPostById(Long id);
	public List<Post> getAllPosts();
	public List<Post> getAllPostByUser(Long userId);
	public void updatePostById(Post post);
	public Long deletePostbyId(Long id);

}
