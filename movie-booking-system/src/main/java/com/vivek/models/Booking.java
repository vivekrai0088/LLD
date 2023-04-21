package com.vivek.models;

import com.vivek.exceptions.InvalidStateException;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
public class Booking {
  private final String id;
  private final Show show;
  private final List<Seat> seatsBooked;
  private final String user;
  private BookingStatus bookingStatus;

  public Booking(@NonNull final String id, @NonNull final Show show, @NonNull final List<Seat> seatsBooked, @NonNull final String user) {
    this.id = id;
    this.show = show;
    this.seatsBooked = seatsBooked;
    this.user = user;
    this.bookingStatus = BookingStatus.CREATED;
  }

  public boolean isConfirmed() {
    return this.bookingStatus.equals(BookingStatus.CONFIRMED);
  }

  public void confirmBooking() {
    if(!this.bookingStatus.equals(BookingStatus.CREATED)) {
      throw new InvalidStateException("invalid state");
    }
    this.bookingStatus = BookingStatus.CONFIRMED;
  }

  public void expireBooking() {
    if(!this.bookingStatus.equals(BookingStatus.CREATED)) {
      throw new InvalidStateException("invalid state");
    }
    this.bookingStatus = BookingStatus.EXPIRED;
  }
}
