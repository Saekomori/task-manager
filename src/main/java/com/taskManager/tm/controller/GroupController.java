package com.taskManager.tm.controller;

import com.taskManager.tm.entity.Group;
import com.taskManager.tm.entity.TaskGroup;
import com.taskManager.tm.jwt.JwtTokenUtil;
import com.taskManager.tm.repository.GroupRepository;
import com.taskManager.tm.repository.TaskGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/tm/group")
@RequiredArgsConstructor
public class GroupController {

    private final TaskGroupRepository taskGroupRepository;
    private final GroupRepository groupRepository;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/add")
    public Group putTaskIntoDB(@RequestBody Group group, @RequestHeader("Authorization") String authToken) {
        String token = authToken.substring(7);
        String creatorEmail = jwtTokenUtil.extractEmail(token);
        group.setCreator(creatorEmail);
        group.setId(UUID.randomUUID());
        return groupRepository.save(group);
    }

    @GetMapping("/getGroupId/{groupId}")
    public ResponseEntity<Group> getGroupFromDB(@PathVariable String groupId) {
        Optional<Group> group = groupRepository.findById(UUID.fromString(groupId));
        if (!group.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(group.get());
    }

    @GetMapping("/creator")
    public List<Group> getGroupsByCreator(@RequestHeader("Authorization") String authToken) {
        String token = authToken.substring(7);
        String creatorEmail = jwtTokenUtil.extractEmail(token);
        return groupRepository.findByCreator(creatorEmail);
    }

    @GetMapping("/user")
    public List<Group> getGroupsByUser(@RequestHeader("Authorization") String authToken) {
        String token = authToken.substring(7);
        String userEmail = jwtTokenUtil.extractEmail(token);
        return groupRepository.findByUserEmail(userEmail);
    }

    @PostMapping("/generate-invite/{groupId}")
    public ResponseEntity<String> generateInviteToken(@PathVariable UUID groupId) {
        return groupRepository.findById(groupId)
                .map(group -> {
                    group.generateInviteToken();
                    groupRepository.save(group);
                    String tokenJson = "{\"inviteToken\": \"" + group.getInviteToken() + "\"}";
                    return ResponseEntity.ok(tokenJson);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/join/{inviteToken}")
    public ResponseEntity<String> joinGroup(@PathVariable String inviteToken, @RequestHeader("Authorization") String authToken) {
        // Извлекаем токен без префикса "Bearer "
        String token = authToken.substring(7);
        String userEmail = jwtTokenUtil.extractEmail(token);

        return groupRepository.findByInviteToken(inviteToken)
                .map(group -> {
                    if (!group.getUserEmail().contains(userEmail)) {
                        group.getUserEmail().add(userEmail);
                        groupRepository.save(group);
                        return ResponseEntity.ok("You have successfully joined the group!");
                    } else {
                        return ResponseEntity.badRequest().body("User already in group");
                    }
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addTaskGroup")
    public TaskGroup putTaskGroupIntoDB(@RequestBody TaskGroup taskGroup) {
        taskGroup.setId(UUID.randomUUID());
        return taskGroupRepository.save(taskGroup);
    }

    @GetMapping("/allTasksGroup")
    public List<TaskGroup> getAllTaskGroupFromDB(@RequestParam String groupId) {
        return taskGroupRepository.findByGroupId(groupId);
    }

    @GetMapping("/all")
    public List<TaskGroup> getAllTaskFromDB() {
        return taskGroupRepository.findAll();
    }

    @GetMapping("/getTaskGroup/{taskGroupId}")
    public ResponseEntity<TaskGroup> getTaskGroupFromDB(@PathVariable String taskGroupId) {
        System.out.println("Получен запрос на задачу с ID: " + taskGroupId);
        Optional<TaskGroup> task = taskGroupRepository.findById(UUID.fromString(taskGroupId));
        if (!task.isPresent()) {
            System.out.println("Задача с ID " + taskGroupId + " не найдена.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println("Задача найдена: " + task.get());
        return ResponseEntity.ok(task.get());
    }

    @PutMapping("/update/{taskGroupId}")
    public ResponseEntity<TaskGroup> updateTask(@PathVariable UUID taskGroupId, @RequestBody TaskGroup updatedTask) {
        return taskGroupRepository.findById(taskGroupId)
                .map(existingTask -> {
                    updatedTask.setId(existingTask.getId());
                    updatedTask.setCreationDate(existingTask.getCreationDate());
                    return ResponseEntity.ok(taskGroupRepository.save(updatedTask));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteGroup/{groupId}")
    public ResponseEntity<?> deleteGroup(@PathVariable UUID groupId) {
        if (!groupRepository.existsById(groupId)) {
            return ResponseEntity.notFound().build();
        }
        groupRepository.deleteById(groupId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteTaskGroup/{taskGroupId}")
    public ResponseEntity<?> deleteTaskGroup(@PathVariable UUID taskGroupId) {
        if (!taskGroupRepository.existsById(taskGroupId)) {
            return ResponseEntity.notFound().build();
        }
        taskGroupRepository.deleteById(taskGroupId);
        return ResponseEntity.noContent().build();
    }

}
