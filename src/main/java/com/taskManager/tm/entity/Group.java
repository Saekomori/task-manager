package com.taskManager.tm.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document
public class Group {
    @Id
    private UUID id;
    private String creator;
    private String inviteToken;
    private List<String> userEmail = new ArrayList<>();
    private String name;
    private List<TaskGroup> tasks;

    public void generateInviteToken() {
        this.inviteToken = UUID.randomUUID().toString();
    }
}
