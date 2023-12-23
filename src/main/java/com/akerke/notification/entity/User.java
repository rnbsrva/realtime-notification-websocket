package com.akerke.notification.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Table(name = "users")
@Entity
@NoArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    @JsonProperty("notificationIds")
    private List<Notification> notifications;

    @JsonGetter("notificationIds")
    public  List<Long> getNotificationIds (){
        return this.notifications.stream().map(Notification::getId).collect(Collectors.toList());
    }

}
