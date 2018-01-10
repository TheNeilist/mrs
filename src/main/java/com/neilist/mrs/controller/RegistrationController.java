package com.neilist.mrs.controller;

import com.neilist.mrs.service.UserService;
import com.neilist.mrs.domain.User;
import com.neilist.mrs.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidationService userValidationService;

    @GetMapping("/register")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidationService.validateNewUser(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "register_success";
    }

}