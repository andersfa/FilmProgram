package core;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MedieCollection<Integer> list = new MedieCollection<Integer>();
		int n = 10000000;
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; i++){
			list.add(i);			
		}
		long slut = System.currentTimeMillis();
		
		
		System.out.println("Time:" + (slut-start));
		
		
		
		
		
		
		
		

	}

}
