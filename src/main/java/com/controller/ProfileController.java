package com.controller;

import com.model.User;
import com.service.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    private final UserService personService;

    public ProfileController(UserService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String onProfile(final HttpSession session, final Model model) {
        final int userId = (int) session.getAttribute("userId");

        final User userInfo = personService.get(userId);
        model.addAttribute("userInfo", userInfo);

        return "profile";
    }
}
