package com.bookmystay;

import com.bookmystay.model.Reservation;
import com.bookmystay.service.BookingQueue;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");

        // --- Use Case 5: Booking Request Queue ---
        BookingQueue bookingQueue = new BookingQueue();

        // Create sample reservations
        Reservation r1 = new Reservation("Alice", "Single", 2);
        Reservation r2 = new Reservation("Bob", "Double", 3);
        Reservation r3 = new Reservation("Charlie", "Suite", 1);

        // Add requests to the queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display all queued requests
        bookingQueue.showAllRequests();

        // Peek at the next reservation (without removing)
        System.out.println("\nNext reservation to process: " + bookingQueue.peekNextRequest());

        // Process (remove) the next reservation
        System.out.println("\nProcessing reservation: " + bookingQueue.pollNextRequest());

        // Display remaining requests after polling
        bookingQueue.showAllRequests();
    }
}