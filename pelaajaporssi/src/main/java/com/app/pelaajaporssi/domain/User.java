package com.app.pelaajaporssi.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id", nullable = false, unique = true)
    private Long id; 
    
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    
   

    public User() {
    }

	public User(String username) {
		super();
		this.username = username;
		
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	

}