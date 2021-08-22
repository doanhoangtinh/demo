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
@Table(name = "transmisstion_method")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransmissionMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "code")
    private String code;
     
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "transmissionMethod")
    private List<CommercialProject> commercialProjects;
}
