package com.example.authservice.service;

import com.example.authservice.model.User;
import com.example.authservice.model.UserSession;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.repository.UserSessionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private UserSessionRepository userSessionRepository;

  @InjectMocks
  private AuthServiceImpl authService;

  @BeforeEach
  public void setup() {
  }

  @Test
  public void testRegister() {
    User user = new User();
    authService.register(user);
    verify(userRepository).save(user);
  }

  @Test
  public void testLogin() {
    String username = "testUser";
    String password = "testPassword";
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);


    when(userRepository.findByUsername(username)).thenReturn(user);


    authService.login(username, password);


    verify(userSessionRepository).save(any(UserSession.class));
  }


  @Test
  public void testLogout() {
    Long userId = 1L;


    authService.logout(userId);

    verify(userSessionRepository).deleteByUserId(userId);
  }
}
