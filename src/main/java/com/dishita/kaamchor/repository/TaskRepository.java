package com.dishita.kaamchor.repository;

import com.dishita.kaamchor.enums.TaskStatus;
import com.dishita.kaamchor.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t " +
            "WHERE t.userId = ?1 " +
            "ORDER BY t.priority, CASE t.status " +
            "         WHEN 'CLIENT_REVIEW_ACCEPTED' THEN 1 " +
            "         WHEN 'CLIENT_REVIEW_REJECTED' THEN 2 " +
            "         WHEN 'IN_CLIENT_REVIEW' THEN 3 " +
            "         WHEN 'REVIEW_ACCEPTED' THEN 4 " +
            "         WHEN 'REVIEW_REJECTED' THEN 5 " +
            "         WHEN 'IN_REVIEW' THEN 6 " +
            "         WHEN 'FORM_SUBMITTED' THEN 7 " +
            "         WHEN 'FORM_PENDING' THEN 8 " +
            "         WHEN 'IN_PROGRESS' THEN 9 " +
            "         WHEN 'PENDING' THEN 10 " +
            "         WHEN 'COMPLETED' THEN 11 " +
            "         WHEN 'UPCOMING' THEN 12 " +
            "         END")
    List<Task> getTasksByUserIdOrderByPriorityAndStatus(Integer userId);

    List<Task> getAllByStatusAndIsActive(TaskStatus taskStatus, boolean isActive);
}
