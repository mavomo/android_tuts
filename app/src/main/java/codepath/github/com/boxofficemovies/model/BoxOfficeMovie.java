package codepath.github.com.boxofficemovies.model;


import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michelle on 14/03/2015.
 */
public class BoxOfficeMovie {

    private String title;
    private int year;
    private String synopsis;
    private String posterUrl;
    private int criticScore;
    private List<String> castList;

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

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public int getCriticScore() {
        return criticScore;
    }

    public void setCriticScore(int criticScore) {
        this.criticScore = criticScore;
    }

    public List<String> getCastList() {
       return castList;
     }

    public void setCastList(List<String> castList) {
        this.castList = castList;
    }

    @Override
    public String toString(){
        StringBuilder boxOfficeMovie = new StringBuilder();
        boxOfficeMovie.append("Title: ").append(getTitle()).append(" Year").append(getYear()).append("Synopsys: ").append(getSynopsis());
        return boxOfficeMovie.toString();
    }
}
