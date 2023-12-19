package com.akerke.notification.repository;

import com.akerke.notification.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
