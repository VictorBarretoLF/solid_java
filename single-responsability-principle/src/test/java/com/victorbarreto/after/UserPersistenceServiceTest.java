package com.victorbarreto.after;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class UserPersistenceServiceTest {

    @Test
    void saveUser_storesUserSuccessfully() {
        // Arrange
        UserPersistenceService userPersistenceService = spy(new UserPersistenceService());
        User mockedUser = mock(User.class);
        Store mockedStore = mock(Store.class);

        // Use reflection to set the store field in UserPersistenceService
        try {
            java.lang.reflect.Field storeField =
                    UserPersistenceService.class.getDeclaredField("store");
            storeField.setAccessible(true);
            storeField.set(userPersistenceService, mockedStore);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            fail("Reflection setup failed: " + e.getMessage());
        }

        // Act
        userPersistenceService.saveUser(mockedUser);

        // Assert
        verify(mockedStore, times(1)).store(mockedUser);
    }

    @Test
    void saveUser_throwsExceptionWhenStoreFails() {
        UserPersistenceService userPersistenceService = spy(new UserPersistenceService());
        User mockedUser = mock(User.class);
        Store mockedStore = mock(Store.class);

        try {
            java.lang.reflect.Field storeField =
                    UserPersistenceService.class.getDeclaredField("store");
            storeField.setAccessible(true);
            storeField.set(userPersistenceService, mockedStore);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            fail("Reflection setup failed: " + e.getMessage());
        }

        doThrow(new RuntimeException("Store failed")).when(mockedStore).store(mockedUser);

        Assertions.assertThrows(RuntimeException.class, () -> userPersistenceService.saveUser(mockedUser));
    }

}
