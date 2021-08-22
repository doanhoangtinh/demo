package com.dhtinh.demo.service.impl;

import java.util.List;

import com.dhtinh.demo.dto.RoleDTO;
import com.dhtinh.demo.entity.Role;
import com.dhtinh.demo.repository.RoleRepository;
import com.dhtinh.demo.service.RoleService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = new Role();
        mapper.map(roleDTO, role);
        Role roleCreated = roleRepository.save(role);
        if(roleCreated != null){
            RoleDTO returnValue = new RoleDTO();
            mapper.map(roleCreated, returnValue);
            return returnValue;
        }
		return null;
    }

    @Override
    public void deleteRole(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public RoleDTO getRole(Long id) {
        Role role = roleRepository.findOneById(id);
        if(role != null){
            RoleDTO returnValue = new RoleDTO();
            mapper.map(role, returnValue);
            return returnValue;
        }
        return null;
    }

    @Override
    public List<RoleDTO> getRoles() {
        List<Role> roles = roleRepository.findAll();
        if(roles.size()>0){
            List<RoleDTO> returnValue = mapper.map(roles, new TypeToken<List<RoleDTO>>(){}.getType());
            return returnValue;
        }
        return null;
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        // TODO Auto-generated method stub
        return null;
    }
   
}
