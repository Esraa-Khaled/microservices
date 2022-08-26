package com.amigoscode.notification.controllers;

import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.notification.services.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value="api/v1/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;


    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("New notification.... {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
