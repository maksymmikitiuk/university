package com.maksymmikitiuk.university.service;

import com.maksymmikitiuk.university.model.User;

public interface UserService {
    User findUserByName(String username);

    void  save(User user);
}