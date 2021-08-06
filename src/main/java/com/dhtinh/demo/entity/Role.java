package com.dhtinh.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(columnDefinition = "tinyint")
    private Long id;
    
    @Column(name = "code", columnDefinition = "varchar(8) unique not null")
    private String code;
     
    @Column(name = "name", columnDefinition = "varchar(16) not null")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserProfile> userProfiles;
    
}
