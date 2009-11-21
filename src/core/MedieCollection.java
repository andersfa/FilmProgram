package core;

public class MedieCollection<E>{
	
	private Node header;
	private Node tail;
	private int size;
	
	public MedieCollection(){
		this.header = new Node();
		this.tail = new Node();
		header.setNext(tail);
		tail.setPrev(header);
		size = 0;
	}
	
	private void insertBetween(Node one, Node ny, Node two){
		one.setNext(ny);
		ny.setPrev(one);
		ny.setNext(two);
		two.setPrev(ny);
	}
	
	public void add(E e){
		Node ny = new Node();
		ny.setItem(e);
		insertBetween(tail.getPrev(), ny, tail);
		size++;
	}
	
	public E get(int i){
		int temp = 0;
		Node cursor = header;
		if(i < size){
			while(temp <= i){
				cursor = cursor.getNext();
				temp++;
			}
		}
		else{
			throw new IndexOutOfBoundsException();
		}
		
		return cursor.getItem();
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size <= 0;
	}
	
	@SuppressWarnings("unchecked")
	public E[] toArray(){
		E[] temp = (E[]) new Object[size];
		for(int i = 0; i < size; i++){
			temp[i] = get(i);
		}
		return temp;
	}
	
	private class Node{
		private Node next;
		private Node prev;
		private E item;
		
		public Node(){
			
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public E getItem() {
			return item;
		}

		public void setItem(E item) {
			this.item = item;
		}
	}
}
