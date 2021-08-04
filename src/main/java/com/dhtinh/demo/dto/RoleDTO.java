package com.dhtinh.demo.dto;

import javax.validation.constraints.NotBlank;

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
public class RoleDTO {
    private Long id;
    private String code;
    private String name;
    //private List<UserProfileDTO> userProfiles;
    
}
