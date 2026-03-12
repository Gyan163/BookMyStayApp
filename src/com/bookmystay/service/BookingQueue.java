package com.bookmystay.service;

import com.bookmystay.model.Reservation;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages booking requests in FIFO order
 */
public class BookingQueue {

    private Queue<Reservation> requestQueue;

    // Constructor
    public BookingQueue() {
        this.requestQueue = new LinkedList<>();
    }

    /**
     * Add a booking request to the queue
     */
    public void addRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Added booking request: " + reservation);
    }

    /**
     * Check the next reservation without removing it
     */
    public Reservation peekNextRequest() {
        return requestQueue.peek();
    }

    /**
     * Process (remove) the next reservation
     */
    public Reservation pollNextRequest() {
        return requestQueue.poll();
    }

    /**
     * Display all queued requests
     */
    public void showAllRequests() {
        System.out.println("\nCurrent Booking Requests in Queue:");
        for (Reservation r : requestQueue) {
            System.out.println(r);
        }
    }

    /**
     * Get number of requests in the queue
     */
    public int getQueueSize() {
        return requestQueue.size();
    }
}
