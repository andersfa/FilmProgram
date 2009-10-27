package code;

public class BD extends Medie {

	public BD(String titel) {
		super(titel);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public int compareTo(Medie o) {
		return super.getTitel().compareTo(o.getTitel());
	}
	
}
