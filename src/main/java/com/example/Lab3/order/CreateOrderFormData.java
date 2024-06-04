package com.example.Lab3.order;

import com.example.Lab3.order.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class CreateOrderFormData {
    @NotBlank(message = "{order.fullName.notnull}")
    @ValidFullName
    private String fullName;
    @NotBlank(message = "{order.phone.notBlank}")
    @Pattern(regexp = "[0-9.\\-() x/+]+", message = "{order.phone.pattern}")
    private String phone;
    @NotNull(message = "{order.tour.notnull}")
    private Tour tour;
    @NotNull(message = "{order.guide.notnull}")
    private TourGuide guide;
    @NotNull(message = "{order.date.notnull}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tourDate;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public TourGuide getGuide() {
        return guide;
    }

    public void setGuide(TourGuide guide) {
        this.guide = guide;
    }

    public LocalDate getTourDate() {
        return tourDate;
    }

    public void setTourDate(LocalDate tourDate) {
        this.tourDate = tourDate;
    }

    public CreateOrderParamaters toParameters(){
        return new CreateOrderParamaters(new UserName(fullName), new Phone(phone), tour, guide, tourDate);
    }

}
