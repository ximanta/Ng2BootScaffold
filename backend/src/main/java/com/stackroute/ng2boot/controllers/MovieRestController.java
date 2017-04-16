package com.stackroute.ng2boot.controllers;

import com.stackroute.ng2boot.services.MovieService;
import com.stackroute.ng2boot.domain.Movie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
@Api(value="moviestore", description="Operations pertaining to movies")
public class MovieRestController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @ApiOperation(value = "View a list of available movies",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Movie> list(Model model){
        Iterable<Movie> movieList = movieService.listAllMovies();
        return movieList;
    }

    @ApiOperation(value = "Search a movie with an ID",response = Movie.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public Movie showMovie(@PathVariable String id, Model model){
        Movie movie = movieService.getMovieById(id);
        return movie;
    }

    @ApiOperation(value = "Add a movie")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return new ResponseEntity("Movie saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a movie")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateMovie(@PathVariable String id, @RequestBody Movie movie){
        Movie storedMovie = movieService.getMovieById(id);
        storedMovie.setYear(movie.getYear());
        movieService.saveMovie(storedMovie);
        return new ResponseEntity("Movie year updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a movie")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable String id){
        movieService.deleteMovie(id);
        return new ResponseEntity("Movie deleted successfully", HttpStatus.OK);

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
         return "login";
    }

}
