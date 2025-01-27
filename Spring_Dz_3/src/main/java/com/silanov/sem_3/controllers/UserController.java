package com.silanov.sem_3.controllers;

import com.silanov.sem_3.domain.User;
import com.silanov.sem_3.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> users() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        Integer age = (Integer) requestBody.get("age");
        String email = (String) requestBody.get("email");
        service.processRegistration(name, age, email);
        return "User added from body";
    }
}
