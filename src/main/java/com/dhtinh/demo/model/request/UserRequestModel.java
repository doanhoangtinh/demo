package com.dhtinh.demo.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestModel {
    @NotEmpty
    private String fullName;
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotEmpty
    private String address;
    private Boolean gender;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private Long roleId;
}
