package com.dishita.kaamchor.repository;

import com.dishita.kaamchor.model.UserTaskMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskMappingRepository extends JpaRepository<UserTaskMapping, Integer> {
    public UserTaskMapping findByUserIdAndTaskId(Integer userId, Integer taskId);
}
