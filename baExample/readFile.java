package baExample;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFile {
	static ArrayList<Person>PersonList=new ArrayList<Person>();
	
	public static void main(String[] args) throws IOException{
		bufferedcopy("ExData.txt");	
		for (int i=0; i<PersonList.size(); i++)
		{
			for (int j=0; j<PersonList.get(i).getPets().size();j++){
				System.out.println(PersonList.get(i).getName()+
						" has a "+PersonList.get(i).getPets().get(j).getSpecies()
						+ " and works as a "+PersonList.get(i).getOccupation());
						}
		}
		findSalary("Cat");
		findOccupation("Dolphin");
		findSpecies("Trainer");
	}
	
	public static void bufferedcopy(String inFile) throws IOException
	{
	BufferedReader bfrIn = new BufferedReader(new FileReader(inFile));
	String line = "";
	String totalcontents = "";
	
	while ((line = bfrIn.readLine()) != null) {
		totalcontents+=line+"\n";
		
	}
	
	
	String[] personpetArray = totalcontents.split("&");///splits text in 2
	
	//System.out.println(personpetArray[0]);//prints out people information
	
	String[] petArray = personpetArray[1].split("%");
	
	String[] pet1Array = petArray[0].split("\n");
	Animal a1 = new Animal (pet1Array[1], pet1Array[2]);
	
	String[] pet2Array = petArray[1].split("\n");
	Animal a2= new Animal (pet2Array[1], pet2Array[2]);
	
	String[] pet3Array = petArray[2].split("\n");
	Animal a3= new Animal (pet3Array[1], pet3Array[2]);
	
	String[] pet4Array = petArray[3].split("\n");
	Animal a4= new Animal (pet4Array[1], pet4Array[2]);
	
	String[] pet5Array = petArray[4].split("\n");
	Animal a5= new Animal (pet5Array[1], pet5Array[2]);
	
	
	String[] personArray = personpetArray[0].split("%");
	String[] person1Array = personArray[0].split("\n");//seperates information per line
	
	person1Array[0]=person1Array[0].replaceAll("ï»¿", "");
	person1Array[3]=person1Array[3].replaceAll("Â£", "");
	//System.out.println(person1Array[0]);
	
	String StrSalary1=person1Array[3];
	
	int salary1 =Integer.parseInt(StrSalary1);
	
	//System.out.println(salary1);
	
	Person p1 = new Person (person1Array[0], person1Array[1], person1Array[2], salary1);
	PersonList.add(p1);
	//System.out.println("Person 1: \n"+p1.getName()+"\n" + p1.getDob()+"\n"+p1.getOccupation()+"\n£"+p1.getSalary());
	
	String[] person2Array = personArray[1].split("\n");
	person2Array[4]=person2Array[4].replaceAll("Â£", "");
	String StrSalary2=person2Array[4];
	int salary2 = Integer.parseInt(StrSalary2);
	
	//System.out.println(salary2);
	
	Person p2 = new Person (person2Array[1], person2Array[2], person2Array[3], salary2);
	PersonList.add(p2);
	//System.out.println("\n\nPerson 2:\n"+p2.getName()+"\n" + p2.getDob()+"\n"+p2.getOccupation()+"\n£"+p2.getSalary());
	String[] person3Array = personArray[2].split("\n");
	
	person3Array[4]=person3Array[4].replaceAll("Â£", "");
	
	String StrSalary3=person3Array[4].toString();
	int salary3 =Integer.parseInt(StrSalary3);
	
	//System.out.println(salary3);
	
	Person p3 = new Person (person3Array[1], person3Array[2], person3Array[3], salary3);
	PersonList.add(p3);
	//System.out.println("\n\nPerson 3:\n"+p3.getName()+"\n" + p3.getDob()+"\n"+p3.getOccupation()+"\n£"+p3.getSalary());
	
	//System.out.println(person1Array[1]);
	
	assignPet(p1,a2);
	assignPet(p1,a4);
	assignPet(p3,a2);
	assignPet(p3,a3);

	
		
	bfrIn.close();

	}
	
	public static void assignPet(Person p, Animal a)
	{
		p.ownPet(a);
	}
	
	public static void findSalary(String salspecies) {
		ArrayList<Integer> SalaryArray = new ArrayList<Integer>();
		for (int i = 0; i < PersonList.size(); i++) {

			
			for (int j = 0; j < PersonList.get(i).getPets().size(); j++) {

				if (PersonList.get(i).getPets().get(j).getSpecies().equals(salspecies)) {
					SalaryArray.add(PersonList.get(i).getSalary());
					//System.out.println(PersonList.get(i).getPets().get(j).getSpecies());
					// System.out.println("People who own a "+salspecies+ " can
					// earn £"+PersonList.get(i).getSalary());
				}
			
				// System.out.println(result);
			}
		}
			int result = 0;
			for (int k = 0; k < SalaryArray.size(); k++) {
				if (SalaryArray.size()>1){
				System.out.println(SalaryArray.get(k));
				result = SalaryArray.get(k+1)+SalaryArray.get(k);
				k=k+1;}
				else{result=SalaryArray.get(k);}
		}
			float average = result/SalaryArray.size();
			System.out.println("The average salary of someone who owns a "+salspecies+" is £"+average);
	}
	public static void findOccupation(String occupspecies){
		
		for(int i=0;i<PersonList.size();i++){
			
			for (int j=0; j < PersonList.get(i).getPets().size();j++){
			
				if(PersonList.get(i).getPets().get(j).getSpecies().equals(occupspecies)){
				
					System.out.println("People who own a "+occupspecies+" can work as a "+PersonList.get(i).getOccupation());
					
				}	
			}
		}
	}
	public static void findSpecies(String specoccupation){
		
		for(int i=0;i<PersonList.size();i++){
			if (PersonList.get(i).getOccupation().equals(specoccupation)){
				for (int j=0; j<PersonList.get(i).getPets().size(); j++){
				
					System.out.println("People who work as a "+specoccupation+" can own a "+PersonList.get(i).getPets().get(j).getSpecies());
				}
			}	
		}
	}
}



	


