package com.maksymmikitiuk.university.service;

import com.maksymmikitiuk.university.model.PasswordResetToken;
import com.maksymmikitiuk.university.model.user.User;

public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    void save(PasswordResetToken passwordResetToken);

    void delete(PasswordResetToken passwordResetToken);

    PasswordResetToken findByUser(User user);
}