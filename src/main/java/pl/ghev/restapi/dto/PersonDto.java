package pl.ghev.restapi.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PersonDto {

    private Long id;
    private String name;
    private String lastName;

}
