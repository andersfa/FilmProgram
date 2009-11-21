package core;

public class Movie {

	private String title;
	private String description;
	private int time_min;
	
	public Movie(String title){
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTime_min() {
		return time_min;
	}

	public void setTime_min(int timeMin) {
		time_min = timeMin;
	}
	
	public String toString(){
		return title;
	}
	
}
