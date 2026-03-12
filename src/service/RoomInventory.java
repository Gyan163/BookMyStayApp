package com.bookmystay.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages centralized room inventory using HashMap.
 */
public class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public boolean bookRoom(String roomType) {
        int available = inventory.getOrDefault(roomType, 0);
        if (available > 0) {
            inventory.put(roomType, available - 1);
            return true;
        }
        return false;
    }

    public void cancelBooking(String roomType) {
        int available = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, available + 1);
    }

    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " available");
        }
    }
}
