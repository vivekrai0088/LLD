package com.vivek.managers;

import com.vivek.exceptions.NoCabsAvailableException;
import com.vivek.exceptions.TripNotFoundException;
import com.vivek.models.Cab;
import com.vivek.models.Location;
import com.vivek.models.Rider;
import com.vivek.models.Trip;
import com.vivek.strategies.CabMatchingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripsManager {

  public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;

  private Map<String, List<Trip>> userTripsMapping;
  private CabsManager cabsManager;
  private CabMatchingStrategy cabMatchingStrategy;


  public TripsManager(CabsManager cabsManager, CabMatchingStrategy cabMatchingStrategy) {
    userTripsMapping = new HashMap<>();
    this.cabsManager = cabsManager;
    this.cabMatchingStrategy = cabMatchingStrategy;
  }

  public void createTrip(final Rider rider, Location startLocation, Location endLocation) {
    final List<Cab> closeByCabs = cabsManager.getCloseByCabs(startLocation, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
    final Cab selectedCab = cabMatchingStrategy.matchCabToRider(rider, closeByCabs, startLocation, endLocation);
    if (selectedCab == null) {
      throw new NoCabsAvailableException("no cabs available");
    }
    final Trip newTrip = new Trip(rider, selectedCab, 10.0, startLocation, endLocation);
    if (!userTripsMapping.containsKey(rider.getId())) {
      userTripsMapping.put(rider.getId(), new ArrayList<>());
    }
    userTripsMapping.get(rider.getId()).add(newTrip);
    selectedCab.setCurrentTrip(newTrip);
  }

  public List<Trip> fetchTripHistory(String riderId) {
    return userTripsMapping.get(riderId);
  }

  public void endTrip(Cab cab) {
    if(cab.getCurrentTrip() == null) {
      throw new TripNotFoundException("trip not found exception");
    }
    cab.getCurrentTrip().endTrip();
    cab.setCurrentTrip(null);
  }
}
