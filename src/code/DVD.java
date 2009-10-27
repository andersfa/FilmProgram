package code;

public class DVD extends Medie {

	public DVD(String titel) {
		super(titel);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public int compareTo(Medie o) {
		return super.getTitel().compareTo(o.getTitel());
	}
	
}
