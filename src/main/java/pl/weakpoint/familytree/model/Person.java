package pl.weakpoint.familytree.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;

public class Person {
	@Id
    private String id;

    private String firstName;
    private String lastName;
    private String familyLastName;
    private Date birthDate;
    private Date deathDate;
    private String familyCity;
    private String city;
    
    private List<String> parents;
    private List<String> siblings;
    private List<String> childen;
    
    public Person(){}
    
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFamilyLastName() {
		return familyLastName;
	}


	public void setFamilyLastName(String familyLastName) {
		this.familyLastName = familyLastName;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Date getDeathDate() {
		return deathDate;
	}


	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}


	public String getFamilyCity() {
		return familyCity;
	}


	public void setFamilyCity(String familyCity) {
		this.familyCity = familyCity;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public List<String> getParents() {
		return parents;
	}

	
	public void setParents(List<Person> parents) {
		this.parents = parents.stream().map(person -> person.id).collect(Collectors.toList());
	}


	public List<String> getSiblings() {
		return siblings;
	}


	public void setSiblings(List<Person> siblings) {
		this.siblings = siblings.stream().map(person -> person.id).collect(Collectors.toList());
	}


	public List<String> getChilden() {
		return childen;
	}


	public void setChilden(List<Person> childen) {
		this.childen = childen.stream().map(person -> person.id).collect(Collectors.toList());
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", familyLastName=" + familyLastName + ", birthDate="
				+ birthDate + ", deathDate=" + deathDate + ", familyCity=" + familyCity + ", city=" + city + ", parents=" + parents + ", siblings="
				+ siblings + "]";
	}
    
	

}


