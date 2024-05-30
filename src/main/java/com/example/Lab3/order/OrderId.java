package com.example.Lab3.order;

import io.github.wimdeblauwe.jpearl.AbstractEntityId;

import java.util.UUID;

public class OrderId extends AbstractEntityId<UUID> {

   /**
   * Default constructor for JPA
   */
   protected OrderId() {
   }

   public OrderId(UUID id) {
       super(id);
   }
}