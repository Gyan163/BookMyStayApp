package com.bookmystay.service;

import com.bookmystay.model.Reservation;
import java.util.*;

/**
 * Handles booking requests and assigns rooms safely while updating inventory.
 */
public class BookingService {

    private Map<String, Set<String>> assignedRooms; // roomType -> assigned room IDs
    private Map<String, Integer> inventory;         // roomType -> available count

    public BookingService(Map<String, Integer> inventory) {
        this.inventory = inventory;
        this.assignedRooms = new HashMap<>();
        // Initialize sets for each room type
        for (String roomType : inventory.keySet()) {
            assignedRooms.put(roomType, new HashSet<>());
        }
    }

    // Process a single reservation request
    public boolean processReservation(Reservation reservation) {
        String roomType = reservation.getRoomType();

        // Check availability
        int available = inventory.getOrDefault(roomType, 0);
        if (available <= 0) {
            System.out.println("No rooms available for type: " + roomType + " for guest " + reservation.getGuestName());
            return false;
        }

        // Generate unique room ID
        String roomId;
        do {
            roomId = roomType.substring(0,1).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0,5);
        } while (assignedRooms.get(roomType).contains(roomId));

        // Assign room and update inventory
        assignedRooms.get(roomType).add(roomId);
        inventory.put(roomType, available - 1);

        System.out.println("Reservation confirmed for " + reservation.getGuestName() +
                ". Assigned Room ID: " + roomId);

        return true;
    }

    // Process all reservations in the queue
    public void processQueue(BookingQueue bookingQueue) {
        System.out.println("\nProcessing all booking requests...");
        while (bookingQueue.getQueueSize() > 0) {
            Reservation res = bookingQueue.pollNextRequest();
            processReservation(res);
        }
    }
}