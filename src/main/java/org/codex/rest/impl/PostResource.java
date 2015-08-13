package org.codex.rest.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codex.model.Post;
import org.codex.service.PostService;
import org.codex.service.UserService;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Path("/post")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createPost(Post post){
		Long postId=postService.createPost(post);
		return Response.status(Response.Status.CREATED)
				 .entity("Post created with id"+postId).build();
		
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Post getPostById(@PathParam("postId") Long postid){
		Post post=postService.getPostById(postid);
		return post;		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Post> getAllPosts(){
		List<Post> posts= postService.getAllPosts();
		return posts;
	}
	
	@GET
	@Path("/user/{userId}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Post> getPostByUser(@PathParam("userId") Long userId){
		List<Post> posts=postService.getAllPostByUser(userId);
		return posts;
	}
	
	@PUT
	@Path("/{postId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response updatePost(@PathParam("postId") Long postId,Post post){
		if(!postService.isPostExist(postId)){
			postService.createPost(post);
			return Response.status(Response.Status.CREATED).entity("New post created").build();
		}
		else{
			postService.updatePostById(post);
			return Response.status(Response.Status.OK).entity("Post sucessfully updated").build();
		}
		
	}
	@DELETE
	@Path("/{postId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response deletePost(@PathParam("postId") Long postId){
		Long restult = postService.deletePostbyId(postId);
		return Response.status(Response.Status.NO_CONTENT)
				 .entity("Post sucessfully removed with id:"+postId).build();
	}
	

}
