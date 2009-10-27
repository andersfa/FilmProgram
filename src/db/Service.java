package db;

import java.util.Set;
import java.util.TreeSet;

import code.BD;
import code.DVD;
import code.Medie;
import code.VHS;

public class Service {

	private Set<Medie> list;
	private static Service service;
	
	private Service(){
		this.list = new TreeSet<Medie>();
		//Medie[] m = {new DVD("Digital video disc"), new DVD("Digital video disc"), new BD("Blue ray disc"), new VHS2("VHS", 240)};
		list.add(new DVD("Star Wars Episode 3: Revenge of the Sith"));
		list.add(new BD("Transformers 2: Revenge of the Fallen"));
		list.add(new VHS("Jul i Gammelby", 240));
		list.add(new DVD("Anders And"));
		list.add(new BD("Star Trek"));
		list.add(new DVD("Star Wars Episode 2: The Clone War"));
		list.add(new BD("Funnypeople"));
		list.add(new VHS("Judge Dredd", 240));
		list.add(new DVD("The Lion King"));
		list.add(new BD("Stargate"));
		list.add(new DVD("Independance Day"));
		list.add(new BD("Avatar"));
		list.add(new VHS("Titan A.E.", 240));
		list.add(new DVD("Batman"));
		list.add(new BD("Op på fars hat"));
		
	}
	
	public static synchronized Service getInstance(){
		if(service == null)
			service = new Service();
		return service; 
	}
	
	public Set<Medie> getList(){
		return list;
	}
	
}
