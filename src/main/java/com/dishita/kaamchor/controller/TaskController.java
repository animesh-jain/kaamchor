package com.dishita.kaamchor.controller;

import com.dishita.kaamchor.enums.TaskStatus;
import com.dishita.kaamchor.model.Task;
import com.dishita.kaamchor.service.TaskService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/get-all-tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/get-pending-tasks")
    public List<Task> getPendingTasks() {
        return taskService.getPendingTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Integer id) {
        return taskService.getTask(id);
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/update-status/{id}")
    public Task updateStatus(@PathVariable Integer id, @RequestParam TaskStatus status) throws BadRequestException {
        return taskService.updateStatus(id, status);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Integer userId) {
        return taskService.getTasksByUserId(userId);
    }

    @PutMapping("/assign-task/{taskId}/{userId}")
    public Task assignTask(@PathVariable Integer taskId, @PathVariable Integer userId) throws BadRequestException {
        return taskService.assignTask(taskId, userId);
    }
}