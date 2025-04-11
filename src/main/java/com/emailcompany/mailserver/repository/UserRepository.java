// This is the repository interface for the User entity. This interface extends JpaRepository, which provides CRUD operations.
// This means we can use this interface to perform operations like saving, deleting, and finding User entities in the database.
// The UserRepository interface is annotated with @Repository, which indicates that it's a Spring Data repository.

package com.emailcompany.mailserver.repository;

import com.emailcompany.mailserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
