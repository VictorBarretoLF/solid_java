package com.victorbarreto.after;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StoreTest {

    @Test
    void storeAndRetrieveUserSuccessfully() {
        // Arrange
        Store store = new Store();
        User user = new User("John", "john@example.com", "123 Main St");

        // Act
        store.store(user);
        User retrievedUser = store.getUser("John");

        // Assert
        Assertions.assertEquals(user, retrievedUser);
    }

    @Test
    void retrieveNonExistentUserReturnsNull() {
        // Arrange
        Store store = new Store();

        // Act
        User retrievedUser = store.getUser("NonExistentUser");

        // Assert
        Assertions.assertNull(retrievedUser);
    }

    @Test
    void storeNullUser() {
        // Arrange
        Store store = new Store();

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> store.store(null));
    }

    @Test
    void retrieveUserWithNullName() {
        // Arrange
        Store store = new Store();

        // Act
        User retrievedUser = store.getUser(null);

        // Assert
        Assertions.assertNull(retrievedUser);
    }

}
