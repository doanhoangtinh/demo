package com.dhtinh.demo.dto;


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
public class GroupDetailDTO {
    private GroupDetailIdDTO id;
    private RoleOfGroupDTO roleOfGroup;
}
