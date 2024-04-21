package org.example.data.entity;

import jakarta.persistence.*;
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
@Table(name = "users_link_phones")
public class UserPhonesEntity {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne(optional = false)
    @JoinColumn(name = "phone_id")
    private PhoneEntity phone;

    @CreationTimestamp
    Instant createInstant;
    @UpdateTimestamp
    Instant updateInstant;

    Instant deleteInstant;
}
