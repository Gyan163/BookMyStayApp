package com.bookmystay.service;

import com.bookmystay.model.Reservation;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue to hold booking requests in FIFO order
 */
public class BookingQueue {

    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add a reservation to the queue
    public void addBooking(Reservation reservation) {
        queue.offer(reservation); // FIFO insertion
        System.out.println("Added booking request: " + reservation);
    }

    // Poll the next reservation from the queue
    public Reservation pollNextRequest() {
        return queue.poll();
    }

    // Get current queue size
    public int getQueueSize() {
        return queue.size();
    }

    // Print all reservations in the queue
    public void printQueue() {
        for (Reservation r : queue) {
            System.out.println(r);
        }
    }
}