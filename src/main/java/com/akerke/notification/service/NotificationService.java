package com.akerke.notification.service;

import com.akerke.notification.dto.NotificationDTO;
import com.akerke.notification.entity.Notification;

import java.util.List;

public interface NotificationService {

    Notification save (NotificationDTO notificationDTO);

    Notification  findById(Long id);

    List<Notification> findAll();

    List<Notification> findAllByUserId(Long userId);

    void update(Long id, NotificationDTO notificationDTO);

    void delete (Long id);

}
