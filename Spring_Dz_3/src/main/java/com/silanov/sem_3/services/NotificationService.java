package com.silanov.sem_3.services;

import com.silanov.sem_3.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
    public String sendNotification(String message) {
        return message;
    }
}
