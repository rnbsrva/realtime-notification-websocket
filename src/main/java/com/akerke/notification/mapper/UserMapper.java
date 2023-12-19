package com.akerke.notification.mapper;


import com.akerke.notification.dto.UserDTO;
import com.akerke.notification.entity.Notification;
import com.akerke.notification.entity.User;
import org.mapstruct.*;

import java.util.ArrayList;

@Mapper(
        imports = {Notification.class,  ArrayList.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserMapper {

    @Mapping(target = "notifications", expression = "java(new ArrayList<Notification>())")
    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);

    @Mapping(target = "id", ignore = true)
    void update(UserDTO userDTO, @MappingTarget User user);

}