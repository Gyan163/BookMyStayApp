package com.bookmystay.model;

/**
 * SuiteRoom is a concrete room type.
 */
public class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite", 3, 150.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: " + type + ", Beds: " + numberOfBeds + ", Price: $" + price);
    }
}