package com.vivek.strategies;

import com.vivek.models.Cab;
import com.vivek.models.Location;
import com.vivek.models.Rider;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {
  @Override
  public Cab matchCabToRider(Rider rider, List<Cab> availableCabs, Location startLocation, Location endLocation) {
    return availableCabs.get(0);
  }
}
