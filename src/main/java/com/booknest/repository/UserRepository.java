package com.booknest.repository;

import com.booknest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their unique username.
     *
     * @param username the username to look up
     * @return an optional containing the matching user
     */
    Optional<User> findByUsername(String username);
}
