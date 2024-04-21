package org.example.data.repository;

import org.example.data.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PhoneRepository extends JpaRepository<PhoneEntity, UUID> {
    Optional<PhoneEntity> findByNumber(String number);
}
