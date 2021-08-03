package com.dhtinh.demo.model.request;

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
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private Boolean gender;
    private String username;
    private String password;
}
