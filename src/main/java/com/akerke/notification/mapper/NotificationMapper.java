package com.akerke.notification.mapper;

import com.akerke.notification.dto.NotificationDTO;
import com.akerke.notification.dto.UserDTO;
import com.akerke.notification.entity.Notification;
import com.akerke.notification.entity.User;
import org.mapstruct.*;

import java.util.ArrayList;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface NotificationMapper {

    @Mapping(target = "isRead", expression = "java(false)")
    Notification toModel(NotificationDTO notificationDTO);

    NotificationDTO toDTO (Notification notification);

    @Mapping(target = "id", ignore = true)
    void update(NotificationDTO notificationDTO, @MappingTarget Notification notification);

}
