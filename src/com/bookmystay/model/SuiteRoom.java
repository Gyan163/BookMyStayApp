package com.bookmystay.model;

/**
 * Represents a Suite Room
 */
public class SuiteRoom extends Room {

    public SuiteRoom() {
        this.beds = 3;
        this.price = 150.0;
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: Suite, Beds: " + beds + ", Price: $" + price);
    }

    @Override
    public String getRoomType() {
        return "Suite";
    }
}