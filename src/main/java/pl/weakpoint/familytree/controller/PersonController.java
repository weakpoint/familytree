package pl.weakpoint.familytree.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.weakpoint.familytree.model.PersonDTO;
import pl.weakpoint.familytree.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	private final PersonService service;
	 
    @Autowired
    PersonController(PersonService service) {
        this.service = service;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    PersonDTO create(@RequestBody @Valid PersonDTO person) {
        return service.create(person);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    PersonDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<PersonDTO> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    PersonDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    PersonDTO update(@RequestBody @Valid PersonDTO person) {
        return service.update(person);
    }
 
  /*  @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(TodoNotFoundException ex) {
    }*/
}
