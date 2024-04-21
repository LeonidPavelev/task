package org.example.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.example.controller.request.PhoneRequestDto;
import org.example.controller.request.UserPhoneDto;
import org.example.controller.request.UserRequestDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Service
public class IntegrationService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void saveUser (UserRequestDto userPogo){
        ProducerRecord<String, Object> record = new ProducerRecord<>("task", userPogo);
        record.headers().add("action", "saveUser".getBytes(StandardCharsets.UTF_8));
        kafkaTemplate.send(record);
    }

    public void savePhone(PhoneRequestDto phonePogo) {
        ProducerRecord<String, Object> record = new ProducerRecord<>("task", phonePogo);
        record.headers().add("action", "savePhone".getBytes(StandardCharsets.UTF_8));
        kafkaTemplate.send(record);
    }

    public void bind(UserPhoneDto userPhoneDto){
        ProducerRecord<String, Object> record = new ProducerRecord<>("task", userPhoneDto);
        record.headers().add("action", "bindPhone".getBytes(StandardCharsets.UTF_8));
        kafkaTemplate.send(record);
    }


}
