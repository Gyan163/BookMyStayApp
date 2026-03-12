package com.bookmystay.model;

/**
 * SingleRoom is a concrete room type.
 */
public class SingleRoom extends Room {

    public SingleRoom() {
        super("Single", 1, 50.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + type + ", Beds: " + numberOfBeds + ", Price: $" + price);
    }
}
