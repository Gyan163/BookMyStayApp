package com.bookmystay.service;

import com.bookmystay.model.Service;
import java.util.*;

public class AddOnServiceManager {

    // Map to store: Reservation ID → List of Services
    private Map<String, List<Service>> reservationServices = new HashMap<>();


    // ✅ Add a service to a reservation
    public void addService(String reservationId, Service service) {

        reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);

        System.out.println(service.getServiceName() +
                " added to reservation " + reservationId);
    }


    // ✅ Get all services for a reservation
    public List<Service> getServices(String reservationId) {

        return reservationServices.getOrDefault(
                reservationId, new ArrayList<>());
    }


    // ✅ Calculate total cost of services
    public double calculateTotalCost(String reservationId) {

        double total = 0;

        List<Service> services = reservationServices.get(reservationId);

        if (services != null) {
            for (Service s : services) {
                total += s.getPrice();
            }
        }

        return total;
    }
}
