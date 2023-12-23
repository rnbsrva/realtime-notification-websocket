package com.akerke.notification.handler;

import com.akerke.notification.service.NotificationService;
import com.akerke.notification.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WsNotificationHandler {

    private final SimpMessagingTemplate ws;
    private final NotificationService notificationService;

    @MessageMapping("/on_user_session_started")
    void onSessionStarted(
            Long userId
    ){
        log.info("user [{}]session started", userId);
        var notifications = notificationService.findAllByUserId(userId);

        log.info("send message to staff {}", notifications);
        ws.convertAndSend("/topic/user/notifications/" + userId, notifications);
    }

}
