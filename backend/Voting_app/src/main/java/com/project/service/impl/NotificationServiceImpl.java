package com.project.service.impl;

import com.project.model.Notification;
import com.project.model.User;
import com.project.repository.NotificationRepository;
import com.project.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification sendNotification(User user, String message, String type) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notification.setType(type);
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsForUser(User user) {
        return notificationRepository.findByUserOrderByTimestampDesc(user);
    }

    @Override
    public Notification markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        return notificationRepository.save(notification);
    }
}
