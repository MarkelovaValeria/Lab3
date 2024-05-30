package com.example.Lab3.gallery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
    @GetMapping
    public String index() {
        return "/gallery/gallery";
    }

}
