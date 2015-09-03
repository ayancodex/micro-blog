package org.codex.rest.impl;

import java.util.List;
import java.util.Set;

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
import org.codex.model.User;
import org.codex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@Path("/users/")
public class UserResource {
	
	@Autowired
	private UserService userService; 

	
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public User getUser(@PathParam("id") Long userId) {	
		return userService.getUserById(userId);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<User>getAllUsers(){
		return userService.getUsers();
		
	}
	

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createUser(User u) {
		 Long id=userService.createUser(u);
		 return Response.status(Response.Status.CREATED)
				 .entity("User created with id :"+id).build(); 
		 
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response updateUser(@PathParam("id") Long userId,User user){
		if(!userService.isUserExists(userId)){
			userService.createUser(user);
			return Response.status(Response.Status.CREATED).entity("New user created").build();
		}
		else{
			userService.updateUser(user);
			return Response.status(Response.Status.OK).entity("User sucessfully updated").build();
		}	
		
	}
	
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteUserById(@PathParam("id")  Long usrId){
		Long result = userService.deleteUser(usrId);
		 return Response.status(Response.Status.NO_CONTENT)
				 .entity("User sucessfully removed with id:"+usrId).build();
		
	}
	
	@GET
	@Path("/{id}/posts")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Post> getAllPostByUser(@PathParam("id") Long usrId){
		return userService.getAllPostsByUser(usrId); 
	}
	
	@POST
	@Path("/{userId}/posts")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response createPostsByUser(@PathParam("userId") Long userId,Set<Post> posts){
		userService.cteatePostByUser(userId, posts);
		return Response.status(Response.Status.OK).entity("Post sucessfully created by user").build();
	}
	
	@PUT
	@Path("/{userId}/post/{postId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response assocaitePostWithUser(@PathParam("userId") Long userId,@PathParam("postId") Long postId){
		userService.assocaitePostWithUser(userId, postId);
		return Response.status(Response.Status.OK).entity("Post is assocaited with User sucessfully").build();
	}

}
