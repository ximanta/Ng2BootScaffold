package com.stackroute.ng2boot.bootstrap;

import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.repositories.MovieRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MovieSeedDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private MovieRepository movieRepository;

    private Logger log = Logger.getLogger(MovieSeedDataLoader.class);

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Movie movie1 = new Movie();
        movie1.setImdbID("tt0068646");
        movie1.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BZTRmNjQ1ZDYtNDgzMy00OGE0LWE4N2YtNTkzNWQ5ZDhlNGJmL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg");
        movie1.setTitle("The Godfather");
        movie1.setYear("1972");
        movieRepository.save(movie1);
        log.info("Saved Movie - Name: " + movie1.getTitle());

        Movie movie2 = new Movie();
        movie2.setImdbID("tt0120338");
        movie2.setPoster("https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg");
        movie2.setTitle("Titanic");
        movie2.setYear("1997");
        movieRepository.save(movie2);
        log.info("Saved Movie - Name: " + movie2.getTitle());

    }
}
