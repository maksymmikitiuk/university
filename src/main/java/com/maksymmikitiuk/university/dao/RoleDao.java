package com.maksymmikitiuk.university.dao;

import com.maksymmikitiuk.university.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MaksymMikitiuk on 13.04.2018.
 */
public interface RoleDao extends JpaRepository<Role, Long> {
    Role findByRoleIgnoreCase(String name);
}