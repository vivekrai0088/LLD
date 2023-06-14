package controllers;

import data.entity.User;
import dtos.UserDto;
import lombok.RequiredArgsConstructor;
import mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
  private final UserService userService;
  private final UserMapper userMapper;

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
    boolean registered = userService.register(username, password, role);
    if (registered) {
      return ResponseEntity.ok("User registered successfully");
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
    }
  }

  @PostMapping("/login")
  public ResponseEntity<UserDto> loginUser(@RequestParam String username, @RequestParam String password) {
    User user = userService.login(username, password);
    if (user != null) {
      return ResponseEntity.ok(userMapper.toDto(user));
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

  @PostMapping("/suspend/{userId}")
  public ResponseEntity<String> suspendUser(@PathVariable Long userId) {
    boolean suspended = userService.suspendUser(userId);
    if (suspended) {
      return ResponseEntity.ok("User suspended successfully");
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to suspend user");
    }
  }
}

