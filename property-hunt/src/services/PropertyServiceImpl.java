package services;

import model.ListingType;
import model.Property;
import model.SearchProperties;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyServiceImpl implements PropertyService {
  private Map<Integer, Property> properties;
  private UserService userService;

  public PropertyServiceImpl(UserService userService) {
    properties = new HashMap<>();
    this.userService = userService;
  }

  @Override
  public void listProperty(String userName, String location, double price, ListingType listingType, int size, int numberOfRooms) {
    User user = userService.getUser(userName);
    if(user != null) {
      Property property = new Property(location, price, listingType, size, numberOfRooms, user);
      properties.put(property.getId(), property);
      System.out.println("Property listed successfully");
    } else {
      System.out.println("User not exists");
    }
  }

  @Override
  public List<Property> viewListedProperties(String userName) {
    List<Property> listedProperties = new ArrayList<>();
    User user = userService.getUser(userName);
    if(user != null) {
      for(Property property : properties.values()) {
        if(property.getLister().equals(user)) {
          listedProperties.add(property);
        }
      }
    } else {
      System.out.println("User not exists");
    }
    return listedProperties;
  }

  @Override
  public void shortlistProperty(String userName, int propertyId) {
    User user = userService.getUser(userName);
    if(user != null) {
      Property property = properties.get(propertyId);
      if(property != null) {
        user.shortlistProperty(property);
        System.out.println("Property shortlisted successfully");
      } else {
        System.out.println("Property not exists");
      }
    } else {
      System.out.println("user not exists");
    }
  }

  @Override
  public List<Property> viewShortlistedProperties(String userName) {
    User user = userService.getUser(userName);
    List<Property> shortlistedProperties = new ArrayList<>();
    if(user != null) {
      shortlistedProperties.addAll(user.getShortlistedProperties());
    } else {
      System.out.println("User not exists");
    }
    return shortlistedProperties;
  }

  @Override
  public List<Property> searchProperty(SearchProperties searchProperties) {
    List<Property> filteredProperties = new ArrayList<>();
    for(Property property : properties.values()) {
      if(checkIfValid(property, searchProperties)) {
        filteredProperties.add(property);
      }
    }
    return filteredProperties;
  }

  private boolean checkIfValid(Property property, SearchProperties searchProperties) {
    if(searchProperties.getLocation() != null && !property.getLocation().equals(searchProperties.getLocation())) {
      return false;
    }
    if(searchProperties.getListingType() != null && !property.getListingType().equals(searchProperties.getListingType())) {
      return false;
    }
    if(searchProperties.getNumberOfRooms() != null && !property.getNumberOfRooms().equals(searchProperties.getNumberOfRooms())) {
      return false;
    }
    return true;
  }

  @Override
  public void markSold(int propertyId) {
    Property property = properties.get(propertyId);
    property.markSold(true);
    System.out.println("Marked property sold successfully");
  }
}
