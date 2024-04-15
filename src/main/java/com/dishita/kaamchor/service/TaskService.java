package com.dishita.kaamchor.service;

import com.dishita.kaamchor.enums.TaskStatus;
import com.dishita.kaamchor.model.Task;
import com.dishita.kaamchor.model.UserTaskMapping;
import com.dishita.kaamchor.repository.TaskRepository;
import com.dishita.kaamchor.repository.UserTaskMappingRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserTaskMappingRepository userTaskMappingRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getPendingTasks() {
        return taskRepository.getAllByStatusAndIsActive(TaskStatus.PENDING, true);
    }

    public Task getTask(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        task.setStatus(TaskStatus.PENDING);
        task.setIsActive(true);
        return taskRepository.save(task);
    }

    public Task updateStatus(Integer id, TaskStatus status) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus(status);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUserId(Integer userId) {
        return taskRepository.getTasksByUserIdOrderByPriorityAndStatus(userId);
    }

    public Task assignTask(Integer taskId, Integer userId) throws BadRequestException {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task == null) {
            throw new BadRequestException("Task not found");
        }
        task.setUserId(userId);
        task.setStatus(TaskStatus.ASSIGNED);
        taskRepository.save(task);
        return task;
    }
}
