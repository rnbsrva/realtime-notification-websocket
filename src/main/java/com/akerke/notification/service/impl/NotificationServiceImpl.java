package com.akerke.notification.service.impl;

import com.akerke.notification.dto.NotificationDTO;
import com.akerke.notification.entity.Notification;
import com.akerke.notification.mapper.NotificationMapper;
import com.akerke.notification.repository.NotificationRepository;
import com.akerke.notification.service.NotificationService;
import com.akerke.notification.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
 public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final UserService userService;

    @Override
    public Notification save(NotificationDTO notificationDTO) {
        var notification = notificationMapper.toModel(notificationDTO);
        notification.setUser(userService.findById(notificationDTO.recipientId()));
        return notificationRepository.save(notification);
    }

    @Override
    public Notification findById(Long id) {
        return notificationRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> findAllByUserId(Long userId) {
        var user = userService.findById(userId);
        return new ArrayList<>(notificationRepository.findNotificationsByUser(user));
    }

    @Override
    public void update(Long id, NotificationDTO notificationDTO) {
        var notification = this.findById(id);
        notificationMapper.update(notificationDTO, notification);
        notificationRepository.save(notification);
    }

    @Override
    public void delete(Long id) {
        var notification = this.findById(id);
        notificationRepository.delete(notification);
    }
}
