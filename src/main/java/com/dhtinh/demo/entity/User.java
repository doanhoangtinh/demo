package com.dhtinh.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(referencedColumnName = "id",name = "user_profile_id")
public class User extends UserProfile {

    @Column(name = "username", columnDefinition = "varchar(16) unique not null")
    private String username;

    @Column(name = "password", columnDefinition = "varchar(256) not null")
    private String password;

}
