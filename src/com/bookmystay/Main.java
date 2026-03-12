package com.bookmystay;

import com.bookmystay.model.Reservation;
import com.bookmystay.service.BookingQueue;
import com.bookmystay.service.BookingService;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App v1.0\n");

        // =========================
        // Use Case 5: Booking Queue
        // =========================
        BookingQueue bookingQueue = new BookingQueue();

        bookingQueue.addBooking(new Reservation("Alice", "Single", 2));
        bookingQueue.addBooking(new Reservation("Bob", "Double", 3));
        bookingQueue.addBooking(new Reservation("Charlie", "Suite", 1));

        System.out.println("\nCurrent Booking Requests in Queue:");
        bookingQueue.printQueue();

        // =========================
        // Use Case 6: Booking Service
        // =========================
        // Initialize inventory
        Map<String, Integer> roomInventory = new HashMap<>();
        roomInventory.put("Single", 2);
        roomInventory.put("Double", 1);
        roomInventory.put("Suite", 1);

        // Create booking service
        BookingService bookingService = new BookingService(roomInventory);

        // Process all booking requests in the queue
        bookingService.processQueue(bookingQueue);

        System.out.println("\nAll bookings processed. Remaining inventory:");
        roomInventory.forEach((type, count) ->
                System.out.println(type + " Rooms left: " + count));
    }
}