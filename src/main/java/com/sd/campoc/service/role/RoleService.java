package com.sd.campoc.service.role;

import com.sd.campoc.model.Role;

public interface RoleService {

    Role findById(Long id);

    Role findByRoleName(String roleName);

}