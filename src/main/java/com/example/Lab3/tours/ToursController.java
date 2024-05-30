package com.example.Lab3.tours;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tours")
public class ToursController {
    @GetMapping public String index() {
        return "/tours/tours";
    }

}
