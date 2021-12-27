package com.example.pxback.controller;

import com.example.pxback.request.RegistrationRequest;
import com.example.pxback.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users")
@AllArgsConstructor
public class UserController {
    private final RegistrationService registrationService;

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
}
