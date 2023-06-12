package services;

import data.entity.User;

public interface UserService {
  boolean register(String userName, String password, String role);
  User login(String userName, String password);
  boolean suspendUser(Long userId);
}
