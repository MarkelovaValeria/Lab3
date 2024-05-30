package com.example.Lab3.order;

import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;

import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepositoryCustom {
    private final UniqueIdGenerator<UUID> generator;

    public OrderRepositoryImpl(UniqueIdGenerator<UUID> generator) {
        this.generator = generator;
    }

    @Override
    public OrderId nextId() {
        return new OrderId(generator.getNextUniqueId());
    }
}