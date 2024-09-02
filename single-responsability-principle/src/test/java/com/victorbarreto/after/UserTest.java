package com.victorbarreto.after;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserTest {

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setAddress(String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setName(String)}
     *   <li>{@link User#toString()}
     *   <li>{@link User#getAddress()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getName()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        User actualUser = new User();
        actualUser.setAddress("42 Main St");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setName("Name");
        String actualToStringResult = actualUser.toString();
        String actualAddress = actualUser.getAddress();
        String actualEmail = actualUser.getEmail();

        // Assert that nothing has changed
        assertEquals("42 Main St", actualAddress);
        assertEquals("Name", actualUser.getName());
        assertEquals("User [name=Name, email=jane.doe@example.org, address=42 Main St]", actualToStringResult);
        assertEquals("jane.doe@example.org", actualEmail);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link User#User(String, String, String)}
     *   <li>{@link User#setAddress(String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setName(String)}
     *   <li>{@link User#toString()}
     *   <li>{@link User#getAddress()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getName()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        User actualUser = new User("Name", "jane.doe@example.org", "42 Main St");
        actualUser.setAddress("42 Main St");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setName("Name");
        String actualToStringResult = actualUser.toString();
        String actualAddress = actualUser.getAddress();
        String actualEmail = actualUser.getEmail();

        // Assert that nothing has changed
        assertEquals("42 Main St", actualAddress);
        assertEquals("Name", actualUser.getName());
        assertEquals("User [name=Name, email=jane.doe@example.org, address=42 Main St]", actualToStringResult);
        assertEquals("jane.doe@example.org", actualEmail);
    }

}
