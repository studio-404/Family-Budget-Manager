package mainPackage;

public class FamilyMembers {
	
	private String name;
	private String surname;
	private String number;
	
	public FamilyMembers(){
		this.name = "";
		this.surname = "";
		this.number = "No";
		
		
	}
	
	public FamilyMembers(String name, String surname, String number){
		this.name = name;
		this.surname = surname;
		this.number = number;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}
	
	public String getNumber(){
		return number;
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
}
