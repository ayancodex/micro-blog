

package org.codex.model;

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
import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings("restriction")
@XmlRootElement
@Entity
@Table(name="post")
public class Post {
	
	@XmlElement
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="post_id")
	private Long id;
	
	@XmlElement
	@Column(name="blog_content")
	private String blogText;
	
	@XmlElement
	@Column(name="create_date")
	private Date createdOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	 private User user;
	
	private Post(){
		super();
		createdOn = new Date();
	}
	
	public Post(long userId, String userName, String question){
		this();
		this.setBlogText(question);
	}
	
	public Long getId() {
		return id;
	}
	
	public String getBlogText() {
		return blogText;
	}
	
	public void setBlogText(String question) {
		this.blogText = new String(question);
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}


}
