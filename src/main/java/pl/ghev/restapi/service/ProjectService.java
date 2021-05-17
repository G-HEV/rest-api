package pl.ghev.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ghev.restapi.model.Project;
import pl.ghev.restapi.repo.ProjectRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAddProjects(){
        return projectRepository.findAll();
    }
    public Project findProjectById(long id){
        return projectRepository.findById(id).orElseThrow();
    }

    public Project addProject(Project project){

        return projectRepository.save(project);
    }

    @Transactional
    public Project editProject(Project project){
        Project editedProject = projectRepository.findById(project.getIdProject()).get();
        editedProject.setIsDone(project.getIsDone());
        editedProject.setManager(project.getManager());
        editedProject.setName(project.getName());
        editedProject.setPersonList(project.getPersonList());
        editedProject.setTaskList(project.getTaskList());
        projectRepository.save(editedProject);
        return editedProject;
    }

    public void deleteProjectById(long id){
         projectRepository.deleteById(id);
    }

}
