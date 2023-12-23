package com.akerke.notification.entity;

import com.akerke.notification.constants.NotificationType;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private NotificationType notificationType;
    private String text;
    private Boolean isRead;
    @ManyToOne
    @JsonProperty("ownerId")
    private User user;

    @JsonGetter("ownerId")
    public Long getUserId(){
        return this.user.getId();
    }
}
