package com.controller;

import com.model.User;
import com.service.interfaces.UserService;
import com.utils.HashPasswordUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    public @ResponseBody
    ResponseEntity<Object> login(@RequestParam("email") final String email,
                                 @RequestParam("password") final String password) {


        User user = userService.getPersonByCredentials(email);

        if (user != null) {

            final boolean validPassword = HashPasswordUtil.checkPassword(password, user.getPassword());

            if (validPassword) {

                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attr.getRequest().getSession(true); // true == allow create
                session.setAttribute("user", email);
                session.setAttribute("userId", user.getId());

            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }
    @GetMapping("/logout")
    public String logout() {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(false); // true == allow create
        session.invalidate();

        return "redirect:/";
    }
}
