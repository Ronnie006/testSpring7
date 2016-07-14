package test.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label="Actor")
public class Actor {
	@GraphId
	Long id;
	
	private String firstName;
	private String lastName;
	
//	@Relationship(type="ACTED_IN", direction="OUTGOING")
//	private Set<Movie> movies = new HashSet<Movie>();
	
//	@Relationship(type="ACTED_IN")
//	private List<Movie> movies;

	
	public Actor(){}
//	
//	public Set<Movie> getMovies() {
//		return movies;
//	}
//	public void setMovies(Set<Movie> movies) {
//		this.movies = movies;
//	}

	
	
//	public List<Movie> getMovies() {
//		return movies;
//	}
//	public void setMovies(List<Movie> movies) {
//		this.movies = movies;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Actor [" + (id != null ? "id=" + id + ", " : "")
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName : "") + "]";
	}
	
	
	
}
