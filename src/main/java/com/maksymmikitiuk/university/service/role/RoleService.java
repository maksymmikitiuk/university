package com.maksymmikitiuk.university.service.role;

import com.maksymmikitiuk.university.model.user.Role;

import java.util.List;

/**
 * Created by MaksymMikitiuk on 13.04.2018.
 */
public interface RoleService {

    void saveRole(Role role);

    void deleteRole(Long id);

    void editRole(Role role);

    Role findRoleByName(String name);

    Role findRoleById(Long id);

    List<Role> getListRoles();

}