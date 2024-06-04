package com.example.Lab3.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Order createOrder(CreateOrderParamaters paramaters);

   Page<Order> getAllOrder(Pageable pageable);
}
