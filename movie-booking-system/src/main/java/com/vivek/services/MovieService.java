package com.vivek.services;

import com.vivek.exceptions.NotFoundException;
import com.vivek.exceptions.NotFoundException;
import com.vivek.models.Movie;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class MovieService {

  private final Map<String, Movie> movies;

  public MovieService() {
    this.movies = new HashMap<>();
  }

  public Movie createMovie(@NonNull final Movie movie) {
    if(movies.containsKey(movie.getId())) {
      throw new NotFoundException("movie already exists exception");
    }
    movies.put(movie.getId(), movie);
    return movie;
  }

  public Movie getMovie(@NonNull final String id) {
    if(!movies.containsKey(id)) {
      throw new NotFoundException("movie not found exception");
    }
    return movies.get(id);
  }
}
