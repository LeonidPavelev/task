package org.example.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPhoneDto {

    private String firstName;

    private String lastName;

    private String secondName;

    private String number;
}
