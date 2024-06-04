package com.example.Lab3.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface OrderRepository extends CrudRepository<Order, OrderId>, PagingAndSortingRepository<Order, OrderId>, OrderRepositoryCustom {
}