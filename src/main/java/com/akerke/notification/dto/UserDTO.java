package com.akerke.notification.dto;

public record UserDTO (
        String name,
        String surname,
        String email,
        String password
) {
}
