package com.bookmystay;

import com.bookmystay.model.Room;
import com.bookmystay.model.SingleRoom;
import com.bookmystay.model.DoubleRoom;
import com.bookmystay.model.SuiteRoom;

/**
 * Main application entry point for Use Case 2.
 * Demonstrates room types, inheritance, and availability.
 */
public class Main {

    public static void main(String[] args) {

        // Room availability variables
        int singleRoomsAvailable = 5;
        int doubleRoomsAvailable = 3;
        int suiteRoomsAvailable = 2;

        // Create room objects using polymorphism
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Display room details and availability
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomsAvailable + "\n");

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomsAvailable + "\n");

        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomsAvailable + "\n");
    }
}