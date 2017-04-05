package pl.weakpoint.familytree.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import pl.weakpoint.familytree.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	
    void delete(Person deleted);
    Person save(Person saved);
    
    List<Person> findAll();
    Person findByFirstNameAndLastName(String firstName, String lastName);
    Person findById(String id);
}
