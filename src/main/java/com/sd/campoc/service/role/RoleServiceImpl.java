package com.sd.campoc.service.role;

import com.sd.campoc.repositories.userrole.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sd.campoc.model.Role;


@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findById(Long id) {
        return roleRepository.findOne(id);
    }

    public Role findByRoleName(String roleName) {
        return roleRepository.findByName(roleName);
    }

}
