package codepath.github.com.boxofficemovies.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilitary class used for parsing remote jsonObject into our @BoxOfficeMovie POJO
 *
 * Created by Michelle on 14/03/2015.
 */
public class BoxOfficeMovieFactory {

    /**
     * Returns a new BoxOfficeMovie given the expected JSON
     *
     * @param jsonObject : remote object retrieved from server
     * @return an instance of @BoxOfficeMovie
     */
    public static BoxOfficeMovie fromJson(JSONObject jsonObject){
        BoxOfficeMovie boxOfficeMovie = new BoxOfficeMovie();
        try{
            boxOfficeMovie.setTitle(jsonObject.getString("title"));
            boxOfficeMovie.setYear(jsonObject.getInt("year"));
            boxOfficeMovie.setSynopsis(jsonObject.getString("synopsis"));
            boxOfficeMovie.setPosterUrl(jsonObject.getJSONObject("posters").getString("thumbnail"));
            boxOfficeMovie.setCriticScore(jsonObject.getJSONObject("ratings").getInt("critics_score"));
            //Simple array of cast name
            boxOfficeMovie.setCastList(new ArrayList<String>());
            JSONArray abrigdedCast = jsonObject.getJSONArray("abridged_cast");
            for (int i = 0; i < abrigdedCast.length(); i++) {
                boxOfficeMovie.getCastList().add(abrigdedCast.getJSONObject(i).getString("name"));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return boxOfficeMovie;
    }

    /**
     *
     * @param jsonArray : remote JsonArray retrieved from the server
     * @return
     */
    public static List<BoxOfficeMovie> fromJson(JSONArray jsonArray){
        List<BoxOfficeMovie> boxOfficeMovies = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject movieJsonObject = null;
            try {
                movieJsonObject = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            BoxOfficeMovie movie = fromJson(movieJsonObject);
            if (movie != null) {
                boxOfficeMovies.add(movie);
            }
        }

        return boxOfficeMovies;
    }

}
