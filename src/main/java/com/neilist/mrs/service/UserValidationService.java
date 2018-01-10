package com.neilist.mrs.service;

import com.neilist.mrs.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.thymeleaf.util.StringUtils;

@Service
public class UserValidationService {

    public BindingResult validateNewUser(User user, BindingResult bindingResult) {

        if (StringUtils.isEmpty(user.getPassword())) {
            bindingResult.addError(new FieldError("user", "password", "Passwords is required."));
        } else if (!user.getPassword().equals(user.getPassword2())) {
            bindingResult.addError(new FieldError("user", "password", "Password verification must match."));
        }

        if (user.getHost()) {
            if (StringUtils.isEmpty(user.getAddress1())) {
                bindingResult.addError(new FieldError("user","address1", "Address is required for meeting hosts."));
            }
        }

        if (user.getVolunteer()) {
            if (user.getTravelRange() == null || user.getTravelRange() < 1) {
                bindingResult.addError(new FieldError("user","travelRange", "Travel range is required for volunteers."));
            }
        }

        return bindingResult;
    }
}
