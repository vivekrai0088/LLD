package com.vivek.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
public class Cab {
  private String id;
  private String driverName;
  @Setter private Trip currentTrip;
  @Setter private boolean isAvailable;
  @Setter private Location currentLocation;

  public Cab(String id, String driverName) {
    this.id = id;
    this.driverName = driverName;
    this.isAvailable = true;
  }

  public void setLocation(Location location) {
    this.currentLocation = location;
  }

  public void setAvailability(boolean newAvailability) {
    this.isAvailable = newAvailability;
  }

  public boolean getIsAvailable() {
    return isAvailable;
  }

  @Override
  public String toString() {
    return "Cab{" +
            "id='" + id + '\'' +
            ", driverName='" + driverName + '\'' +
            ", currentLocation=" + currentLocation +
            ", isAvailable=" + isAvailable +
            '}';
  }
}
