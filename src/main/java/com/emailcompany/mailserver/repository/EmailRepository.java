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
