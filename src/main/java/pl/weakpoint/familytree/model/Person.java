package pl.weakpoint.familytree.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Person {
	@Id
    public String id;

    public String firstName;
    public String lastName;
    public String familyLastName;
    public Date birthDate;
    public Date deathDate;
    public String familyCity;
    public String city;
    
    public List<String> parents;
    public List<String> siblings;
    
    public Person(){}
    
	public Person(String firstName, String lastName, String familyLastName, Date birthDate, Date deathDate, String familyCity, String city,
			List<String> parents, List<String> siblings) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.familyLastName = familyLastName;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
		this.familyCity = familyCity;
		this.city = city;
		this.parents = parents;
		this.siblings = siblings;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", familyLastName=" + familyLastName + ", birthDate="
				+ birthDate + ", deathDate=" + deathDate + ", familyCity=" + familyCity + ", city=" + city + ", parents=" + parents + ", siblings="
				+ siblings + "]";
	}
    
	

}


