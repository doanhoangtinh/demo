package com.dhtinh.demo.dto;

import java.io.Serializable;


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
public class GroupDetailIdDTO implements Serializable {
    private Long userProfileId;
    private Long groupId; 
}
