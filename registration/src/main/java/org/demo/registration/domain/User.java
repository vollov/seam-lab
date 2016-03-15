package org.demo.registration.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1881413500711441951L;

	@Id
	@NotNull
	@Size(min = 5, max = 15)
	private String username;
	
	@NotNull
	@Size(min = 5, max = 15)
	private String password;
	
	@NotNull
	private String name;

	public User(String name, String password, String username) {
		this.name = name;
		this.password = password;
		this.username = username;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User(" + username + ")";
	}
}
