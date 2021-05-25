package pl.ghev.restapi.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import pl.ghev.restapi.dto.ProjectDto;
import pl.ghev.restapi.dto.ProjectDtoMapper;
import pl.ghev.restapi.model.Project;
import pl.ghev.restapi.model.Task;
import pl.ghev.restapi.service.ProjectService;
import pl.ghev.restapi.service.TaskService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/projects")
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
    @GetMapping("/{id}/tasks")
    public List<Task> getAllTask(@PathVariable("id") long id){
        return projectService.findProjectById(id).getTaskList().
                stream().collect(Collectors.toList());
    }

    @GetMapping("/{id}/tasks/{task_id}")
    public Task getSingleTaskFromProject(@PathVariable("id") long id, @PathVariable("task_id") long task_id){

        return projectService.findProjectById(id).getTaskList().stream()
                .filter(x -> x.getIdTask() == task_id).findAny().orElseThrow();
    }

    @PostMapping("/{id}/tasks")
    public Task postTask(@PathVariable("id") long id, @RequestBody Task task){
        task.setProject(projectService.findProjectById(id));
        return taskService.addTask(task);
    }

    @PutMapping("/{id}/tasks")
    public Task editTask(@PathVariable("id") long id,@RequestBody Task task){
        task.setProject(projectService.findProjectById(id));
        return taskService.editTask(task);
    }

    @DeleteMapping("/{project_id}/tasks/{id}")
    public void deleteTaskById(@PathVariable("project_id") long project_id,@PathVariable("id") long id){
        Task task = projectService.findProjectById(project_id).getTaskList().stream().filter(x -> x.getIdTask() == id).findAny().orElseThrow();
        taskService.deleteTaskById(task);
    }


}
