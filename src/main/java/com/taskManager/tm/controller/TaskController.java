package com.taskManager.tm.controller;

import com.taskManager.tm.entity.Task;
import com.taskManager.tm.jwt.JwtTokenUtil;
import com.taskManager.tm.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/tm/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;
    private final JwtTokenUtil jwtTokenUtil;

    @GetMapping("/all")
    public List<Task> getAllTaskFromDB() {
        return taskRepository.findAll();
    }

    @GetMapping("/allTasksUser")
    public List<Task> getAllTaskFromDB(@RequestHeader("Authorization") String token) {
        String userEmail = jwtTokenUtil.extractEmail(token.substring(7)); // Уберем префикс "Bearer " из токена
        return taskRepository.findTasksByUserEmail(userEmail);
    }

    @GetMapping("/getTaskId/{taskId}")
    public ResponseEntity<Task> getTaskFromDB(@PathVariable String taskId) {
        System.out.println("Получен запрос на задачу с ID: " + taskId);
        Optional<Task> task = taskRepository.findById(UUID.fromString(taskId));
        if (!task.isPresent()) {
            System.out.println("Задача с ID " + taskId + " не найдена.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println("Задача найдена: " + task.get());
        return ResponseEntity.ok(task.get());
    }


    @PostMapping("/add")
    public Task putTaskIntoDB(@RequestBody Task task, @RequestHeader("Authorization") String token) {
        String userEmail = jwtTokenUtil.extractEmail(token.substring(7));
        task.setUserEmail(userEmail);
        task.setId(UUID.randomUUID());
        return taskRepository.save(task);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable UUID taskId) {
        if (!taskRepository.existsById(taskId)) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.deleteById(taskId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable UUID taskId, @RequestBody Task updatedTask) {
        return taskRepository.findById(taskId)
                .map(existingTask -> {
                    updatedTask.setId(existingTask.getId());
                    updatedTask.setUserEmail(existingTask.getUserEmail());
                    updatedTask.setCreationDate(existingTask.getCreationDate());
                    return ResponseEntity.ok(taskRepository.save(updatedTask));
                })
                .orElse(ResponseEntity.notFound().build());
    }







}
