package com.example.Lab3.contacts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
    @GetMapping
    public String index() {
        return "/contacts/contacts";
    }
}
