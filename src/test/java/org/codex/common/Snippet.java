package org.codex.common;

import org.codex.model.User;
import org.codex.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Snippet {
	public static void main(String[] args) {
		ApplicationContext appContext = 
		    	  new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userbo = (UserService) appContext.getBean("userService");
		/** insert **/
    	User user = new User();
    	user.setFirstName("ayan");
    	user.setLastName("adak");
    	userbo.createUser(user);
    	
    	/** select **//*
    	Stock stock2 = stockBo.findByStockCode("7668");
    	System.out.println(stock2);
    	
    	*//** update **//*
    	stock2.setStockName("HAIO-1");
    	stockBo.update(stock2);
    	
    	*//** delete **//*
    	stockBo.delete(stock2);*/
    	
    	System.out.println("Done");
		
		
	}
}

