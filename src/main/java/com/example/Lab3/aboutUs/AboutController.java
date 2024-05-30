package com.example.Lab3.aboutUs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {
    @GetMapping
    public String index() {
        return "/aboutUs/about";
    }
}
