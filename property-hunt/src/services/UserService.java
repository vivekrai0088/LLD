package services;

import model.User;

public interface UserService {
  void registerUser(String name);
  User getUser(String name);
}
