package com.example.SpringSecurityJWTExample.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/login_page")
    public String login_page() {
        return "login_page";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }
}