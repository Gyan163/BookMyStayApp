package com.bookmystay.service;

import com.bookmystay.model.Reservation;
import java.util.*;

public class BookingHistory {

    // List to store confirmed bookings
    private List<Reservation> confirmedBookings = new ArrayList<>();

    // Add confirmed booking
    public void addBooking(Reservation reservation) {
        confirmedBookings.add(reservation);
        System.out.println("Booking stored in history for: " + reservation.getGuestName());
    }

    // Get all bookings
    public List<Reservation> getAllBookings() {
        return confirmedBookings;
    }
}