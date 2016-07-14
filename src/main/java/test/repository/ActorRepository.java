package test.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import test.model.Actor;

public interface ActorRepository extends GraphRepository<Actor> {
	@Query("MATCH (actors) -[:ACTED_IN]-> (movie: Movie) where id(movie)={0} return actors") 
	List<Actor> getActorsInMovie(Long movieId);
}
