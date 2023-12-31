package com.akerke.notification.repository;

import com.akerke.notification.entity.Notification;
import com.akerke.notification.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Set<Notification> findNotificationsByUser(User user);

}
