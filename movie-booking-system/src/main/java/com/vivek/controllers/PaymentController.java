package com.vivek.controllers;

import com.vivek.services.BookingService;
import com.vivek.services.PaymentService;
import lombok.NonNull;

public class PaymentController {
  private final PaymentService paymentService;
  private final BookingService bookingService;

  public PaymentController(PaymentService paymentService, BookingService bookingService) {
    this.paymentService = paymentService;
    this.bookingService = bookingService;
  }

  public void paymentFailed(@NonNull final String bookingId, @NonNull final String user) {
    paymentService.processPaymentFailed(bookingService.getBooking(bookingId), user);
  }

  public void paymentSuccess(@NonNull final  String bookingId, @NonNull final String user) {
    bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
  }
}
