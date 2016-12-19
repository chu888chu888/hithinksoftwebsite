package com.hithinksoft.homepage.validation;

import com.hithinksoft.homepage.domain.user.User;
import com.hithinksoft.homepage.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Li_Zhensong on 2016/8/12.
 */
@Component
public class UserValidator implements Validator {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userRepository.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "constraints.user.username.exists");
        }
        if (user.getRepassword() != null && !user.getPassword().equals(user.getRepassword())) {
            errors.rejectValue("repassword", "constraints.user.rePassword.notEqualsToPassword");
        }
    }
}
