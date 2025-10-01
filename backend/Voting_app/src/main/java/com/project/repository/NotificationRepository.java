package com.project.repository;

import com.project.model.Notification;
import com.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserOrderByTimestampDesc(User user);

}
