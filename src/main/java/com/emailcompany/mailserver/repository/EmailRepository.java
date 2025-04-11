// The repository interface for the Email entity. This interface extends JpaRepository, which provides CRUD operations.
// This means we can use this interface to perform operations like saving, deleting, and finding Email entities in the database.

package com.emailcompany.mailserver.repository;

import com.emailcompany.mailserver.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByToEmail(String toEmail);
    List<Email> findByFromEmail(String fromEmail);
}
