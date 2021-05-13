package pl.ghev.restapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ghev.restapi.dto.PersonDto;
import pl.ghev.restapi.dto.PersonDtoMapper;
import pl.ghev.restapi.model.Person;
import pl.ghev.restapi.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonDto> getAllPeople(){
        return PersonDtoMapper.mapToPersonDtos(personService.findAllPerson());
    }



    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") long id){

        return personService.findPersonById(id).get();
    }

    @PostMapping
    public Person  postPerson(@RequestBody Person person){

        return personService.addPerson(person);
    }

    @PutMapping
    public Person editPerson(@RequestBody Person person){
        return personService.editPerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") long id ){
        personService.deletePersonById(id);
    }





}
