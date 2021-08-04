package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutCompanyController {
    @GetMapping(value = "/about")
    public String allServices() {
        return "aboutCompany";
    }
}
