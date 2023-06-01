package model;

public class Property {
  private static int propertyId = 1;
  private int id;
  private String location;
  private double price;
  private ListingType listingType;
  private int size;
  private SizeUnit sizeUnit;
  private int numberOfRooms;
  private boolean isSold;
  private User lister;

  public Property(String location, double price, ListingType listingType, int size, int numberOfRooms, User lister) {
    this.id = propertyId++;
    this.location = location;
    this.price = price;
    this.listingType = listingType;
    this.size = size;
    this.numberOfRooms = numberOfRooms;
    this.lister = lister;
  }

  public int getId() {
    return this.id;
  }

  public User getLister() {
    return this.lister;
  }

  public String getLocation() {
    return this.location;
  }

  public Integer getNumberOfRooms() {
    return this.numberOfRooms;
  }

  public ListingType getListingType() {
    return this.listingType;
  }

  public String toString() {
    String soldStatus = (isSold) ? "SOLD" : "AVAILABLE";
    return "id = " + this.id + " ,location =" + location + " ,price = " + price + " ,size= " + size + " ,numebrOfRooms= " + numberOfRooms +
            " ,listingType= " + listingType + " ,status = " + soldStatus;
  }

  public void markSold(boolean isSold) {
    this.isSold = isSold;
  }

  public boolean getIsSold() {
    return this.isSold;
  }
}
