package taskmanager.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taskmanager.project.requestmodules.AddTaskRequest;
import taskmanager.project.entity.Task;
import taskmanager.project.repository.TaskRepository;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveTask(String task){
        Task newTask = new Task();
        newTask.setTask(task);
        taskRepository.save(newTask);
    }

    public void deleteTaskById(Long taskId){
        taskRepository.deleteById(taskId);
    }

    public void postTask(AddTaskRequest addTaskRequest){
        Task task = new Task();
        task.setTask(addTaskRequest.getTask());
        taskRepository.save(task);
    }
}
