package com.dhtinh.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_profile")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", columnDefinition = "nvarchar(32) not null")
    private String fullName;

    @Column(name = "email", columnDefinition = "varchar(64) not null")
    private String email;

    @Column(name = "phone_number", columnDefinition = "varchar(10) not null ")
    private String phoneNumber;

    @Column(name = "address", columnDefinition = "nvarchar(256) not null")
    private String address;

    @Column(name = "gender", columnDefinition = "bit(1) not null default true")
    private Boolean gender;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Project> users;
 
    @OneToMany(mappedBy = "inspector")
    private List<Project> inspectors;
}
