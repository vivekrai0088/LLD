package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
  private String name;
  Set<Property> shortlistedProperties;

  public User(String name) {
    this.name = name;
    shortlistedProperties = new HashSet<>();
  }

  public void shortlistProperty(Property property) {
    shortlistedProperties.add(property);
  }

  public List<Property> getShortlistedProperties() {
    return new ArrayList<>(this.shortlistedProperties);
  }
}
