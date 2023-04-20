package com.vivek.controllers;

import com.vivek.managers.CabsManager;
import com.vivek.managers.TripsManager;
import com.vivek.models.Cab;
import com.vivek.models.Location;

public class CabsController {

  private CabsManager cabsManager;
  private TripsManager tripsManager;

  public CabsController(CabsManager cabsManager, TripsManager tripsManager) {
    this.cabsManager = cabsManager;
    this.tripsManager = tripsManager;
  }

  public void registerCab(final String cabId, final String driverName) {
    cabsManager.createCab(new Cab(cabId, driverName));
  }

  public void updateCabLocation(final String cabId, Double newX, Double newY) {
    cabsManager.updateCabLocation(cabId, new Location(newX, newY));
  }

  public void updateCabAvailability(final String cabId, boolean newAvailability) {
    cabsManager.updateCabAvailability(cabId, newAvailability);
  }

  public void endTrip(final String cabId) {
    tripsManager.endTrip(cabsManager.getCab(cabId));
  }

}
