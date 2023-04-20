package com.vivek.models;

import lombok.NonNull;
import lombok.ToString;

@ToString
public class Trip {
  private Cab cab;
  private Rider rider;
  private Double price;
  private TripStatus tripStatus;
  private Location startLocation;
  private Location endLocation;

  public Trip(
          @NonNull final Rider rider,
          @NonNull final Cab cab,
          @NonNull final Double price,
          @NonNull final Location fromPoint,
          @NonNull final Location toPoint) {
    this.rider = rider;
    this.cab = cab;
    this.price = price;
    this.startLocation = fromPoint;
    this.endLocation = toPoint;
    this.tripStatus = TripStatus.IN_PROGRESS;
  }

  public void endTrip() {
    tripStatus = TripStatus.FINISHED;
  }

}
