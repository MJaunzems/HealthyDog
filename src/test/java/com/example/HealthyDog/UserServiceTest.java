package com.example.HealthyDog;

import com.example.HealthyDog.Entities.UserEntity;
import com.example.HealthyDog.MyUserDetails;
import com.example.HealthyDog.Repositories.UserRepository;
import com.example.HealthyDog.Services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testChangePassword() {
        // Arrange
        String username = "testUser";
        String currentPassword = "oldPassword";
        String newPassword = "newPassword";

        UserEntity userEntity = new UserEntity();
        userEntity.setUserNickname(username);
        userEntity.setUserPassword("encodedOldPassword");

        when(userRepository.findByUserNickname(username)).thenReturn(Optional.of(userEntity));
        when(passwordEncoder.matches(currentPassword, userEntity.getUserPassword())).thenReturn(true);
        when(passwordEncoder.encode(newPassword)).thenReturn("encodedNewPassword");

        // Act
        userService.changePassword(username, currentPassword, newPassword);

        // Assert
        verify(userRepository, times(1)).save(userEntity);
        assertEquals("encodedNewPassword", userEntity.getUserPassword());
    }

    @Test
    void testChangePassword_IncorrectCurrentPassword() {
        // Arrange
        String username = "testUser";
        String currentPassword = "incorrectPassword";
        String newPassword = "newPassword";

        UserEntity userEntity = new UserEntity();
        userEntity.setUserNickname(username);
        userEntity.setUserPassword("encodedOldPassword");

        when(userRepository.findByUserNickname(username)).thenReturn(Optional.of(userEntity));
        when(passwordEncoder.matches(currentPassword, userEntity.getUserPassword())).thenReturn(false);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> userService.changePassword(username, currentPassword, newPassword));
        verify(userRepository, never()).save(userEntity);
    }

    @Test
    void testUpdateUser() {
        // Arrange
        String currentUsername = "testUser";
        String newUsername = "newTestUser";
        int newPhone = 123456789;
        String newEmail = "new@test.com";

        MyUserDetails userDetails = new MyUserDetails(new UserEntity(1L, "ROLE_USER", currentUsername, "test@example.com", 123456789, "password"));

        UserEntity existingUser = new UserEntity();
        existingUser.setUserNickname(currentUsername);

        when(userRepository.findByUserNickname(currentUsername)).thenReturn(Optional.of(existingUser));

        // Act
        userService.updateUser(userDetails, newUsername, newPhone, newEmail);

        // Assert
        verify(userRepository, times(1)).save(existingUser);
        assertEquals(newUsername, existingUser.getUserNickname());
        assertEquals(newPhone, existingUser.getUserPhone());
        assertEquals(newEmail, existingUser.getUserEmail());
    }

    @Test
    void testUpdateUser_UserNotFound() {
        // Arrange
        String currentUsername = "nonexistentUser";
        String newUsername = "newTestUser";
        int newPhone = 123456789;
        String newEmail = "new@test.com";

        MyUserDetails userDetails = new MyUserDetails(new UserEntity(1L, "ROLE_USER", currentUsername, "test@example.com", 123456789, "password"));

        when(userRepository.findByUserNickname(currentUsername)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> userService.updateUser(userDetails, newUsername, newPhone, newEmail));
        verify(userRepository, never()).save(any());
    }

    @Test
    void testLoadUserByUsername_UserNotFound() {
        String username = "nonExistentUser";
        when(userRepository.findByUserNickname(username)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(username));

        verify(userRepository, times(1)).findByUserNickname(username);
    }


}
