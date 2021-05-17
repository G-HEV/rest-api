package pl.ghev.restapi.dto;



import pl.ghev.restapi.model.Project;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectDtoMapper {

    public static List<ProjectDto> mapProjectListToDto(List<Project> projects){
       return    projects.stream()
                .map(x -> mapToProjectDto(x))
                .collect(Collectors.toList());

    }

    public static ProjectDto mapToProjectDto(Project x) {
        return ProjectDto.builder()
                .id(x.getIdProject())
                .isDone(x.getIsDone())
                .manager(x.getManager())
                .name(x.getName())
                .created(x.getCreated())
                .build();

    }

    private ProjectDtoMapper() {
    }
}
