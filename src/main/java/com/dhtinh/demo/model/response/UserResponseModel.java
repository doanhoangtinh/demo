package com.dhtinh.demo.model.response;

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
public class UserResponseModel {
    private Long id;
    private String fullname;
    private String email;
    private String phoneNumber;
    private String address;
    private Boolean gender;
    //private RoleDTO role;
}
