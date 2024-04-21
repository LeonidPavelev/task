package org.example.data.repository;

import org.example.data.entity.UserPhonesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserPhoneRepository extends JpaRepository<UserPhonesEntity, UUID> {
}
