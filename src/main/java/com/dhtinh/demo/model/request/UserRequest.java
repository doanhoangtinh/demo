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
public class UserRequest {
    private String fullname;
    private String email;
    private String phoneNumber;
    private String address;
    private Boolean gender;
    private Long roleId;
    private String username;
    private String password;
}
