package com.dishita.kaamchor.service;

import com.dishita.kaamchor.model.Task;
import com.dishita.kaamchor.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Integer id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUserId(Integer userId) {
        return taskRepository.getTasksByUserIdOrderByPriorityAndStatus(userId);
    }
}
