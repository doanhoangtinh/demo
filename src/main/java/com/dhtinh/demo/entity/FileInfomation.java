package com.dhtinh.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "file")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileInfomation {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "code", columnDefinition = "varchar(16) unique not null")
    private String code;
     
    @Column(name = "url", columnDefinition = "varchar(64) not null")
    private String url;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}
