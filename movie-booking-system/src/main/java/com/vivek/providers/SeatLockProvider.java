package com.vivek.providers;

import com.vivek.models.Seat;
import com.vivek.models.Show;

import java.util.List;

public interface SeatLockProvider {
  void lockSeats(Show show, List<Seat> seat, String user);
  void unlockSeats(Show show, List<Seat> seat, String user);
  boolean validateLock(Show show, Seat seat, String user);

  List<Seat> getLockedSeats(Show show);
}
