package com.example.Lab3.order;

import org.springframework.data.annotation.Version;

import java.time.LocalDate;

public class EditOrderParamaters extends CreateOrderParamaters{


    private final long version;
    public EditOrderParamaters(long version, UserName userName, Phone phone, Tour tour, TourGuide tourGuide, LocalDate dateTour) {
        super(userName, phone, tour, tourGuide, dateTour);
        this.version = version;
    }

    public long getVersion() {
        return version;
    }


    public void update(Order order){
        order.setUserName(getUserName());
        order.setPhone(getPhone());
        order.setTour(getTour());
        order.setGuide(getTourGuide());
        order.setTour_date(getDateTour());
    }
}
