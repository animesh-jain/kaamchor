package com.dishita.kaamchor.controller;

import com.dishita.kaamchor.enums.TaskStatus;
import com.dishita.kaamchor.model.Task;
import com.dishita.kaamchor.model.UserTaskMapping;
import com.dishita.kaamchor.service.UserTaskMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserTaskMappingController {

    @Autowired
    UserTaskMappingService userTaskMappingService;

    @PostMapping("/asssignTask")
    public UserTaskMapping createAndAssignUserTask(@RequestParam Integer taskId, @RequestParam Integer userId, @RequestParam(required = false) Date dueDate) {
        return userTaskMappingService.createUserTaskMapping(taskId, userId, dueDate);
    }

    @PutMapping("/startTask")
    public UserTaskMapping startTask(@RequestParam Integer taskId, @RequestParam Integer userId) {
        return userTaskMappingService.startTask(taskId, userId);
    }

    @PutMapping("/fillForm")
    public String fillForm(@RequestParam Integer taskId, @RequestParam Integer userId) {
        return userTaskMappingService.fillForm(taskId, userId);
    }

    @PutMapping("/updateTask")
    public UserTaskMapping updateTask(@RequestParam Integer taskId, @RequestParam Integer userId, @RequestParam TaskStatus taskStatus) {
        return userTaskMappingService.updateTask(taskId, userId, taskStatus);
    }
}
