package com.taskManager.tm.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document
public class TaskGroup {
    @Id
    private UUID id;
    private String groupId;
    private String title;
    private List<SubTask> subtasks;
    private LocalDateTime dateTime;
    private String description;
    private String category;
    private boolean completed;
    private boolean notification;
    private LocalDateTime dateTimeNotification;
    private boolean favorite;
    private LocalDateTime creationDate;
    private String executor;
}
