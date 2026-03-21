package com.bookmystay.service;

import com.bookmystay.model.Reservation;
import java.io.Serializable;
import java.util.*;

public class SystemState implements Serializable {

    private List<Reservation> bookingHistory;
    private Map<String, Integer> inventory;

    public SystemState(List<Reservation> bookingHistory,
                       Map<String, Integer> inventory) {
        this.bookingHistory = bookingHistory;
        this.inventory = inventory;
    }

    public List<Reservation> getBookingHistory() {
        return bookingHistory;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}