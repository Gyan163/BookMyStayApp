package com.bookmystay;

import com.bookmystay.model.Reservation;
import com.bookmystay.model.Service;
import com.bookmystay.service.*;

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

        Reservation r1 = new Reservation("David", "Single", 2);
        Reservation r2 = new Reservation("Emma", "Double", 4);
        Reservation r3 = new Reservation("Frank", "Suite", 1);

        history.addBooking(r1);
        history.addBooking(r2);
        history.addBooking(r3);

        reportService.printAllBookings(history.getAllBookings());
        reportService.generateSummary(history.getAllBookings());


        // ==============================
        // Use Case 9: Validation & Error Handling
        // ==============================

        System.out.println("\n--- Use Case 9: Validation & Error Handling ---");

        Reservation validBooking = new Reservation("George", "Single", 2);
        Reservation invalidRoom = new Reservation("Harry", "Luxury", 2);
        Reservation invalidNights = new Reservation("Ivy", "Double", -1);

        Reservation[] testBookings = {validBooking, invalidRoom, invalidNights};

        for (Reservation r : testBookings) {
            try {
                System.out.println("\nProcessing booking for: " + r.getGuestName());
                BookingValidator.validate(r);
                System.out.println("Booking is valid ✅");
            } catch (InvalidBookingException e) {
                System.out.println("Booking failed ❌: " + e.getMessage());
            }
        }


        // ==============================
        // Use Case 10: Cancellation & Rollback
        // ==============================

        System.out.println("\n--- Use Case 10: Cancellation & Rollback ---");

        CancellationService cancelService = new CancellationService();

        Reservation c1 = new Reservation("Jack", "Single", 2);
        Reservation c2 = new Reservation("Kate", "Double", 3);

        cancelService.confirmBooking(c1);
        cancelService.confirmBooking(c2);

        cancelService.showInventory();

        cancelService.cancelBooking(c2);

        cancelService.showInventory();
        cancelService.showRollbackStack();


        // ==============================
        // Use Case 11: Concurrency & Synchronization
        // ==============================

        System.out.println("\n--- Use Case 11: Concurrency & Synchronization ---");

        ConcurrentBookingProcessor processor = new ConcurrentBookingProcessor();

        // Add bookings
        processor.addBooking(new Reservation("A1", "Single", 1));
        processor.addBooking(new Reservation("A2", "Single", 1));
        processor.addBooking(new Reservation("A3", "Single", 1));
        processor.addBooking(new Reservation("B1", "Double", 1));
        processor.addBooking(new Reservation("B2", "Double", 1));

        // Create threads
        BookingWorker t1 = new BookingWorker(processor, "Thread-1");
        BookingWorker t2 = new BookingWorker(processor, "Thread-2");

        // Start threads
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        processor.showInventory();
    }
}