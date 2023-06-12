package services;

import data.entity.Role;
import data.entity.User;
import data.entity.UserStatus;
import data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  private BCryptPasswordEncoder passwordEncoder;

  public boolean register(String userName, String password, String role) {
    if (userRepository.findByUserName(userName) != null) {
      System.out.println("User already exists");
      return false;
    }

    User user = User.builder().username(userName).password(password).role(Role.valueOf(role)).status(UserStatus.ACTIVE).build();
    userRepository.save(user);
    return false;
  }

  public User login(String userName, String password) {
    User user = userRepository.findByUserName(userName);
    if(user != null && passwordEncoder.matches(password, user.getPassword())) {
      return user;
    }
    return null;
  }

  public boolean suspendUser(Long userId) {
    User user = userRepository.getById(userId);
    if(!user.getRole().equals(Role.ADMIN)) {
      return false;
    }
    if(user != null) {
      user.setStatus(UserStatus.SUSPENDED);
      userRepository.save(user);
      return true;
    }
    return false;
  }
}
