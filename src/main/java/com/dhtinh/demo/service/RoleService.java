package com.dhtinh.demo.service;

import java.util.List;

import com.dhtinh.demo.dto.RoleDTO;

public interface RoleService {
    public RoleDTO getRole(Long id);
    public List<RoleDTO> getRoles();
    public RoleDTO createRole(RoleDTO roleDTO);
    public RoleDTO updateRole(Long id, RoleDTO roleDTO);
    public void deleteRole(Long id);
}
