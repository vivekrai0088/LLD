package com.vivek.managers;

import com.vivek.exceptions.CabAlreadyExistsException;
import com.vivek.exceptions.CabNotExistsException;
import com.vivek.models.Cab;
import com.vivek.models.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabsManager {
  private Map<String, Cab> cabs;

  public CabsManager() {
    cabs = new HashMap<>();
  }

  public void createCab(Cab cab) {
    if(cabs.containsKey(cab.getId())) {
      throw new CabAlreadyExistsException("cab already exists");
    }
    cabs.put(cab.getId(), cab);
  }

  public void updateCabLocation(String cabId, Location location) {
    if(!cabs.containsKey(cabId)) {
      throw new CabNotExistsException("cab not exists");
    }
    Cab cab = cabs.get(cabId);
    cab.setLocation(location);
  }


  public void updateCabAvailability(String cabId, boolean newAvailability) {
    if(!cabs.containsKey(cabId)) {
      throw new CabNotExistsException("cab not exists");
    }
    Cab cab = cabs.get(cabId);
    cab.setAvailability(newAvailability);
  }

  public Cab getCab(String cabId) {
    if(!cabs.containsKey(cabId)) {
      throw new CabNotExistsException("cab not exists");
    }
    return cabs.get(cabId);
  }

  public List<Cab> getCloseByCabs(Location startLocation, Double distance) {
    List<Cab> result = new ArrayList<>();
    for(Cab cab : cabs.values()) {
      if(cab.getIsAvailable() && startLocation.getDistance(cab.getCurrentLocation()) <= distance) {
        result.add(cab);
      }
    }
    return result;
  }
}
