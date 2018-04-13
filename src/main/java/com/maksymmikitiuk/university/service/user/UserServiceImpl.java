package com.maksymmikitiuk.university.service.user;

import com.maksymmikitiuk.university.dao.UserDao;
import com.maksymmikitiuk.university.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public void save(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
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
