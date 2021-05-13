package pl.ghev.restapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ghev.restapi.model.Person;
import pl.ghev.restapi.repo.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

     private final PersonRepository personRepository;

     @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> findPersonById(long id ){
         return personRepository.findById(id);
    }

    public List<Person> findAllPerson(){
         return personRepository.findAll();
    }

    public Person addPerson(Person person){
         return personRepository.save(person);
    }

    public void deletePersonById(long id){
         personRepository.deleteById(id);
    }
}
