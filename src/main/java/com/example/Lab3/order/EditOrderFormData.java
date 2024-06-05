package com.example.Lab3.order;


import org.springframework.data.annotation.Version;

public class EditOrderFormData extends CreateOrderFormData{
    private String id;
    private long version;

    public static EditOrderFormData fromOrder(Order order){
        EditOrderFormData result = new EditOrderFormData();
        result.setId(order.getId().asString());
        result.setVersion(order.getVersion());
        result.setFullName(order.getUserName().getFullName());
        result.setPhone(order.getPhone().getPhone());
        result.setTour(order.getTour());
        result.setGuide(order.getGuide());
        result.setTourDate(order.getDate());
        return result;
    }
    public EditOrderParamaters toParameters() {
        return new EditOrderParamaters(
                version, new UserName(getFullName()), new Phone(getPhone()), getTour(),
                getGuide(), getTourDate()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
