package org.codex.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings({ "serial" })
@XmlRootElement
public class User implements Serializable {
   

	@XmlElement
	private Long id;
	
	@XmlElement
	private String email;
	
	@XmlElement
	private String password;
	
	@XmlElement
	private String firstName;
	
	@XmlElement
	private String lastName;
	
	@XmlElement
    private Date createdOn;
	
	@XmlElement
	private Date lastLoginDT;	
	
	@XmlElement
    private Set<Post> posts;
	
	public User() {
		super();
		createdOn = new Date();
	}
	
	public User(String loginId, String password, String firstName, String lastName) {
		this();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@JsonIgnore
	public Set<Post> getPosts() {
		return posts;
	}
	@JsonProperty
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
    public void setId(Long id) {
		this.id = id;
	}
    public Long getId() {
		return id;
	}

	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastLoginDT() {
		return lastLoginDT;
	}

	public void setLastLoginDT(Date lastLoginDT) {
		this.lastLoginDT = lastLoginDT;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		return true;
	}
	

}
