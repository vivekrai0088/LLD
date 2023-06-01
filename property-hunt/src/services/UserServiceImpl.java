package services;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
  private Map<String, User> users;

  public UserServiceImpl() {
    users = new HashMap<>();
  }

  @Override
  public void registerUser(String name) {
    if(users.containsKey(name)) {
      System.out.println("User already exists");
    } else {
      User user = new User(name);
      users.put(name, user);
      System.out.println("User registered succesfully");
    }
  }

  @Override
  public User getUser(String name) {
    return users.get(name);
  }
}
