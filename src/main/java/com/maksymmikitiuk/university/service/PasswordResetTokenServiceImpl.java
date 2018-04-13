package com.maksymmikitiuk.university.service;

import com.maksymmikitiuk.university.dao.PasswordResetTokenDao;
import com.maksymmikitiuk.university.dao.UserDao;
import com.maksymmikitiuk.university.model.PasswordResetToken;
import com.maksymmikitiuk.university.model.user.User;
import com.maksymmikitiuk.university.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {
    @Autowired
    PasswordResetTokenDao passwordResetTokenDao;

    @Override
    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenDao.findByToken(token);
    }

    @Override
    public void save(PasswordResetToken passwordResetToken) {
        passwordResetTokenDao.save(passwordResetToken);
    }

    @Override
    public void delete(PasswordResetToken passwordResetToken) {
        passwordResetTokenDao.delete(passwordResetToken);
    }

    @Override
    public PasswordResetToken findByUser(User user) {
        return passwordResetTokenDao.findByUser(user);
    }
}
