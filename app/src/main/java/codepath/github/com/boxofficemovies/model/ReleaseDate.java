package codepath.github.com.boxofficemovies.model;

public class ReleaseDate {

	private String theater;

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}
	
	@Override
	public String toString(){
		return "release_date: {theater: " + this.theater + "}";
	}
	
}
