package core;

public abstract class Medie implements Comparable<Medie> {

	private TYPE type;
	
	public Medie(TYPE type){
		this.type = type;
	}

	public TYPE getType() {
		return type;
	}
	
	public abstract String getTitle();
	public abstract String getPlayTimeToString();
}
