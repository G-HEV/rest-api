package pl.ghev.restapi.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PersonDto {

    Long id;
    String name;
    String lastName;

}
