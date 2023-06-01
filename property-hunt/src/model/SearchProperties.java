package model;

public class SearchProperties {
  private String location;
  private PriceRange priceRange;
  private ListingType listingType;
  private SizeRange sizeRange;
  private Integer numberOfRooms;
  private SortBy sortBy;

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public PriceRange getPriceRange() {
    return priceRange;
  }

  public void setPriceRange(PriceRange priceRange) {
    this.priceRange = priceRange;
  }

  public ListingType getListingType() {
    return listingType;
  }

  public void setListingType(ListingType listingType) {
    this.listingType = listingType;
  }

  public SizeRange getSizeRange() {
    return sizeRange;
  }

  public void setSizeRange(SizeRange sizeRange) {
    this.sizeRange = sizeRange;
  }

  public Integer getNumberOfRooms() {
    return numberOfRooms;
  }

  public void setNumberOfRooms(int numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
  }

  public SortBy getSortBy() {
    return sortBy;
  }

  public void setSortBy(SortBy sortBy) {
    this.sortBy = sortBy;
  }
}
