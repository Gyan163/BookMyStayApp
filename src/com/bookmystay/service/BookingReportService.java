package com.bookmystay.service;

import com.bookmystay.model.Reservation;
import java.util.List;

public class BookingReportService {

    // Print all bookings
    public void printAllBookings(List<Reservation> bookings) {
        System.out.println("\n--- Booking History ---");

        for (Reservation r : bookings) {
            System.out.println(
                    "Guest: " + r.getGuestName() +
                            ", Room: " + r.getRoomType() +
                            ", Nights: " + r.getNights()
            );
        }
    }

    // Generate summary report
    public void generateSummary(List<Reservation> bookings) {
        System.out.println("\n--- Booking Summary ---");

        int totalBookings = bookings.size();
        int totalNights = 0;

        for (Reservation r : bookings) {
            totalNights += r.getNights();
        }

        System.out.println("Total Bookings: " + totalBookings);
        System.out.println("Total Nights Booked: " + totalNights);
    }
}