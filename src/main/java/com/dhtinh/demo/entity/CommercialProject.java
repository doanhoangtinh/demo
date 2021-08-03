package com.dhtinh.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "commercial_project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommercialProject extends Project {

    @Column(name = "process")
    private String process;

    @Column(name = "advantage")
    private String advantage;

    @Column(name = "scope")
    private String scope;

    @ManyToOne
    @JoinColumn(name = "level_development_id")
    private LevelDevelopment levelDevelopment;

    @ManyToOne
    @JoinColumn(name = "transmission_method")
    private TransmissionMethod transmissionMethod;
}
