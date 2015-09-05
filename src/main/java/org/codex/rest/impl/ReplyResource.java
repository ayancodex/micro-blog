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
import org.codex.model.Reply;
import org.codex.service.PostService;
import org.codex.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/service/reply")
public class ReplyResource {
	
	@Autowired
	private ReplyService replyService;
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createReply(Reply reply){
		Long postId=replyService.createReply(reply);
		return Response.status(Response.Status.CREATED)
				 .entity("Post created with id"+postId).build();
		
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Reply getPostById(@PathParam("replyId") Long replyId){
		Reply reply=replyService.getReplyById(replyId);
		return reply;		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Reply> getAllReplies(){
		List<Reply> replies= replyService.getAllReplies();
		return replies;
	}
	
	@GET
	@Path("/user/{userId}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Reply> getPostByUser(@PathParam("userId") Long userId){
		List<Reply> replies=replyService.getAllReplyByUser(userId);
		return replies;
	}
	
	@PUT
	@Path("/{replyId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response updatePost(@PathParam("replyId") Long replyId,Reply reply){
		if(!replyService.isReplyExist(replyId)){
			replyService.createReply(reply) ;
			return Response.status(Response.Status.CREATED).entity("New reply created").build();
		}
		else{
			replyService.updateReplyById(reply);
			return Response.status(Response.Status.OK).entity("Reply sucessfully updated").build();
		}
		
	}
	@DELETE
	@Path("/{postId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response deleteReply(@PathParam("postId") Long replyId){
		Long restult = replyService.deleteReplyById(replyId);
		return Response.status(Response.Status.NO_CONTENT)
				 .entity("Reply sucessfully removed with id:"+replyId).build();
	}
	

}
