package az.developia.spring_mvc_project.model;

public class Student {
	
	private String name;
	private String surname;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + "]";
	}
	
	
	
	

}
