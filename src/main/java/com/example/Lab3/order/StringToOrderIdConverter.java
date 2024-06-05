package com.example.Lab3.order;



import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.UUID;

@Component
public class StringToOrderIdConverter implements Converter<String, OrderId> {

    @Override
    public OrderId convert(@NotNull String source) {
        return new OrderId(UUID.fromString(source));
    }

}
