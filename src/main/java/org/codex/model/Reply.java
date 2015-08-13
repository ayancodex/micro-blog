package org.codex.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name="replies")
public class Reply implements Serializable {

	@XmlElement
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reply_id")
	private Long id;
	
	@XmlElement
	@Column(name="response_text")
	private String response;

	@XmlElement
	@Column(name="create_date")
	private Date createdOn;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	 private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID", nullable = false)
	 private Post post;
	
	private Reply(){
		super();
     	createdOn = new Date();
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id=id;
	}
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}


}
