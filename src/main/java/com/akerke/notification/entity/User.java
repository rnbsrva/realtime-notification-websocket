package com.akerke.notification.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Indexed;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@RedisHash("users")
@NoArgsConstructor
@Indexed
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private List<Notification> notifications;

}
