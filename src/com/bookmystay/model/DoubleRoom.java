package com.bookmystay.model;

/**
 * DoubleRoom is a concrete room type.
 */
public class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double", 2, 90.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + type + ", Beds: " + numberOfBeds + ", Price: $" + price);
    }
}
