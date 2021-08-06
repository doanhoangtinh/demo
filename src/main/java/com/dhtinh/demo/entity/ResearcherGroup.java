package com.dhtinh.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "researcher_group")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResearcherGroup {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(columnDefinition = "tinyint")
    private Long id;
    
    @Column(name = "code", columnDefinition = "varchar(8) unique not null")
    private String code;
     
    @Column(name = "name", columnDefinition = "nvarchar(16) not null")
    private String name;
}
