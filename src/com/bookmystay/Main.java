package com.bookmystay;

import com.bookmystay.model.Reservation;
import com.bookmystay.model.Service;
import com.bookmystay.service.AddOnServiceManager;
import com.bookmystay.service.BookingQueue;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App v1.0\n");

        // ==============================
        // Use Case 5 & 6: Booking Queue
        // ==============================

        BookingQueue bookingQueue = new BookingQueue();

        bookingQueue.addBooking(new Reservation("Alice", "Single", 2));
        bookingQueue.addBooking(new Reservation("Bob", "Double", 3));
        bookingQueue.addBooking(new Reservation("Charlie", "Suite", 1));

        System.out.println("\nCurrent Booking Requests in Queue:");
        bookingQueue.printQueue();


        // ==============================
        // Use Case 7: Add-On Services
        // ==============================

        AddOnServiceManager addOnManager = new AddOnServiceManager();

        // Create services
        Service food = new Service("S1", "Food Package", 500);
        Service pickup = new Service("S2", "Airport Pickup", 1000);
        Service spa = new Service("S3", "Spa Access", 1500);

        // Example reservation ID (can be improved later)
        String reservationId = "R101";

        // Add services
        addOnManager.addService(reservationId, food);
        addOnManager.addService(reservationId, pickup);
        addOnManager.addService(reservationId, spa);

        // Calculate total cost
        double totalCost = addOnManager.calculateTotalCost(reservationId);

        System.out.println("\nTotal Add-On Cost: " + totalCost);
    }
}