package com.bookmystay;

import com.bookmystay.model.Room;
import com.bookmystay.model.SingleRoom;
import com.bookmystay.model.DoubleRoom;
import com.bookmystay.model.SuiteRoom;
import com.bookmystay.service.RoomInventory;

/**
 * Main application entry point for Use Case 3.
 * Demonstrates centralized room inventory using HashMap.
 */
public class Main {

    public static void main(String[] args) {

        // Create centralized inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 5);
        inventory.addRoomType("Double", 3);
        inventory.addRoomType("Suite", 2);

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Display room details
        singleRoom.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        suiteRoom.displayRoomDetails();

        System.out.println();

        // Display centralized inventory
        inventory.displayInventory();

        System.out.println("\nBooking a Single room...");
        if (inventory.bookRoom("Single")) {
            System.out.println("Booking successful!");
        } else {
            System.out.println("No Single rooms available.");
        }

        // Display updated inventory
        inventory.displayInventory();
    }
}