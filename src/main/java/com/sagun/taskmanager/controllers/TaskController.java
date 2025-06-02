package com.sagun.taskmanager.controllers;

import com.sagun.taskmanager.models.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1L, "Build a REST API", false));
        tasks.add(new Task(2L, "Push to GitHub", false));
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    @PostMapping
    public Task createTask(@RequestBody Task newTask) {
        // Auto-increment the ID
        long newId = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        newTask.setId(newId);
        tasks.add(newTask);
        return newTask;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setTitle(updatedTask.getTitle());
                task.setCompleted(updatedTask.isCompleted());
                return task;
            }
        }
        throw new RuntimeException("Task not found with id: " + id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId().equals(id)) {
                iterator.remove();
                return "Task deleted successfully.";
            }
        }
        throw new RuntimeException("Task not found with id: " + id);
    }
}
