package com.example.hellodockertest;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private final RegistrationRepository registrationRepository;

    public RegistrationController(final RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestParam String name) {
        final Registration persistRegistration = registrationRepository.save(new Registration(name));

        return ResponseEntity.created(URI.create("/registrations" + persistRegistration.getId())).build();
    }
}
