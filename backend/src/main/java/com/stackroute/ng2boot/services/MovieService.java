package com.stackroute.ng2boot.services;


import com.stackroute.ng2boot.domain.Movie;

public interface MovieService {
    Iterable<Movie> listAllMovies();

    Movie getMovieById(String id);

    Movie saveMovie(Movie movie);

    void deleteMovie(String id);
}
