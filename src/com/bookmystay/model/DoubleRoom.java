package com.bookmystay.model;

/**
 * Represents a Double Room
 */
public class DoubleRoom extends Room {

    public DoubleRoom() {
        this.beds = 2;
        this.price = 90.0;
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: Double, Beds: " + beds + ", Price: $" + price);
    }

    @Override
    public String getRoomType() {
        return "Double";
    }
}