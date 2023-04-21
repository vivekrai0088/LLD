package com.vivek.models;

import lombok.Getter;
import lombok.NonNull;
import sun.misc.GThreadHelper;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Screen {
  private final String id;
  private final String name;
  private final Theatre theatre;
  private final List<Seat> seats;

  public Screen(@NonNull final String id, @NonNull final String name, @NonNull final Theatre theatre) {
    this.id = id;
    this.name = name;
    this.theatre = theatre;
    this.seats = new ArrayList<>();
  }

  public void addSeat(@NonNull final Seat seat) {
    this.seats.add(seat);
  }
}
