package com.maksymmikitiuk.university.service.user;

import com.maksymmikitiuk.university.dao.RoleDao;
import com.maksymmikitiuk.university.dao.UserDao;
import com.maksymmikitiuk.university.model.user.Role;
import com.maksymmikitiuk.university.model.user.User;
import com.maksymmikitiuk.university.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    RoleService roleService;

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findRoleByName("ROLE_USER"));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        user.setRoles(roles);
        userDao.saveAndFlush(user);
    }

    @Override
    public boolean validEmail(String email) {
        String query = "select case when (count(e) > 0)  then true else false end " +
                "from User e where LOWER(e.email) = LOWER(:email) and e.enabled";

        TypedQuery<Boolean> booleanQuery = em.createQuery(query, Boolean.class);
        return booleanQuery.getSingleResult();
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
}
