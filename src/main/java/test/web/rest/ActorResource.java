package test.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.model.Actor;
import test.repository.ActorRepository;

@RestController
@RequestMapping("/api")
public class ActorResource {
	
	private static final Logger log = LoggerFactory.getLogger(ActorResource.class);
	
	@Autowired
	ActorRepository actorRepository;
	
	@RequestMapping(value="/actor", method=RequestMethod.POST)
	public void saveMovie(@RequestBody Actor actor){
		actorRepository.save(actor);
		log.info("|SAVED|" + actor);
	}
	
	@RequestMapping(value="/actor", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Actor>> getActors(){
		Iterable<Actor> actors = actorRepository.findAll();
		return new ResponseEntity<Iterable<Actor>>(actors,HttpStatus.OK);
	}
	
	@RequestMapping(value="/actor/{id}", method=RequestMethod.DELETE)
	public void deleteActor(@PathVariable("id") Long id){
		Actor actor= actorRepository.findOne(id);
		actorRepository.delete(actor);
		log.info("|DELETED|");
	}
	
	@RequestMapping(value="/actor/{id}", method=RequestMethod.GET)
	public ResponseEntity<Actor> getMovie(@PathVariable Long id){
		Actor actor = actorRepository.findOne(id);
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);
	}
	
	@RequestMapping(value="/movie/{id}/actors", method=RequestMethod.GET)
	public ResponseEntity<List<Actor>> getActorsWhoActedInMovie(@PathVariable("id") Long movieId){
		List<Actor> actors = actorRepository.getActorsInMovie(movieId);
		return new ResponseEntity<List<Actor>>(actors, HttpStatus.OK);
	}	
}
