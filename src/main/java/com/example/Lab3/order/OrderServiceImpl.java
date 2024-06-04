package com.example.Lab3.order;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order createOrder(CreateOrderParamaters paramaters) {
        OrderId orderId = repository.nextId();
        Order order = new Order(orderId,paramaters.getUserName(), paramaters.getPhone(), paramaters.getTour(), paramaters.getTourGuide(), paramaters.getDateTour());
        return repository.save(order);
    }

    @Override
    public Page<Order> getAllOrder(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
