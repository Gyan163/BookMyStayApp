package com.bookmystay.service;

import com.bookmystay.model.Reservation;
import java.util.*;

public class CancellationService {

    // Active bookings
    private List<Reservation> activeBookings = new ArrayList<>();

    // Stack for rollback (LIFO)
    private Stack<String> releasedRoomStack = new Stack<>();

    // Simulated inventory
    private Map<String, Integer> roomInventory = new HashMap<>();

    public CancellationService() {
        roomInventory.put("Single", 5);
        roomInventory.put("Double", 5);
        roomInventory.put("Suite", 5);
    }

    // Confirm booking (add to active list + reduce inventory)
    public void confirmBooking(Reservation reservation) {

        activeBookings.add(reservation);

        String roomType = reservation.getRoomType();
        roomInventory.put(roomType, roomInventory.get(roomType) - 1);

        System.out.println("Booking confirmed for " + reservation.getGuestName());
    }

    // Cancel booking
    public void cancelBooking(Reservation reservation) {

        // Validate existence
        if (!activeBookings.contains(reservation)) {
            System.out.println("Cancellation failed ❌: Booking does not exist");
            return;
        }

        // Remove booking
        activeBookings.remove(reservation);

        // Simulate room ID
        String roomId = reservation.getRoomType() + "-ROOM";

        // Push to stack (rollback)
        releasedRoomStack.push(roomId);

        // Restore inventory
        String roomType = reservation.getRoomType();
        roomInventory.put(roomType, roomInventory.get(roomType) + 1);

        System.out.println("Booking cancelled for " + reservation.getGuestName());
        System.out.println("Room released: " + roomId);
    }

    // Display inventory
    public void showInventory() {
        System.out.println("\nCurrent Inventory: " + roomInventory);
    }

    // Show rollback stack
    public void showRollbackStack() {
        System.out.println("Rollback Stack: " + releasedRoomStack);
    }
}