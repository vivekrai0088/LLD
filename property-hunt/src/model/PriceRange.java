package model;

public class PriceRange {
  private double startPrice;
  private double endPrice;

  public PriceRange(double startPrice, double endPrice) {
    this.startPrice = startPrice;
    this.endPrice = endPrice;
  }

  public double getStartPrice() {
    return startPrice;
  }

  public double getEndPrice() {
    return endPrice;
  }
}
