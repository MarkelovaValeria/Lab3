package com.example.Lab3.order;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

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
    public Order getOrder(OrderId orderId) {
        return repository.findById(orderId).orElse(null);
    }

    @Override
    public Page<Order> getAllOrder(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Order editOrder(OrderId orderId, EditOrderParamaters editOrderParamaters) {
        System.out.println(editOrderParamaters.getVersion());

        Order order = repository
                .findById(orderId)
                .orElseThrow(()-> new NoSuchElementException("order not found"));
        System.out.println(order.getVersion());
        if(editOrderParamaters.getVersion()!= order.getVersion()){
            throw new ObjectOptimisticLockingFailureException(Order.class, order.getId().asString());
        }
        System.out.println(order);
        editOrderParamaters.update(order);
        return order;
    }

    @Override
    public void deleteOrder(OrderId orderId) {
        if(!repository.existsById(orderId)){
            throw new NoSuchElementException("order not found");
        }
        repository.deleteById(orderId);
    }
}
