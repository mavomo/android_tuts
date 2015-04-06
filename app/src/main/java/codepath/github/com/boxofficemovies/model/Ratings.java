package codepath.github.com.boxofficemovies.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Ratings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8550399356165206648L;

	@SerializedName("critics_rating")
	private String criticsRating;
	
	@SerializedName("critics_score")
	private String criticsScore;
	
	@SerializedName("audience_rating")
	private String audianceRating;
	
	@SerializedName("audience_score")
	private int audianceScore;
	
	
	@Override
	public String toString(){
		return "{ criticsRating: " + this.criticsRating + ", criticScore: " + this.criticsScore + ", audiance_rating: " + this.audianceRating + ", audiance_score: " + this.audianceScore + "}";
	}
	
	public String getCriticsRating() {
		return criticsRating;
	}
	public void setCriticsRating(String criticsRating) {
		this.criticsRating = criticsRating;
	}
	public String getCriticsScore() {
		return criticsScore;
	}
	public void setCriticsScore(String criticsScore) {
		this.criticsScore = criticsScore;
	}
	public String getAudianceRating() {
		return audianceRating;
	}
	public void setAudianceRating(String audianceRating) {
		this.audianceRating = audianceRating;
	}
	public int getAudianceScore() {
		return audianceScore;
	}
	public void setAudianceScore(int audianceScore) {
		this.audianceScore = audianceScore;
	}
	
	

}
