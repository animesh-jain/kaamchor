package com.dishita.kaamchor.service;

import com.dishita.kaamchor.enums.TaskStatus;
import com.dishita.kaamchor.model.Task;
import com.dishita.kaamchor.model.User;
import com.dishita.kaamchor.model.UserTaskMapping;
import com.dishita.kaamchor.repository.TaskRepository;
import com.dishita.kaamchor.repository.UserRepository;
import com.dishita.kaamchor.repository.UserTaskMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserTaskMappingService {

    @Autowired
    private UserTaskMappingRepository userTaskMappingRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public UserTaskMapping startTask(Integer taskId, Integer userId) {
        UserTaskMapping userTaskMapping = userTaskMappingRepository.findByUserIdAndTaskId(userId, taskId);
        userTaskMapping.setStatus(TaskStatus.IN_PROGRESS);
        return userTaskMappingRepository.save(userTaskMapping);
    }

    public UserTaskMapping createUserTaskMapping(Integer taskId, Integer userId, Date dueDate) {
        Task task = taskRepository.findById(taskId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        UserTaskMapping userTaskMapping = UserTaskMapping.builder()
                .task(task) //TODO : Do we need to save this
                .user(user) //TODO : Do we need to save this
                .taskId(taskId)
                .userId(userId)
                .dueDate(dueDate)
                .isActive(true) //TODO: set priority?
                .userId(userId).build();
        return userTaskMappingRepository.save(userTaskMapping);
    }

    public String fillForm(Integer taskId, Integer userId) {
        UserTaskMapping userTaskMapping = userTaskMappingRepository.findByUserIdAndTaskId(userId, taskId);
        userTaskMapping.setStatus(TaskStatus.FORM_PENDING);
        userTaskMappingRepository.save(userTaskMapping);
        return userTaskMapping.getTask().getFormLink();
    }

    public UserTaskMapping updateTask(Integer taskId, Integer userId, TaskStatus taskStatus) {
        UserTaskMapping userTaskMapping = userTaskMappingRepository.findByUserIdAndTaskId(userId, taskId);
        userTaskMapping.setStatus(taskStatus);
        return userTaskMappingRepository.save(userTaskMapping);
    }
}
