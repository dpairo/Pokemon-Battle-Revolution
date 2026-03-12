package com.pokedex.domain.ports.output.user;

import com.pokedex.domain.entities.user.User;

import java.util.Optional;

public interface UserRepository {
    User saveUser(User user);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByMail(String userMail);
    boolean existsUserByMail(String userMail);
}
