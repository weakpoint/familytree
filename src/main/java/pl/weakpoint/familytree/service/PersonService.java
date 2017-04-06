package pl.weakpoint.familytree.service;

import java.util.List;

import pl.weakpoint.familytree.model.PersonDTO;

public interface PersonService {
	PersonDTO create(PersonDTO person);
	PersonDTO update(PersonDTO personDTO);
	PersonDTO findById(String id);
	PersonDTO delete(String id);
	List<PersonDTO> findAll();
}
