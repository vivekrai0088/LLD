package com.vivek.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Seat {
  private final String id;
  private final Integer rowNo;
  private final Integer seatNo;
}
