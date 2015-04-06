package codepath.github.com.boxofficemovies.model;

import java.util.ArrayList;
import java.util.List;

public class BoxOffice {

	private List<Movie> movies = new ArrayList<>();
	
	@Override
	public String toString(){
		return "movies:" + this.movies + "";
	}

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
