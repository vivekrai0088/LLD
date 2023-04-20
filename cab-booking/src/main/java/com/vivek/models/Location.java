package com.vivek.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Location {
  private Double x;
  private Double y;

  public Double getDistance(Location currentLocation) {
    return Math.sqrt(Math.pow(this.x - currentLocation.x, 2) + Math.pow(this.y - currentLocation.y, 2));
  }
}
