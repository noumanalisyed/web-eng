package com.blog.app.ws2.io.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="users")
@Data
public class UserEntity implements Serializable {
 
	private static final long serialVersionUID = 5313493413859894403L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="user_id", nullable=false)
	private String userId;

	@Column(name="first_name",nullable=false, length=50)
	private String firstName;
	
	@Column(name="last_name",nullable=false, length=50)
	private String lastName;
	
	@Column(nullable=false, length=120)
	private String email;
	
	@Column(name="encrypted_password",nullable=false)
	private String encryptedPassword;

	@Column(name="email_verification_token")
	private String emailVerificationToken;
	
	@Column(name="email_verification_status",nullable=false)
	private Boolean emailVerificationStatus = false;

}
