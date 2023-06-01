import model.ListingType;
import model.Property;
import model.SearchProperties;
import services.PropertyService;
import services.PropertyServiceImpl;
import services.UserService;
import services.UserServiceImpl;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    // Register a User: One time registration of the User.
    System.out.println("user registration");
    UserService userService = new UserServiceImpl();
    userService.registerUser("vivek");
    userService.registerUser("vivek");

    // List a property: Users can list the properties they want to sell.
    System.out.println("Property registration");
    PropertyService propertyService = new PropertyServiceImpl(userService);
    propertyService.listProperty("vivek", "location1", 100, ListingType.SELL, 1000, 3);
    propertyService.listProperty("vivek", "location2", 10, ListingType.RENT, 1000, 3);

    // View listed properties: Users can view properties listed by them.
    System.out.println("View listed properties");
    List<Property> listedProperties = propertyService.viewListedProperties("vivek");
    for(Property property : listedProperties) {
      System.out.println(property.toString());
    }

    // Shortlist a property: Users can short list properties they are interested in.
    System.out.println("shortlist property");
    propertyService.shortlistProperty("vivek", listedProperties.get(0).getId());

    // View shortlisted properties: Users can list properties they have shortlisted (including sold but with the status should be “SOLD”)
    System.out.println("View shortlisted properties");
    List<Property> shortlistedProperties = propertyService.viewShortlistedProperties("vivek");
    for(Property property : shortlistedProperties) {
      System.out.println(property.toString());
    }

    // Search Properties
    System.out.println("Search properties");
    SearchProperties searchProperties = new SearchProperties();
    searchProperties.setListingType(ListingType.SELL);
    List<Property> properties = propertyService.searchProperty(searchProperties);
    for(Property property : properties) {
      System.out.println(property.toString());
    }

    // Mark sold
    System.out.println("Make property sold");
    propertyService.markSold(listedProperties.get(0).getId());
    // Again view shortlist property
    System.out.println("Again view shortlist property");
    for(Property property : propertyService.viewShortlistedProperties("vivek")) {
      System.out.println(property.toString());
    }
  }
}
