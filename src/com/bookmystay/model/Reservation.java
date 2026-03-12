package com.bookmystay.model;

/**
 * Reservation represents a booking request from a guest
 * Each object stores guest name, room type, and number of nights
 * This class is used to queue booking requests fairly in the system
 *
 * Key Concepts:
 * - Encapsulation: Fields are private and accessible only via getters
 * - Constructor: Initializes a booking request
 * - toString(): For easy console printing of reservations
 */
public class Reservation {

    // Fields to store reservation details
    private String guestName; // Name of the guest
    private String roomType;  // Type of room requested (Single, Double, Suite)
    private int nights;       // Number of nights for the stay

    /**
     * Constructor to create a new Reservation object
     * @param guestName Name of the guest
     * @param roomType Type of room requested
     * @param nights Number of nights
     */
    public Reservation(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Getter for guestName
    public String getGuestName() {
        return guestName;
    }

    // Getter for roomType
    public String getRoomType() {
        return roomType;
    }

    // Getter for nights
    public int getNights() {
        return nights;
    }

    /**
     * Override toString() to display reservation details easily
     * Example output:
     * Reservation{guestName='Alice', roomType='Single', nights=2}
     */
    @Override
    public String toString() {
        return "Reservation{" +
                "guestName='" + guestName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", nights=" + nights +
                '}';
    }
}
