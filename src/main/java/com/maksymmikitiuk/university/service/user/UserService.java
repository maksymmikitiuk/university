package com.maksymmikitiuk.university.service.user;

import com.maksymmikitiuk.university.model.user.User;

public interface UserService {
    User findUserByName(String username);

    void save(User user);

    boolean validEmail(String email);

    User findUserByEmail(String email);
}