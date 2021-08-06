package com.dhtinh.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "group_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupDetail {
    @EmbeddedId
    private GroupDetailId id;

    @ManyToOne
    @JoinColumn(name = "role_of_group_id", nullable = false)
    private RoleOfGroup roleOfGroup;
}
