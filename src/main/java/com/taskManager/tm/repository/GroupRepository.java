package com.taskManager.tm.repository;

import com.taskManager.tm.entity.Group;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository extends MongoRepository<Group, UUID> {
    Optional<Group> findByInviteToken(String inviteToken);

    List<Group> findByCreator(String creatorEmail);

    List<Group> findByUserEmail(String userEmail);
}
