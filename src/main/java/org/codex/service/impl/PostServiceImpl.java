package org.codex.service.impl;

import java.util.List;

import org.codex.dao.PostDAO;
import org.codex.model.Post;
import org.codex.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("postService")
public class PostServiceImpl implements PostService {
	
    @Autowired
    private PostDAO postDao;
    
	@Transactional
	public Long createPost(Post post) {
	   Long postId = postDao.createPost(post)	;
	   return postId;
	}

	public Post getPostById(Long id) {
		Post post= postDao.getPostById(id);
		return post;
	}

	public List<Post> getAllPosts() {
		List<Post> posts=postDao.getAllPosts();
		return posts;
	}

	public List<Post> getAllPostByUser(Long userId) {
		List<Post> posts=postDao.getAllPostByUser(userId);
		return posts;
	}

	public void updatePostById(Post post) {
		postDao.updatePostById(post);
	}

	public Long deletePostbyId(Long id) {
		Long result=postDao.deletePostbyId(id);
		return result;
	}

	public boolean isPostExist(Long id) {
		if(getPostById(id)!=null){
			return true;
		}
		else {
		return false;
		}
	}

}
