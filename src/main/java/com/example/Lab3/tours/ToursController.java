package com.example.Lab3.tours;

import com.example.Lab3.order.*;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tours")
public class ToursController {
    private final OrderService orderService;

    public ToursController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping public String index(Model model, Pageable pageable) {
        model.addAttribute("orders", orderService.getAllOrder(pageable));
        return "/tours/tours";
    }
    @GetMapping("/add")
    public String createUserForm(Model model) {
        model.addAttribute("order", new CreateOrderFormData());
        model.addAttribute("tours", List.of(Tour.tour1, Tour.tour2, Tour.tour3));
        model.addAttribute("guides", List.of(TourGuide.guide1, TourGuide.guide2, TourGuide.guide3));
        return "/tours/add";
    }
    @PostMapping("/add")
    public String createOrder(@Valid
                              @ModelAttribute("order") CreateOrderFormData formData,
                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tours", List.of(Tour.tour1,Tour.tour2, Tour.tour3));
            model.addAttribute("guides", List.of(TourGuide.guide1, TourGuide.guide2, TourGuide.guide3));
            return "tours/add";
        }
        orderService.createOrder(formData.toParameters());
        return "redirect:/tours";
    }


}
