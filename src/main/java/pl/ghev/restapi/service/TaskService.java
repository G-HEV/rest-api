package pl.ghev.restapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ghev.restapi.model.Task;
import pl.ghev.restapi.repo.PersonRepository;
import pl.ghev.restapi.repo.TaskRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService {


    TaskRepository taskRepository;
    PersonRepository personRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, PersonRepository personRepository) {
        this.taskRepository = taskRepository;
        this.personRepository = personRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Task  getTaskById(long id){
        return taskRepository.findById(id).orElseThrow();
    }

    public Task addTask(Task task){

        return taskRepository.save(task);
    }

    @Transactional
    public Task editTask(Task task){
        Task editTask = taskRepository.findById(task.getIdTask()).get();
        editTask.setContent(task.getContent());
        editTask.setCreated(task.getCreated());
        editTask.setProject(task.getProject());
        editTask.setIdTask(task.getIdTask());
        editTask.setIsDone(task.getIsDone());
        taskRepository.save(editTask);
        return editTask;
    }

    public void deleteTaskById(Task task){
        taskRepository.delete(task);
    }


}
