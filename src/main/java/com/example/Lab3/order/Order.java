package com.example.Lab3.order;

import io.github.wimdeblauwe.jpearl.AbstractEntity;

import io.github.wimdeblauwe.jpearl.AbstractVersionedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="tt_order")
public class Order extends AbstractVersionedEntity<OrderId> {
    @NotNull
    private UserName userName;
    @NotNull
    private Phone phone;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Tour tour;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TourGuide guide;
    @NotNull
    private LocalDate tour_date;
    /**
     * Default constructor for JPA
     */
    protected Order() {
    }

    public Order(OrderId id, UserName userName, Phone phone, Tour tour, TourGuide guide, LocalDate tour_date) {
        super(id);
        this.userName = userName;
        this.phone = phone;
        this.tour = tour;
        this.guide = guide;
        this.tour_date = tour_date;
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

    public TourGuide getGuide() {
        return guide;
    }

    public LocalDate getDate() {
        return tour_date;
    }

    public void setUserName(UserName userName) {
        this.userName = userName;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public void setGuide(TourGuide guide) {
        this.guide = guide;
    }

    public LocalDate getTour_date() {
        return tour_date;
    }

    public void setTour_date(LocalDate tour_date) {
        this.tour_date = tour_date;
    }
}