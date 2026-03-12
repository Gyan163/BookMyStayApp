package com.bookmystay.search;

import com.bookmystay.model.Room;
import com.bookmystay.service.RoomInventory;
import java.util.List;

/**
 * SearchService allows guests to view available rooms without modifying inventory.
 * Implements read-only access and separation of concerns.
 */
public class SearchService {

    private RoomInventory inventory;

    // Constructor: inject RoomInventory
    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Display all rooms that have availability > 0
     * @param rooms List of all room objects
     */
    public void showAvailableRooms(List<Room> rooms) {
        System.out.println("\n--- Available Rooms ---");
        for (Room room : rooms) {
            String type = room.getRoomType(); // "Single", "Double", "Suite"
            int available = inventory.getAvailability(type);

            // Only show rooms with availability
            if (available > 0) {
                room.displayRoomDetails();
                System.out.println("Available: " + available + "\n");
            }
        }
    }
}
