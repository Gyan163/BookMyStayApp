package com.bookmystay.model;

public class Service {
    private String serviceId;
    private String serviceName;
    private double price;

    public Service(String serviceId, String serviceName, double price) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }
}
