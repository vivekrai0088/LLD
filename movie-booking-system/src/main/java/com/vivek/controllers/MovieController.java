package com.vivek.controllers;

import com.vivek.models.Movie;
import com.vivek.services.MovieService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class MovieController {

  private final MovieService movieService;

  public String addMovie(@NonNull final String id, @NonNull final String name) {
    Movie movie = movieService.createMovie(new Movie(id, name));
    return movie.getId();
  }
}
