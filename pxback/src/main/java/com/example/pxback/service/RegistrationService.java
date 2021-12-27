package com.example.pxback.service;


import com.example.pxback.entity.AppUserEntity;
import com.example.pxback.enums.AppUserRole;
import com.example.pxback.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private EmailValidatorService emailValidatorService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidatorService.test((request.getEmail()));
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(new AppUserEntity(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
        ));
    }
}
