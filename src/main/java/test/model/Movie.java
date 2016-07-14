package test.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Movie {
	@GraphId
	Long id;
	
	private String tagline;
	private String title;
	private int released;
	
	@Relationship(type="ACTED_IN", direction="INCOMING")
	private Set<Actor> actor = new HashSet<Actor>();
	
//	@Relationship(type="ACTED_IN", direction="INCOMING")
//	private List<Actor> actors;
	
	public Movie(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReleased() {
		return released;
	}
	public void setReleased(int released) {
		this.released = released;
	}
	
//	public List<Actor> getActors() {
//		return actors;
//	}
//
//	public void setActors(List<Actor> actors) {
//		this.actors = actors;
//	}
	
	
	public Set<Actor> getActor() {
		return actor;
	}

	public void setActor(Set<Actor> actor) {
		this.actor = actor;
	}

	

	@Override
	public String toString() {
		return "Movie [" + (id != null ? "id=" + id + ", " : "") + (tagline != null ? "tagline=" + tagline + ", " : "")
				+ (title != null ? "title=" + title + ", " : "") + "released=" + released + "]";
	}
	
}
