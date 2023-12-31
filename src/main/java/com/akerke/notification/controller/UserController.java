package com.akerke.notification.controller;

import com.akerke.notification.dto.UserDTO;
import com.akerke.notification.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    ResponseEntity<?> save (
            @RequestBody UserDTO userDTO
            ) {
        return ResponseEntity.ok(userService.create(userDTO));
    }

    @GetMapping("{id}")
    ResponseEntity<?> getById (
            @PathVariable Long id
    ){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping()
    ResponseEntity<?> get (){
        return ResponseEntity.ok(userService.findAll());
    }

    @PatchMapping("{id}")
    ResponseEntity<?> update (
            @PathVariable Long id,
            @RequestBody UserDTO userDTO
    ){
        userService.update(id, userDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> delete (
            @PathVariable Long id
    ){
        userService.delete(id);
        return  ResponseEntity.noContent().build();
    }

//    @MessageMapping()

}
