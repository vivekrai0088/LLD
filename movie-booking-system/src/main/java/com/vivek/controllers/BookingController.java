package com.vivek.controllers;

import com.vivek.models.Seat;
import com.vivek.models.Show;
import com.vivek.services.BookingService;
import com.vivek.services.ShowService;
import com.vivek.services.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookingController {
  private final ShowService showService;
  private final BookingService bookingService;
  private final TheatreService theatreService;

  public String createBooking(@NonNull final String userId, @NonNull final String showId,
                              @NonNull final List<String> seatsIds) {
    final Show show = showService.getShow(showId);
    final List<Seat> seats = seatsIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
    return bookingService.createBooking(userId, show, seats).getId();
  }
}
