package core;

public class VHS extends Medie {

	private String titel;
	private int length;
	private int size;
	private Movie[] entries;
	
	public VHS(String titel, int length){
		super(TYPE.VHS);
		this.titel = titel;
		this.length = length;
		this.size = 0;
		this.entries = new Movie[4];
	}
	
	/**
	 * Tilføj til VHS båndet.
	 * @param titel
	 * @param tid_i_min
	 */
	public void add(String titel, int tid_i_min){
		Movie ny = new Movie(titel);
		ny.setTime_min(tid_i_min);
		if(size == entries.length){
			Movie[] newarray = new Movie[entries.length+4];
			for(int i = 0; i < size; i++){
				newarray[i] = entries[i];
			}
			entries = newarray;
		}
		entries[size] = ny;
		size++;
	}
	
	@Override
	public String getTitle() {
		return titel;
	}
	
	public Movie get(int index){
		if(index >= size){
			throw new IndexOutOfBoundsException("Tried to get index: " + index + ", Size: "+ size);
		}
		return entries[index];
	}
	
	public Movie remove(int index){
		if(index >= size){
			throw new IndexOutOfBoundsException("Tried to get index: " + index + ", Size: "+ size);
		}
		Movie t = entries[index];
		for(int i = index; i < size; i++){
			entries[i] = entries[i+1];
		}
		size--;
		return t;
	}
	
	public Movie remove(Movie e){
		int index = 0;
		boolean found = false;
		for(int j = 0; j < size; j++){
			if(entries[j].equals(e)){
				index = j;
				found = true;
				break;
			}
		}
		if(found){
			Movie t = entries[index];
			for(int i = index; i < size; i++){
				entries[i] = entries[i+1];
			}
			size--;
			return t;
		}
		else{
			throw new RuntimeException("Not found");
		}
	}
	
	public int size(){
		return size;
	}
	
	@Override
	public String getPlayTimeToString() {
		//if(getPlaytime() == 0)
			return "Ukendt";
		//return getPlaytime()+"";
	}
	
	
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public int compareTo(Medie o) {
		return getTitle().compareTo(o.getTitle());
	}
}
