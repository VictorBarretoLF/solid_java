package com.victorbarreto.after;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserValidatorTest {

    @Test
    void validateUser_returnsFalseWhenNameIsEmpty() {
        UserValidator userValidator = new UserValidator();
        assertFalse(userValidator.validateUser(new User("", "jane.doe@example.org", "42 Main St")));
    }

    @Test
    void validateUser_returnsFalseWhenNameContainsSpecialCharacters() {
        UserValidator userValidator = new UserValidator();
        assertFalse(userValidator.validateUser(new User("Name!", "jane.doe@example.org", "42 Main St")));
    }

    @Test
    void validateUser_returnsFalseWhenEmailIsInvalid() {
        UserValidator userValidator = new UserValidator();
        assertFalse(userValidator.validateUser(new User("Name", "invalid-email", "42 Main St")));
    }

    @Test
    void validateUser_returnsTrueWhenUserIsValid() {
        UserValidator userValidator = new UserValidator();
        assertTrue(userValidator.validateUser(new User("ValidName", "valid.email@example.com", "42 Main St")));
    }

    @Test
    void validateUser_returnsFalseWhenEmailIsEmpty() {
        UserValidator userValidator = new UserValidator();
        assertFalse(userValidator.validateUser(new User("ValidName", "", "42 Main St")));
    }

    @Test
    void validateUser_returnsFalseWhenNameIsNull() {
        UserValidator userValidator = new UserValidator();
        User user = new User(null, "jane.doe@example.org", "42 Main St");
        assertFalse(userValidator.validateUser(user));
    }

    @Test
    void validateUser_returnsFalseWhenEmailIsNull() {
        UserValidator userValidator = new UserValidator();
        User user = new User("ValidName", null, "42 Main St");
        assertFalse(userValidator.validateUser(user));
    }

}
