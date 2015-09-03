package org.codex.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@SuppressWarnings({ "serial" })
@XmlRootElement
public class Post implements Serializable{
		
	@XmlElement
	private Long id;
	
	@XmlElement
	private String blogText;
	
	@XmlElement
	private Date createdOn;
	
	
	private Post(){
		super();
		createdOn = new Date();
	}
	
	public Post(String question){
		this();
		this.setBlogText(question);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((blogText == null) ? 0 : blogText.hashCode());
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (blogText == null) {
			if (other.blogText != null)
				return false;
		} else if (!blogText.equals(other.blogText))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
