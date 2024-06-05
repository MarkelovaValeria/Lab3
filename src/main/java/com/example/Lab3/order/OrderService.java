package com.example.Lab3.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderService {
    Order createOrder(CreateOrderParamaters paramaters);
    Order getOrder(OrderId orderId);

   Page<Order> getAllOrder(Pageable pageable);
   Order editOrder(OrderId orderId, EditOrderParamaters editOrderParamaters);
   void deleteOrder(OrderId orderId);
}
