package com.bookmystay.model;

public class Hotel {

    private int hotelId;
    private String hotelName;
    private int availableRooms;

    public Hotel(int hotelId, String hotelName, int availableRooms) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.availableRooms = availableRooms;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }
}
