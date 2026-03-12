package com.bookmystay.model;

/**
 * Abstract Room class representing a general room concept.
 * Cannot be instantiated directly.
 */
public abstract class Room {

    protected String type;
    protected int numberOfBeds;
    protected double price;

    public Room(String type, int numberOfBeds, double price) {
        this.type = type;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
    }

    // Abstract method to display room details
    public abstract void displayRoomDetails();

    // Getters
    public String getType() { return type; }
    public int getNumberOfBeds() { return numberOfBeds; }
    public double getPrice() { return price; }
}