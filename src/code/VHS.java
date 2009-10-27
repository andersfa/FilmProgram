package code;

public class VHS extends Medie {

	private Entry header;
	private int length;
	private int size;
	
	public VHS(String titel, int length){
		super(titel);
		header = new Entry();
		this.length = length;
		this.size = -1;
	}
	
	public void add(Entry e){
		
	}
	
	public Entry get(int index){
		return null;
	}
	
	public int size(){
		return size;
	}
	
	
	
	
	
	
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public int compareTo(Medie o) {
		return super.getTitel().compareTo(o.getTitel());
	}

	private class Entry {
		
		private Entry next;
		private String titel;
		private int length_in_min;
		
		public String getTitel() {
			return titel;
		}

		public void setTitel(String titel) {
			this.titel = titel;
		}

		public int getLength_in_min() {
			return length_in_min;
		}

		public void setLength_in_min(int lengthInMin) {
			length_in_min = lengthInMin;
		}

		public Entry(){
			next = null;
		}
		
		public void setNext(Entry e){
			this.next = e;
		}
		
		public Entry getNext(){
			return next;
		}
	}
}
