package com.stackroute.ng2boot.repositories;

import com.stackroute.ng2boot.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
