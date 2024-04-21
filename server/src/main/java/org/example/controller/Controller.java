package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.request.PhoneRequestDto;
import org.example.controller.request.UserPhoneDto;
import org.example.controller.request.UserRequestDto;
import org.example.service.IntegrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final IntegrationService integrationService;

    @PostMapping("user/logon")
    public void logon(@RequestBody UserRequestDto userRequestDto) {
        integrationService.saveUser(userRequestDto);
    }

    @PostMapping("user/phone")
    public void savePhone(@RequestBody PhoneRequestDto phoneRequestDto){
        integrationService.savePhone(phoneRequestDto);
    }
    @PostMapping("user/bind")
    public void bind (@RequestBody UserPhoneDto userPhoneDto){
        integrationService.bind(userPhoneDto);
    }

}
