package com.bookmystay.service;

import com.bookmystay.model.Reservation;
import java.util.Arrays;
import java.util.List;

public class BookingValidator {

    // Allowed room types
    private static final List<String> VALID_ROOMS =
            Arrays.asList("Single", "Double", "Suite");

    public static void validate(Reservation reservation)
            throws InvalidBookingException {

        // 1. Validate guest name
        if (reservation.getGuestName() == null ||
                reservation.getGuestName().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty");
        }

        // 2. Validate room type
        if (!VALID_ROOMS.contains(reservation.getRoomType())) {
            throw new InvalidBookingException(
                    "Invalid room type: " + reservation.getRoomType());
        }

        // 3. Validate nights
        if (reservation.getNights() <= 0) {
            throw new InvalidBookingException(
                    "Number of nights must be greater than 0");
        }

        // 4. Prevent unrealistic values
        if (reservation.getNights() > 30) {
            throw new InvalidBookingException(
                    "Booking exceeds maximum allowed nights (30)");
        }
    }
}