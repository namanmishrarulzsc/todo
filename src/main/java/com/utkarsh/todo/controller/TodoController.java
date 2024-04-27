package com.utkarsh.todo.controller;

import com.utkarsh.todo.dto.TaskDTO;
import com.utkarsh.todo.service.TodoService;
import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody() TaskDTO taskDTO){
        todoService.createTask(taskDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTask(){
        return ResponseEntity.ok().body(todoService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(todoService.getTaskById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateIsCompleted(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        todoService.updateTask(id,taskDTO);
        return ResponseEntity.ok().build();

    }
}
