package code;

public abstract class Medie implements Comparable<Medie> {

	private String titel;
	
	public Medie(String titel){
		this.titel = titel;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}
	
}
