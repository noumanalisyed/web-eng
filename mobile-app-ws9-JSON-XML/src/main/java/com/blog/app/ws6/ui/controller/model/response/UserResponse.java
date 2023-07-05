package com.blog.app.ws6.ui.controller.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserResponse {
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
}
