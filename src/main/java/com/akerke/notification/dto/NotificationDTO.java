package com.akerke.notification.dto;

import com.akerke.notification.constants.NotificationType;

public record NotificationDTO (
         NotificationType notificationType,
         String text,
         Long recipientId
) {
}
