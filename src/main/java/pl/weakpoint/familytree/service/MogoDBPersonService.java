package pl.weakpoint.familytree.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.weakpoint.familytree.model.Person;
import pl.weakpoint.familytree.model.PersonDTO;
import pl.weakpoint.familytree.repository.PersonRepository;

@Service
public final class MogoDBPersonService implements PersonService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MogoDBPersonService.class);
	
	private final PersonRepository repository;
	
	@Autowired
	public MogoDBPersonService(PersonRepository repository){
		this.repository = repository;
	}
	
	@Override
	public PersonDTO create(PersonDTO person){
		Person persisted = convertPersonDTOToPerson(person);
		repository.save(persisted);
		return convertPersonToPersonDTO(persisted);
	}
	
	@Override
	public PersonDTO update(PersonDTO personDTO){
		Person person = repository.findById(personDTO.id);
		person = updatePerson(person, personDTO);
		person = repository.save(person);
		return convertPersonToPersonDTO(person);
	}
	
	@Override
	public PersonDTO findById(String id){
		Person person = repository.findById(id);
		return convertPersonToPersonDTO(person);
	}
	
	@Override
	public PersonDTO delete(String id) {
		Person person = repository.findById(id);
		repository.delete(person);
		
		return convertPersonToPersonDTO(person);
	}

	@Override
	public List<PersonDTO> findAll() {
		List<Person> findAll = repository.findAll();

		return findAll.stream().map(person -> this.convertPersonToPersonDTO(person)).collect(Collectors.toList());
	}

	private Person updatePerson(Person person, PersonDTO personDTO) {
		person.setId(personDTO.id);
		person.setFirstName(personDTO.firstName);
		person.setLastName(personDTO.lastName);
		person.setBirthDate(personDTO.birthDate);
		person.setCity(personDTO.city);
		person.setDeathDate(personDTO.deathDate);
		person.setFamilyCity(personDTO.familyCity);
		person.setFamilyLastName(personDTO.familyLastName);
		person.setParents(personDTO.parents);
		person.setSiblings(personDTO.siblings);
		person.setChilden(personDTO.childen);
		return person;
	}
	
	private Person convertPersonDTOToPerson(PersonDTO personDTO) {
		Person person = new Person();
		person.setId(personDTO.id);
		person.setFirstName(personDTO.firstName);
		person.setLastName(personDTO.lastName);
		person.setBirthDate(personDTO.birthDate);
		person.setCity(personDTO.city);
		person.setDeathDate(personDTO.deathDate);
		person.setFamilyCity(personDTO.familyCity);
		person.setFamilyLastName(personDTO.familyLastName);
		person.setParents(personDTO.parents);
		person.setSiblings(personDTO.siblings);
		person.setChilden(personDTO.childen);
		return person;
	}


	private PersonDTO convertPersonToPersonDTO(Person persisted) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.id = persisted.getId();
		personDTO.firstName = persisted.getFirstName();
		personDTO.lastName = persisted.getLastName();
		personDTO.birthDate = persisted.getBirthDate();
		personDTO.city = persisted.getCity();
		personDTO.deathDate = persisted.getDeathDate();
		personDTO.familyCity = persisted.getFamilyCity();
		personDTO.familyLastName = persisted.getFamilyLastName();
		personDTO.parents = repository.findAllById(persisted.getParents());
		personDTO.siblings = repository.findAllById(persisted.getSiblings());
		personDTO.childen = repository.findAllById(persisted.getChilden());
		return personDTO;
	}
	
}
