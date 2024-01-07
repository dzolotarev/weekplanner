package com.example.weekplanner.controller;

import com.example.weekplanner.model.Task;
import com.example.weekplanner.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAll() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Optional<Task> getById(@PathVariable Long id) {
        return taskRepository.findById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable Long id,
                       @RequestBody Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable Long id,
                            @RequestBody Task task) {
        if (task.isDone()) {
            taskRepository.markIsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchMethod(@PathVariable Long id) {
        taskRepository.markIsDone(id);
    }
}
