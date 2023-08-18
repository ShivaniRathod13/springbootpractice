package com.jwt.example;

import com.jwt.example.controllers.AuthController;
import com.jwt.example.entities.User;
import com.jwt.example.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_add_create_user() {
        User user = new User();
        user.setName("Deepika");
        user.setPassword("abc");
        user.setEmail("deepika@gmail.com");
        user.setAbout("this is testing");




        when(userService.createUser(any(User.class))).thenReturn(user);
        User createdUser = authController.createUser(user);
        assertEquals(user, createdUser);
        verify(userService, times(1)).createUser(user);
    }
}
