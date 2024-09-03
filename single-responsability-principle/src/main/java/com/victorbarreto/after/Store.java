package com.victorbarreto.after;

import java.util.HashMap;
import java.util.Map;

/**
 * The Store class provides methods to store and retrieve User objects in memory.
 * It uses a static HashMap to store the User objects, ensuring thread safety
 * through synchronization.
 */
public class Store {

    private static final Map<String, User> STORAGE = new HashMap<>();

    /**
     * Stores a User object in the storage.
     *
     * @param user the User object to be stored
     * @throws IllegalArgumentException if the user is null
     */
    public void store(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        synchronized(STORAGE) {
            STORAGE.put(user.getName(), user);
        }
    }

    /**
     * Retrieves a User object from the storage by name.
     *
     * @param name the name of the User to be retrieved
     * @return the User object associated with the given name, or null if no such User exists
     */
    public User getUser(String name) {
        synchronized(STORAGE) {
            return STORAGE.get(name);
        }
    }

}