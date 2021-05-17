package pl.ghev.restapi.dto;


import lombok.Builder;
import lombok.Getter;
import pl.ghev.restapi.model.Person;

import java.time.LocalDate;

@Getter
@Builder
public class ProjectDto {

    private Long id;
    private String name;
    private boolean isDone;
    private LocalDate created;
    private Person manager;



}
