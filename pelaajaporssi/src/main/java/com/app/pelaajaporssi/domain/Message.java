package com.app.pelaajaporssi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id", nullable = false, unique = true)
    private Long id; 
    
    //@Column(name = "username", nullable = false, unique = false)
    private String username;
    
    //@Column(name = "message", nullable = true, unique = false)
    private String messagetext;
    
    private String note;
    
    

	public Message() {}
    
    public Message(String username, String messagetext, String note) {
    	this.username = username;
    	this.messagetext = messagetext;
    	this.note = note;
    }
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessagetext() {
		return messagetext;
	}

	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
    
    
}