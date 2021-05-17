package pl.ghev.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.ghev.restapi.dto.ProjectDto;
import pl.ghev.restapi.dto.ProjectDtoMapper;
import pl.ghev.restapi.model.Project;
import pl.ghev.restapi.service.ProjectService;
import pl.ghev.restapi.service.TaskService;


import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    private final ProjectService projectService;
    private final TaskService taskService;

    @Autowired
    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @GetMapping
    public List<ProjectDto> getAllProject(){
        return ProjectDtoMapper.mapProjectListToDto(
                projectService.findAddProjects());
    }

    @GetMapping("/{id}")
    public Project getSingleProjectById(@PathVariable("id") long id){
        return projectService.findProjectById(id);
    }

    @PostMapping
    public Project postProject(@RequestBody Project project){
        return projectService.addProject(project);
    }

    @PutMapping
    public Project editProject(@RequestBody Project project){
        return projectService.editProject(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable("id") Long id){
        projectService.deleteProjectById(id);
    }

    /*
    TASK manager
     */
// TODO: 17.05.2021 Create endpoints for tasks


}
