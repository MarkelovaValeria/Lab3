package com.example.Lab3.order;

import java.time.LocalDate;

public class CreateOrderParamaters {
    private final UserName userName;
    private final Phone phone;
    private final Tour tour;
    private final TourGuide tourGuide;
    private final LocalDate dateTour;


    public CreateOrderParamaters(UserName userName, Phone phone, Tour tour, TourGuide tourGuide, LocalDate dateTour) {
        this.userName = userName;
        this.phone = phone;
        this.tour = tour;
        this.tourGuide = tourGuide;
        this.dateTour = dateTour;
    }

    public UserName getUserName() {
        return userName;
    }

    public Phone getPhone() {
        return phone;
    }

    public Tour getTour() {
        return tour;
    }

    public TourGuide getTourGuide() {
        return tourGuide;
    }

    public LocalDate getDateTour() {
        return dateTour;
    }
}
