package com.bookmystay.model;

/**
 * Abstract Room class
 * Represents common attributes and behavior for all room types.
 */
public abstract class Room {

    protected int beds;
    protected double price;

    // Display room details (implemented by subclasses)
    public abstract void displayRoomDetails();

    // Return room type as string ("Single", "Double", "Suite")
    public abstract String getRoomType();
}