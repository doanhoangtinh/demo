package com.dhtinh.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "researching_project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResearchingProject extends Project {
    @Column(name = "challenge")
    private String challenge;

    @Column(name = "solution")
    private String solution;

    @Column(name = "benefit")
    private String benefit;
    
}
