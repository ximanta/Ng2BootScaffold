package com.stackroute.ng2boot.domain;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class Movie {
    @Id
    @ApiModelProperty(notes = "The database generated movie ID")
    private String id;
    @ApiModelProperty(notes = "The application-specific IMDB ID")
    private String imdbID;
    @ApiModelProperty(notes = "The amovie title")
    private String title;
    @ApiModelProperty(notes = "The movie released year")
    private String year;
    @ApiModelProperty(notes = "The movie poster")
    private String poster;


    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
