package com.bookmystay.model;

public class Reservation implements java.io.Serializable  {

    private String guestName;
    private String roomType;
    private int nights;

    // Constructor
    public Reservation(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Getters
    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    // toString (for printing nicely in queue/history)
    @Override
    public String toString() {
        return "[" + guestName + " - " + roomType + " - " + nights + " nights]";
    }

    // equals (VERY IMPORTANT for cancellation logic)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Reservation)) return false;

        Reservation r = (Reservation) obj;

        return guestName.equals(r.guestName) &&
                roomType.equals(r.roomType) &&
                nights == r.nights;
    }

    // hashCode (good practice with equals)
    @Override
    public int hashCode() {
        return guestName.hashCode() + roomType.hashCode() + nights;
    }
}