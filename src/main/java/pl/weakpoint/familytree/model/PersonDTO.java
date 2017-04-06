package pl.weakpoint.familytree.model;

import java.util.Date;
import java.util.List;

public class PersonDTO {
	public String id;
	public String firstName;
	public String lastName;
	public String familyLastName;
	public Date birthDate;
	public Date deathDate;
	public String familyCity;
	public String city;

	public List<Person> parents;
	public List<Person> siblings;
	public List<Person> childen;
}
