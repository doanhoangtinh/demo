package com.dhtinh.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "project")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    
    // @Column(name = "code", columnDefinition = "varchar(16) unique not null")
    // private String code;
     
    @Column(name = "name")
    private String name;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "address")
    private String address;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "author")
    private String author;

    @Column(name = "website")
    private String website;

    // @Column(name = "date", columnDefinition = "datetime not null")
    // private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile user;

    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private UserProfile inspector;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToMany(mappedBy = "project")
    private List<FileInfomation> fileInfomations;

}
