package com.example.Lab3;

import com.example.Lab3.order.*;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Profile("init-db")
public class DatabaseInitializer implements CommandLineRunner {
    private final Faker faker = new Faker();
    private OrderService orderService;

    public DatabaseInitializer(OrderService orderService){
        this.orderService = orderService;
    }
    @Override
    public void run(String... args) throws Exception {
        for(int i = 0; i<20; i++){
            CreateOrderParamaters paramaters = newRandomOrderParameters();
            orderService.createOrder(paramaters);
        }
    }

    private CreateOrderParamaters newRandomOrderParameters(){
        Name name = faker.name();
        UserName userName = new UserName(name.fullName());
        Phone phone = new Phone(faker.phoneNumber().phoneNumber());
        LocalDate dateTour = LocalDate.ofInstant(faker.date().between(new Date(2024, 1, 1), new Date(2025, 1, 1)).toInstant(), ZoneId.systemDefault());
        Tour tour = Tour.values()[faker.random().nextInt(Tour.values().length)];
        TourGuide guide = TourGuide.values()[faker.random().nextInt(TourGuide.values().length)];
        return new CreateOrderParamaters(userName, phone, tour, guide,dateTour);
    }
}
