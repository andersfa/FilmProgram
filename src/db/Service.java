package db;

import core.BD;
import core.DVD;
import core.Medie;
import core.MedieCollection;
import core.Movie;
import core.VHS;


public class Service {

	private MedieCollection<Medie> list;
	private static Service service;
	
	private Service(){
		this.list = new MedieCollection<Medie>();
		DVD d = new DVD(new Movie("Star Wars Episode 3: Revenge of the Sith"));
		d.getMovie().setTime_min(86);
		list.add(d);
		list.add(new BD(new Movie("Transformers 2: Revenge of the Fallen")));
		list.add(new VHS("Jul i Gammelby", 240));
		list.add(new DVD(new Movie("Anders And")));
		list.add(new BD(new Movie("Star Trek")));
		list.add(new DVD(new Movie("Star Wars Episode 2: The Clone War")));
		list.add(new BD(new Movie("Funnypeople")));
		list.add(new VHS("Judge Dredd", 240));
		list.add(new DVD(new Movie("The Lion King")));
		list.add(new BD(new Movie("Stargate")));
		list.add(new DVD(new Movie("Independance Day")));
		list.add(new BD(new Movie("Avatar")));
		list.add(new VHS("Titan A.E.", 240));
		list.add(new DVD(new Movie("Batman")));
		list.add(new BD(new Movie("Op på fars hat")));
		list.add(new DVD(new Movie("Friends: Season 1")));
		list.add(new VHS("Indiana Jones", 240));
		list.add(new VHS("Bånd nr. 82", 480));
		list.add(new DVD(new Movie("Jennifers Body")));
		list.add(new DVD(new Movie("Terminator 2")));
		list.add(new DVD(new Movie("Twins")));
	}
	
	public static synchronized Service getInstance(){
		if(service == null)
			service = new Service();
		return service; 
	}
	
	public MedieCollection<Medie> getList(){
		return list;
	}
	
	public MedieCollection<Medie> searchMovies(String text){
		MedieCollection<Medie> temp = new MedieCollection<Medie>();
		for(int i = 0; i < list.size(); i++){
			String titel = list.get(i).getTitle().toLowerCase();
			boolean match = false;
			for(int j = 0; j < titel.length()-text.length(); j++){
				if(titel.subSequence(j, j+text.length()).equals(text.toLowerCase()))
					match = true;
			}
			if (match)
				temp.add(list.get(i));
		}
		return temp;
	}
	
}
