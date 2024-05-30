package com.example.Lab3.order;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PhoneAttributeConverter implements AttributeConverter<Phone, String> {
    @Override
    public String convertToDatabaseColumn(Phone phone) {
        return phone.getPhone();
    }

    @Override
    public Phone convertToEntityAttribute(String s) {
        return new Phone(s);
    }
}
