package com.bookmystay.service;

import java.io.*;

public class PersistenceService {

    private static final String FILE_NAME = "system_state.dat";

    // SAVE STATE
    public static void save(SystemState state) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(state);
            System.out.println("System state saved successfully ✅");

        } catch (IOException e) {
            System.out.println("Error saving state ❌: " + e.getMessage());
        }
    }

    // LOAD STATE
    public static SystemState load() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            System.out.println("System state loaded successfully ✅");
            return (SystemState) ois.readObject();

        } catch (Exception e) {
            System.out.println("No previous state found. Starting fresh...");
            return null;
        }
    }
}