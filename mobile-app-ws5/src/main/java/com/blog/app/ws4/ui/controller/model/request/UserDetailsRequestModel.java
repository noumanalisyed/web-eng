package com.blog.app.ws4.ui.controller.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDetailsRequestModel {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
