package core;

public class BD extends Medie {

private Movie m;
	
	public BD(Movie m) {
		super(TYPE.BD);
		this.m = m;
	}

	public Movie getMovie(){
		return m;
	}
	
	@Override
	public int compareTo(Medie o) {
		return m.getTitle().compareTo(o.getTitle());
	}



	public String getPlayTimeToString() {
		if(m.getTime_min() == 0)
			return "Ukendt";
		
		return m.getTime_min()+"";
	}

	@Override
	public String getTitle() {
		return m.getTitle();
	}
	
}
