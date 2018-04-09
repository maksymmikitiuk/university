package com.maksymmikitiuk.university.controller;

import com.maksymmikitiuk.university.constants.Constants;
import com.maksymmikitiuk.university.model.PasswordResetToken;
import com.maksymmikitiuk.university.model.user.User;
import com.maksymmikitiuk.university.service.PasswordResetTokenService;
import com.maksymmikitiuk.university.service.email.EmailServiceImpl;
import com.maksymmikitiuk.university.service.user.UserService;
import com.maksymmikitiuk.university.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ForgotPassword {
    @Autowired
    UserService userService;

    @Autowired
    PasswordResetTokenService passwordResetTokenService;

    @Autowired
    public EmailServiceImpl emailService;

    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
    public String forgotPassword() {
        return "forgotpassword";
    }

    @RequestMapping(value = "/forgotpassword/email", method = RequestMethod.GET)
    @ResponseBody
    public String getEmail(@RequestParam(value = "email", required = true) String email) {
        User user = userService.findUserByEmail(email);

        PasswordResetToken passwordResetToken = passwordResetTokenService.findByUser(user);

        if(passwordResetToken != null)
            passwordResetTokenService.delete(passwordResetToken);

        if (user == null)
            return "null";

        String userToken = Util.generateCaptcha(Constants.CAPTCHA_LENGTH);

        passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(userToken);
        passwordResetToken.setUser(user);
        passwordResetToken.setExpiryDate(Constants.CAPTCHA_EXPIRATION);
        passwordResetTokenService.save(passwordResetToken);

        Map model = new HashMap();
        model.put("name", user.getUserPIB());
        model.put("reset_code", passwordResetToken.getToken());

        emailService.sendSimpleMessageUsingTemplate(user.getEmail(), "Reset Password", model, "reset_password");

        return user.getId().toString();
    }

    @RequestMapping(value = "/forgotpassword/valid_code", method = RequestMethod.GET)
    @ResponseBody
    public String validResetCode(@RequestParam(value = "valid_code", required = true) String resetCode,
                                 @RequestParam(value = "id", required = true) Long id) {
        PasswordResetToken passToken = passwordResetTokenService.findByToken(resetCode);
        if ((passToken == null) || (passToken.getUser().getId() != id))
            return "invalidToken";

        Calendar cal = Calendar.getInstance();
        if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0)
            return "expired";

        return resetCode;
    }

    @RequestMapping(value = "/forgotpassword/change_password", method = RequestMethod.GET)
    @ResponseBody
    public String validResetCode(@RequestParam(value = "token", required = true) String resetCode,
                                 @RequestParam(value = "id", required = true) Long id,
                                 @RequestParam(value = "new_password", required = true) String password) {
        PasswordResetToken passToken = passwordResetTokenService.findByToken(resetCode);
        if (passToken == null)
            return "false";

        User user = passToken.getUser();

        if (user.getId().equals(id)) {
            user.setPassword(password);
            userService.save(user);
            return "true";
        } else
            return "false";


    }
}
