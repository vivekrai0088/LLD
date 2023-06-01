package services;

import model.ListingType;
import model.Property;
import model.SearchProperties;

import java.util.List;

public interface PropertyService {
  void listProperty(String userName, String location, double price, ListingType listingType, int size, int numberOfRooms);

  List<Property> viewListedProperties(String userName);

  void shortlistProperty(String userName, int propertyId);

  List<Property> viewShortlistedProperties(String userName);

  List<Property> searchProperty(SearchProperties searchProperties);

  void markSold(int propertyId);
}
