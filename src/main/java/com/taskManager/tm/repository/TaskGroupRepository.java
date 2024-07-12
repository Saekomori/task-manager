package com.taskManager.tm.repository;

import com.taskManager.tm.entity.Task;
import com.taskManager.tm.entity.TaskGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskGroupRepository extends MongoRepository<TaskGroup, UUID> {
    TaskGroup findTasksGroupById(UUID id);
    List<TaskGroup> findByGroupId(String groupId);

}
