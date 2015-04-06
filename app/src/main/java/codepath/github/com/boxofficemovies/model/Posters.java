package codepath.github.com.boxofficemovies.model;

public class Posters {

	private String thumbnail;
	private String profile;
	private String detailed;
	private String original;
	
	public String toString(){
		return "Posters : {thumbmail:"+ this.thumbnail +", profile:"+ this.profile + ", detailed: "+this.detailed +", original: "+ this.original +"}";
	}
	
	public String getThumbmail() {
		return thumbnail;
	}
	public void setThumbmail(String thumbmail) {
		this.thumbnail = thumbmail;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDetailed() {
		return detailed;
	}
	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	
	
	
}
