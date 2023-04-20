package com.vivek.controllers;

import com.vivek.managers.RidersManager;
import com.vivek.managers.TripsManager;
import com.vivek.models.Location;
import com.vivek.models.Rider;
import com.vivek.models.Trip;

import java.util.List;

public class RidersController {
  private RidersManager ridersManager;
  private TripsManager tripsManager;

  public RidersController(RidersManager ridersManager, TripsManager tripsManager) {
    this.ridersManager = ridersManager;
    this.tripsManager = tripsManager;
  }

  public void registerRider(final String riderId, final String riderName) {
    ridersManager.createRider(new Rider(riderId, riderName));
  }

  public void book(final String riderId, final Double sourceX, final Double sourceY, final Double destX, final Double destY) {
    tripsManager.createTrip(ridersManager.getRider(riderId), new Location(sourceX, sourceY), new Location(destX, destY));
  }

  public List<Trip> fetchTripHistory(final String riderId) {
    return tripsManager.fetchTripHistory(riderId);
  }

}
