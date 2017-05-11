package baExample;

public class Animal {
	private String name;
	private String species;
	
	public Animal(String name, String species) {
		super();
		this.name = name;
		this.species = species;
	}
	public String getName(){
		return name;
	}
	public String getSpecies(){
		return species;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	

}
