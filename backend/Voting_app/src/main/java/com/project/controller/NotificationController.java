package com.project.controller;

import com.project.model.Notification;
import com.project.model.User;
import com.project.service.NotificationService;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")

@CrossOrigin(origins = "http://localhost:3000") 
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    // Send notification to a user (Admin) using JSON body
    @PostMapping("/send")
    public ResponseEntity<?> sendNotification(@RequestBody Notification notification) {
        try {
            User user = userService.getUserById(notification.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            Notification savedNotification = notificationService.sendNotification(
                    user,
                    notification.getMessage(),
                    notification.getType()
            );

            return ResponseEntity.ok(savedNotification);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // Get all notifications for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable Long userId) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(notificationService.getNotificationsForUser(user));
    }

    // Mark notification as read
    @PutMapping("/read/{id}")
    public ResponseEntity<Notification> markAsRead(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.markAsRead(id));
    }
}
