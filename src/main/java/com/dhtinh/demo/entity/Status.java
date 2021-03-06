package com.dhtinh.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "status")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Status {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "code")
    private String code;
     
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "status")
    private List<Project> projects;
}
