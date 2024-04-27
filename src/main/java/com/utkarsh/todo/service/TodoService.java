package com.utkarsh.todo.service;

import com.utkarsh.todo.dto.TaskDTO;
import com.utkarsh.todo.entity.Task;
import com.utkarsh.todo.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TaskRepository taskRepository;

    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(TaskDTO taskDTO){
        Task task=new Task();
        task.setTitle(taskDTO.getTitle());
        taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }
    @Transactional
    public  void updateTask(Long id,TaskDTO taskDTO){
        Task task= getTaskById(id);
        task.setCompleted(taskDTO.getIsCompleted());
        taskRepository.save(task);
    }
}
