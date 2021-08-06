package com.dhtinh.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupDetailId implements Serializable {
    @Column(name = "user_profile_id", columnDefinition = "tinyint")
    private Long userProfileId;
    
    @Column(name = "group_id", columnDefinition = "tinyint")
    private Long groupId; 
}
