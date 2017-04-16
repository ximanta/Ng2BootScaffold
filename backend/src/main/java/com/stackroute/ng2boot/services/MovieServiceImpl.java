package com.stackroute.ng2boot.services;

import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Iterable<Movie> listAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(String id) {
        return movieRepository.findOne(id);
    }

    @Override
    public Movie saveMovie(Movie product) {
        return movieRepository.save(product);
    }

    @Override
    public void deleteMovie(String id) {
        movieRepository.delete(id);
    }
}
