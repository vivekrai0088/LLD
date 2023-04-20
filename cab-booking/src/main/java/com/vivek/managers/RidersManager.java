package com.vivek.managers;

import com.vivek.exceptions.RiderAlreadyExistException;
import com.vivek.models.Rider;

import java.util.HashMap;
import java.util.Map;

public class RidersManager {

  private Map<String, Rider> riders;

  public RidersManager() {
    riders = new HashMap<>();
  }

  public void createRider(final Rider rider) {
    if(riders.containsKey(rider.getId())) {
      throw new RiderAlreadyExistException("rider already exist in system");
    }
    riders.put(rider.getId(), rider);
  }


  public Rider getRider(String riderId) {
    return riders.get(riderId);
  }
}
