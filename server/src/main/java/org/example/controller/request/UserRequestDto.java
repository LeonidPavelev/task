package org.example.controller.request;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class UserRequestDto {

    String firstName;

    String lastName;

    String secondName;

    String address;

    String position;

}
