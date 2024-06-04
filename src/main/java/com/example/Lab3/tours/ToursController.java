package com.example.Lab3.tours;

import com.example.Lab3.order.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
