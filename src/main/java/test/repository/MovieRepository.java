package test.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import test.model.Movie;

@Repository
public interface MovieRepository extends GraphRepository<Movie> {

}
