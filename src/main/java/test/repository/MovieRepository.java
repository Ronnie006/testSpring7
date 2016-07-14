package test.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import test.model.Movie;

@Repository
public interface MovieRepository extends GraphRepository<Movie> {
	 @Query("MATCH (n) WHERE id(n)={0} RETURN n")
	    Movie getMovieFromId(Long idOfMovie);

	 @Query("MATCH (movies) <-[:ACTED_IN]- (actor :Actor) where id(actor) = {0} RETURN movies")
	List<Movie> getMoviesByActor(Long actorId);

	
}
