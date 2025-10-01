package com.project.service;

import com.project.model.Notification;
import com.project.model.User;

import java.util.List;

public interface NotificationService {

    Notification sendNotification(User user, String message, String type);

    List<Notification> getNotificationsForUser(User user);

    Notification markAsRead(Long notificationId);
}
