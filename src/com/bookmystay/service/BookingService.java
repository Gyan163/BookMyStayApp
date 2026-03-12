package com.bookmystay.service;

import com.bookmystay.model.Booking;
import java.util.LinkedList;
import java.util.Queue;

public class BookingService {

    private Queue<Booking> bookingQueue = new LinkedList<>();

    // ✅ This method adds a booking to the queue
    public void addBooking(Booking booking) {
        bookingQueue.add(booking);
        System.out.println("Booking added for " + booking.getCustomerName());
    }

    // ✅ This method processes the next booking
    public void processBooking() {
        Booking booking = bookingQueue.poll();
        if (booking != null) {
            System.out.println("Processing booking for " + booking.getCustomerName());
        } else {
            System.out.println("No bookings available");
        }
    }
}
