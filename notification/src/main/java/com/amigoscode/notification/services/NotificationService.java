package com.amigoscode.notification.services;

import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.notification.dtos.Notification;
import com.amigoscode.notification.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest){

        notificationRepository.save(
                Notification.builder()
                        .toCustomerEmail(notificationRequest.getToCustomerEmail())
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .message(notificationRequest.getMessage())
                        .sender("Notification Service")
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
