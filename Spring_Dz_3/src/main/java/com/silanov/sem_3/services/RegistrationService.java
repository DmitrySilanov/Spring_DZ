package com.silanov.sem_3.services;

import com.silanov.sem_3.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;
    private final DataProcessingService dataProcessingService;
    private final NotificationService notificationService;

    public RegistrationService(UserService userService,
                               DataProcessingService dataProcessingService,
                               NotificationService notificationService) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
        this.notificationService = notificationService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void processRegistration(String name, int age, String email) {
        User createUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(createUser);
        notificationService.sendNotification("Регистрация выполнена");
    }
}
