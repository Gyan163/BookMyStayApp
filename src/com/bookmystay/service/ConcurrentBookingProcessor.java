package com.bookmystay.service;

import com.bookmystay.model.Reservation;
import java.util.*;

public class ConcurrentBookingProcessor {

    // Shared booking queue
    private Queue<Reservation> bookingQueue = new LinkedList<>();

    // Shared inventory
    private Map<String, Integer> inventory = new HashMap<>();

    public ConcurrentBookingProcessor() {
        inventory.put("Single", 2);
        inventory.put("Double", 2);
        inventory.put("Suite", 1);
    }

    // Add booking request (shared resource)
    public synchronized void addBooking(Reservation reservation) {
        bookingQueue.add(reservation);
        System.out.println(Thread.currentThread().getName() +
                " added booking for " + reservation.getGuestName());
    }

    // Process booking (CRITICAL SECTION)
    public synchronized void processBooking() {

        if (bookingQueue.isEmpty()) return;

        Reservation r = bookingQueue.poll();

        String roomType = r.getRoomType();

        int available = inventory.getOrDefault(roomType, 0);

        if (available > 0) {
            inventory.put(roomType, available - 1);

            System.out.println(Thread.currentThread().getName() +
                    " allocated " + roomType + " room to " + r.getGuestName());
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " FAILED booking for " + r.getGuestName() +
                    " (No rooms available)");
        }
    }

    // Show inventory
    public void showInventory() {
        System.out.println("Final Inventory: " + inventory);
    }
}