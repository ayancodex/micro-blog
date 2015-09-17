package org.codex.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codex.model.Login;
import org.codex.model.User;
import org.codex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/login")
public class LoginResource {
	@Autowired
	private UserService userService; 

	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response authenticatUser(Login login) {
		 User user=userService.isAuthenticatedUser(login.getUsername(),login.getPassword());
		 return Response.status(Response.Status.CREATED)
				 .entity(user).build(); 
		 
	}	

}
