package pl.ghev.restapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ghev.restapi.model.Task;
import pl.ghev.restapi.repo.TaskRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService {


    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
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
    public void deleteTaskById(long id){
        taskRepository.deleteById(id);
    }


}
