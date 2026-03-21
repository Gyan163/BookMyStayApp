package com.bookmystay.service;

public class BookingWorker extends Thread {

    private ConcurrentBookingProcessor processor;

    public BookingWorker(ConcurrentBookingProcessor processor, String name) {
        super(name);
        this.processor = processor;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            processor.processBooking();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}