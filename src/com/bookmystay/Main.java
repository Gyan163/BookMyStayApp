package com.bookmystay;

import com.bookmystay.model.Room;
import com.bookmystay.model.SingleRoom;
import com.bookmystay.model.DoubleRoom;
import com.bookmystay.model.SuiteRoom;
import com.bookmystay.service.RoomInventory;
import com.bookmystay.search.SearchService;

import java.util.Arrays;
import java.util.List;

/**
 * Main class for Use Case 4: Search Available Rooms
 */
public class Main {

    public static void main(String[] args) {

        // --- Step 1: Create centralized inventory ---
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 5);
        inventory.addRoomType("Double", 3);
        inventory.addRoomType("Suite", 2);

        // --- Step 2: Create room objects ---
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // --- Step 3: Display room details (optional) ---
        singleRoom.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        suiteRoom.displayRoomDetails();

        // --- Step 4: Create a list of all rooms ---
        List<Room> rooms = Arrays.asList(singleRoom, doubleRoom, suiteRoom);

        // --- Step 5: Create SearchService ---
        SearchService searchService = new SearchService(inventory);

        // --- Step 6: Show available rooms (read-only) ---
        searchService.showAvailableRooms(rooms);

        // --- Step 7: Demonstrate that inventory is not modified ---
        System.out.println("\nInventory after search (should be unchanged):");
        inventory.displayInventory();
    }
}