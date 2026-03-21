package com.bookmystay;

import com.bookmystay.model.Reservation;
import com.bookmystay.model.Service;
import com.bookmystay.service.AddOnServiceManager;
import com.bookmystay.service.BookingQueue;
import com.bookmystay.service.BookingHistory;
import com.bookmystay.service.BookingReportService;

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

        Service food = new Service("S1", "Food Package", 500);
        Service pickup = new Service("S2", "Airport Pickup", 1000);
        Service spa = new Service("S3", "Spa Access", 1500);

        String reservationId = "R101";

        addOnManager.addService(reservationId, food);
        addOnManager.addService(reservationId, pickup);
        addOnManager.addService(reservationId, spa);

        double totalCost = addOnManager.calculateTotalCost(reservationId);

        System.out.println("\nTotal Add-On Cost: " + totalCost);


        // ==============================
        // Use Case 8: Booking History & Reports
        // ==============================

        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // Simulating confirmed bookings
        Reservation r1 = new Reservation("David", "Single", 2);
        Reservation r2 = new Reservation("Emma", "Double", 4);
        Reservation r3 = new Reservation("Frank", "Suite", 1);

        // Store bookings in history
        history.addBooking(r1);
        history.addBooking(r2);
        history.addBooking(r3);

        // Display booking history
        reportService.printAllBookings(history.getAllBookings());

        // Generate summary report
        reportService.generateSummary(history.getAllBookings());
    }
}