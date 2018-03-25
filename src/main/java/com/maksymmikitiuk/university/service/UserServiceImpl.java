package com.maksymmikitiuk.university.service;

import com.maksymmikitiuk.university.dao.UserDao;
import com.maksymmikitiuk.university.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

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
}
