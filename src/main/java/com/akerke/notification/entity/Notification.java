package com.akerke.notification.entity;

import com.akerke.notification.constants.NotificationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("notifications")
public class Notification  implements Serializable {

    @Id
    private String id;
    private NotificationType notificationType;
    private String text;
    private Boolean isRead;
    private Long recipientId;
}
