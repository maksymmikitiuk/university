package com.maksymmikitiuk.university.dao;

import com.maksymmikitiuk.university.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MaksymMikitiuk on 13.04.2018.
 */
public interface EmailDao extends JpaRepository<Mail, Long> {

}
