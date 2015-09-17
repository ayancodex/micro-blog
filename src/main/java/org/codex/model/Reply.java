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
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties
@XmlRootElement
public class Reply implements Serializable {

	@XmlElement
	private Long id;
	
	@XmlElement
	private String response;

	@XmlElement
	private Date createdOn;
   
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

	


}
