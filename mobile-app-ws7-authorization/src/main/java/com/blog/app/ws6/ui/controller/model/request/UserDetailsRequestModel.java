package com.blog.app.ws6.ui.controller.model.request;

import lombok.Data;

@Data
public class UserDetailsRequestModel {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}