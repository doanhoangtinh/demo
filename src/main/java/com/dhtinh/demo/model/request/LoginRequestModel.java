package com.dhtinh.demo.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequestModel {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
