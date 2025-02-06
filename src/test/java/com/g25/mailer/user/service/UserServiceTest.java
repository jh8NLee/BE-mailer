package com.g25.mailer.user.service;

import com.g25.mailer.user.dto.*;
import com.g25.mailer.user.entity.User;
import com.g25.mailer.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {
//
//    @InjectMocks
//    private UserService userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    public UserServiceTest() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    /**
//     * Test: createUser
//     */
//    @Test
//    public void testCreateUser() {
//        AddUserRequest request = new AddUserRequest("test@test.com", "testpassword");
//
//        when(userRepository.existsByLoginId("testUser")).thenReturn(false);
//        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
//        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
//
//        User mockUser = User.builder()
//                .id(1L)
//                .loginId("testUser")
//                .password("encodedPassword")
//                .name("Test Name")
//                .email("test@example.com")
//                .contact("123-456-7890")
//                .role(User.Role.USER)
//                .status(User.Status.ACTIVE)
//                .build();
//
//        when(userRepository.save(any(User.class))).thenReturn(mockUser);
//
//        UserRes response = userService.createUser(request);
//
//        assertNotNull(response);
//        assertEquals("testUser", response.getLoginId());
//        assertEquals("Test Name", response.getName());
//        verify(userRepository, times(1)).save(any(User.class));
//    }
//
//    /**
//     * Test: getAllUsers
//     */
//    @Test
//    public void testGetAllUsers() {
//        User mockUser = User.builder()
//                .id(1L)
//                .loginId("testUser")
//                .password("encodedPassword")
//                .name("Test Name")
//                .email("test@example.com")
//                .contact("123-456-7890")
//                .role(User.Role.USER)
//                .status(User.Status.ACTIVE)
//                .build();
//
//        when(userRepository.findAll()).thenReturn(Collections.singletonList(mockUser));
//
//        List<UserRes> users = userService.getAllUsers();
//
//        assertNotNull(users);
//        assertEquals(1, users.size());
//        assertEquals("testUser", users.get(0).getLoginId());
//    }
//
//    /**
//     * Test: getUserById
//     */
//    @Test
//    public void testGetUserById() {
//        User mockUser = User.builder()
//                .id(1L)
//                .loginId("testUser")
//                .password("encodedPassword")
//                .name("Test Name")
//                .email("test@example.com")
//                .contact("123-456-7890")
//                .role(User.Role.USER)
//                .status(User.Status.ACTIVE)
//                .build();
//
//        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));
//
//        UserRes userRes = userService.getUserById(1L);
//
//        assertNotNull(userRes);
//        assertEquals("testUser", userRes.getLoginId());
//        assertEquals("Test Name", userRes.getName());
//    }
//
//    /**
//     * Test: updateUser
//     */
//    @Test
//    public void testUpdateUser() {
//        UserUpdateReq request = new UserUpdateReq("Updated Name", "updated@example.com", "987-654-3210", User.Role.ADMIN, User.Status.ACTIVE);
//
//        User existingUser = User.builder()
//                .id(1L)
//                .loginId("testUser")
//                .password("encodedPassword")
//                .name("Test Name")
//                .email("test@example.com")
//                .contact("123-456-7890")
//                .role(User.Role.USER)
//                .status(User.Status.ACTIVE)
//                .build();
//
//        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
//        when(userRepository.save(any(User.class))).thenReturn(existingUser);
//
//        UserRes updatedUser = userService.updateUser(1L, request);
//
//        assertNotNull(updatedUser);
//        assertEquals("Updated Name", updatedUser.getName());
//        assertEquals("updated@example.com", updatedUser.getEmail());
//        verify(userRepository, times(1)).save(existingUser);
//    }
//
//    /**
//     * Test: deleteUser
//     */
//    @Test
//    public void testDeleteUser() {
//        when(userRepository.existsById(1L)).thenReturn(true);
//
//        userService.deleteUser(1L);
//
//        verify(userRepository, times(1)).deleteById(1L);
//    }
}
