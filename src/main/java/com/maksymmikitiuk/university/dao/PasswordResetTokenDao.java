package com.maksymmikitiuk.university.dao;

import com.maksymmikitiuk.university.model.PasswordResetToken;
import com.maksymmikitiuk.university.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenDao extends JpaRepository<PasswordResetToken, Long>, JpaSpecificationExecutor<PasswordResetToken>, PagingAndSortingRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(User user);
}
