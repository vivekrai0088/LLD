package com.vivek.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Show {
  private final String id;
  private final Movie movie;
  private final Screen screen;
  private final Date startTime;
  private final Integer durationInSeconds;
}
