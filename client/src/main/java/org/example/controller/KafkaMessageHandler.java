package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.example.domain.PhoneDto;
import org.example.domain.UserDto;
import org.example.domain.UserPhoneDto;
import org.example.service.UserService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaMessageHandler {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "task")
    @Transactional
    public void process(ConsumerRecord<String, String> record) {
        Header action = record.headers().headers("action").iterator().next();
        String actionValue = new String(action.value(), StandardCharsets.UTF_8);
        if ("saveUser".equals(actionValue)) {
            UserDto userDto = parse(UserDto.class, record.value());
            userService.saveUser(userDto);
        } else if ("savePhone".equals(actionValue)) {
            PhoneDto phoneDto = parse(PhoneDto.class, record.value());
            userService.savePhone(phoneDto);
        } else if ("bindPhone".equals(actionValue)) {
            UserPhoneDto userPhoneDto = parse(UserPhoneDto.class, record.value());
            userService.bind(userPhoneDto.getFirstName(), userPhoneDto.getLastName(), userPhoneDto.getSecondName(), userPhoneDto.getNumber());
        } else {
            log.warn("Unsupported action {}", actionValue);
        }
    }

    @SneakyThrows
    private <T> T parse(Class<T> type, String value) {
        return objectMapper.readValue(value, type);
    }


}
