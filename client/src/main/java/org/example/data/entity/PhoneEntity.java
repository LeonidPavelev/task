package org.example.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phones")
public class PhoneEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String number;

    private String type;

    @CreationTimestamp
    private Instant createInstant;

    @UpdateTimestamp
    private Instant updateInstant;

    private Instant deleteInstant;
}
