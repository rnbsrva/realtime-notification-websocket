package com.akerke.notification.controller;

import com.akerke.notification.dto.NotificationDTO;
import com.akerke.notification.dto.UserDTO;
import com.akerke.notification.service.NotificationService;
import com.akerke.notification.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    ResponseEntity<?> save (
            @RequestBody NotificationDTO notificationDTO
            ) {
        return ResponseEntity.ok(notificationService.save(notificationDTO));
    }

    @GetMapping("{id}")
    ResponseEntity<?> getById (
            @PathVariable Long id
    ){
        return ResponseEntity.ok(notificationService.findById(id));
    }

    @GetMapping
    ResponseEntity<?> get (){
        return ResponseEntity
                .ok(notificationService.findAll());
    }

    @PatchMapping("{id}")
    ResponseEntity<?> update (
            @PathVariable Long id,
            @RequestBody NotificationDTO notificationDTO
    ){
        notificationService.update(id, notificationDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> delete (
            @PathVariable Long id
    ){
        notificationService.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
