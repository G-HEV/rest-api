package pl.ghev.restapi.dto;

import pl.ghev.restapi.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonDtoMapper {


    public static List<PersonDto> mapToPersonDtos(List<Person> allPerson) {
        return allPerson.stream()
                .map(person -> mapToPersonDto(person))
                .collect(Collectors.toList());
    }

    public static PersonDto mapToPersonDto(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .lastName(person.getLastName())
                .build();
    }
    private PersonDtoMapper(){

    }
}
