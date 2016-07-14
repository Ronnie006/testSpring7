package test.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import test.model.Actor;

public interface ActorRepository extends GraphRepository<Actor> {

}
