package codepath.github.com.boxofficemovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie {

	private String id;
	private String title;
	private int year;
	private String synopsis;
	
	private ReleaseDate releaseDate;
	private Ratings ratings;
	
	private Posters posters;

    @SerializedName("abridged_cast")
	private List<AbrigedCast> casting = new ArrayList<>();

	@Override
	public String toString(){
		return "{id: " + this.id + ", title:" + this.title + ", year: " + this.year + ", synopsys: " + this.synopsis + "}";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public ReleaseDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(ReleaseDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Ratings getRatings() {
		return ratings;
	}

	public void setRatings(Ratings ratings) {
		this.ratings = ratings;
	}

	public Posters getPosters() {
		return posters;
	}

	public void setPosters(Posters posters) {
		this.posters = posters;
	}

	public List<AbrigedCast> getCasting() {
		return casting;
	}

	public void setCasting(List<AbrigedCast> casting) {
		this.casting = casting;
	}
	
		
	
}
