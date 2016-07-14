package test.web.rest;

import java.util.ArrayList;
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

import test.model.Movie;
import test.repository.MovieRepository;

@RestController
@RequestMapping("/api")
public class MovieResource {
	
	private static final Logger log = LoggerFactory.getLogger(MovieResource.class);
	
	@Autowired
	MovieRepository movieRepository;
	
	@RequestMapping(value="/movie", method=RequestMethod.POST)
	public void saveMovie(@RequestBody Movie movie){
		log.info("REQUEST: " + movie);
		movieRepository.save(movie);
		log.info("|SAVED|" + movie);
	}
	
	@RequestMapping(value="/movie", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Movie>> getMovies(){
		Iterable<Movie> movies = movieRepository.findAll();
		return new ResponseEntity<Iterable<Movie>>(movies,HttpStatus.OK);
	}
	
	@RequestMapping(value="/movie/{id}", method=RequestMethod.DELETE)
	public void deleteMovie(@PathVariable("id") Long id){
		Movie movie = movieRepository.findOne(id);
		String movieTitle = movie.getTitle();
		movieRepository.delete(movie);
		log.info("|DELETED| " + movieTitle);
	}

}
