package com.victorbarreto.after;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * Test class for UserController.
 * Contains unit tests for the createUser method.
 */
class UserControllerDiffblueTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Method under test: {@link UserController#createUser(String)}
     * Test case: Valid user data.
     * Expected result: "SUCCESS"
     */
    @Test
    void testCreateUserWithValidData() throws IOException {
        // Arrange
        UserController userController = new UserController();
        ObjectMapper objectMapper = new ObjectMapper();

        // Act and Assert
        assertEquals("SUCCESS", userController
                .createUser(objectMapper.writeValueAsString(new User("Name", "jane.doe@example.org", "42 Main St"))));
    }

    /**
     * Method under test: {@link UserController#createUser(String)}
     * Test case: User with empty name.
     * Expected result: "ERROR"
     */
    @Test
    void testCreateUserWithEmptyName() throws IOException {
        // Arrange
        UserController userController = new UserController();
        ObjectMapper objectMapper = new ObjectMapper();

        // Act and Assert
        assertEquals("ERROR", userController
                .createUser(objectMapper.writeValueAsString(new User(" ", "jane.doe@example.org", "42 Main St"))));
    }

    /**
     * Method under test: {@link UserController#createUser(String)}
     * Test case: User with invalid name.
     * Expected result: "ERROR"
     */
    @Test
    void testCreateUserWithInvalidName() throws IOException {
        // Arrange
        UserController userController = new UserController();
        ObjectMapper objectMapper = new ObjectMapper();

        // Act and Assert
        assertEquals("ERROR", userController
                .createUser(objectMapper.writeValueAsString(new User("U.U.U@U.U.U.U", "jane.doe@example.org", "42 Main St"))));
    }

    /**
     * Method under test: {@link UserController#createUser(String)}
     * Test case: User with empty email.
     * Expected result: "ERROR"
     */
    @Test
    void testCreateUserWithEmptyEmail() throws IOException {
        // Arrange
        UserController userController = new UserController();
        ObjectMapper objectMapper = new ObjectMapper();

        // Act and Assert
        assertEquals("ERROR",
                userController.createUser(objectMapper.writeValueAsString(new User("Name", " ", "42 Main St"))));
    }

    /**
     * Method under test: {@link UserController#createUser(String)}
     * Test case: User with invalid email.
     * Expected result: "ERROR"
     */
    @Test
    void testCreateUserWithInvalidEmail() throws IOException {
        // Arrange
        UserController userController = new UserController();
        ObjectMapper objectMapper = new ObjectMapper();

        // Act and Assert
        assertEquals("ERROR",
                userController.createUser(objectMapper.writeValueAsString(new User("Name", "U.U.U@U.U.U.U", "42 Main St"))));
    }

    /**
     * Method under test: {@link UserController#createUser(String)}
     * Test case: Empty user object.
     * Expected result: "ERROR"
     */
    @Test
    void testCreateUserWithEmptyUser() throws IOException {
        // Arrange
        UserController userController = new UserController();
        ObjectMapper objectMapper = new ObjectMapper();

        // Act and Assert
        assertEquals("ERROR", userController.createUser(objectMapper.writeValueAsString(new User())));
    }

    /**
     * Method under test: {@link UserController#createUser(String)}
     * Test case: User with name "ERROR".
     * Expected result: "ERROR"
     */
    @Test
    void testCreateUserWithErrorName() throws IOException {
        // Arrange
        UserController userController = new UserController();

        User user = new User();
        user.setName("ERROR");

        // Act
        String result = userController.createUser(objectMapper.writeValueAsString(user));

        // Assert
        assertEquals("ERROR", result);
    }

}