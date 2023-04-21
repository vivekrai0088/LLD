package com.vivek.services;

import com.vivek.exceptions.NotFoundException;
import com.vivek.models.Booking;
import com.vivek.models.Seat;
import com.vivek.models.Show;
import com.vivek.providers.SeatLockProvider;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class BookingService {
  private final Map<String, Booking> showBookings;
  private final SeatLockProvider seatLockProvider;

  public BookingService(SeatLockProvider seatLockProvider) {
    this.seatLockProvider = seatLockProvider;
    this.showBookings = new HashMap<>();
  }

  public Booking getBooking(@NonNull final String bookingId) {
    if (!showBookings.containsKey(bookingId)) {
      throw new NotFoundException("booking not found");
    }
    return showBookings.get(bookingId);
  }

  public List<Booking> getAllBookings(@NonNull final Show show) {
    List<Booking> response = new ArrayList<>();
    for (Booking booking : showBookings.values()) {
      if (booking.getShow().equals(show)) {
        response.add(booking);
      }
    }

    return response;
  }

  public Booking createBooking(@NonNull final String userId, @NonNull final Show show,
                               @NonNull final List<Seat> seats) {
    if (isAnySeatAlreadyBooked(show, seats)) {
      throw new RuntimeException();
    }
    seatLockProvider.lockSeats(show, seats, userId);
    final String bookingId = UUID.randomUUID().toString();
    final Booking newBooking = new Booking(bookingId, show, seats, userId);
    showBookings.put(bookingId, newBooking);
    return newBooking;
    // TODO: Create timer for booking expiry
  }

  public List<Seat> getBookedSeats(@NonNull final Show show) {
    return getAllBookings(show).stream()
            .filter(Booking::isConfirmed)
            .map(Booking::getSeatsBooked)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
  }

  public void confirmBooking(@NonNull final Booking booking, @NonNull final String user) {
    if (!booking.getUser().equals(user)) {
      throw new RuntimeException();
    }

    for (Seat seat : booking.getSeatsBooked()) {
      if (!seatLockProvider.validateLock(booking.getShow(), seat, user)) {
        throw new RuntimeException();
      }
    }
    booking.confirmBooking();
  }

  private boolean isAnySeatAlreadyBooked(final Show show, final List<Seat> seats) {
    final List<Seat> bookedSeats = getBookedSeats(show);
    for (Seat seat : seats) {
      if (bookedSeats.contains(seat)) {
        return true;
      }
    }
    return false;
  }
}
