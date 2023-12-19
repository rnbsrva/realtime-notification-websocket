package com.akerke.notification.controller;

import com.akerke.notification.dto.UserDTO;
import com.akerke.notification.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("new")
    ResponseEntity<?> save (
            @RequestBody UserDTO userDTO
            ) {
        return ResponseEntity.ok(userService.create(userDTO));
    }



}