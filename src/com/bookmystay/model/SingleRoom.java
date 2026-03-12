package com.bookmystay.model;

/**
 * Represents a Single Room
 */
public class SingleRoom extends Room {

    public SingleRoom() {
        this.beds = 1;
        this.price = 50.0;
    }

    @Override
    public void displayRoomDetails() {
        System.out.println("Room Type: Single, Beds: " + beds + ", Price: $" + price);
    }

    @Override
    public String getRoomType() {
        return "Single";
    }
}