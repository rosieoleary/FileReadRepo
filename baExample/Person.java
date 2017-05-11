package baExample;

import java.util.ArrayList;

public class Person {	
	private String name;
	private String dob;
	private String occupation;
	private int salary;
	private ArrayList<Animal> pets = new ArrayList<Animal>();

	
	public Person(String name, String dob, String occupation, int salary) {
		super();
		this.name = name;
		this.dob = dob;
		this.occupation = occupation;
		this.salary = salary;
	//	this.pets= pets;
		
	}
	
		
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public ArrayList<Animal> getPets() {
		return pets;
	}

	
	public void ownPet(Animal a)
	{
		pets.add(a);
	}
	}
