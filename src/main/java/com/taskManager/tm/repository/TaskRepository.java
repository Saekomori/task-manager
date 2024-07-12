package com.taskManager.tm.repository;

import com.taskManager.tm.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends MongoRepository<Task, UUID> {

     List<Task> findTasksByUserEmail(String userEmail);



}
