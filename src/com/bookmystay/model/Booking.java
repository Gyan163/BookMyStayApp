package com.bookmystay.model;

public class Booking {

    private int bookingId;
    private String customerName;
    private int hotelId;

    // ✅ Constructor that takes 3 arguments
    public Booking(int bookingId, String customerName, int hotelId) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.hotelId = hotelId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getHotelId() {
        return hotelId;
    }
}
