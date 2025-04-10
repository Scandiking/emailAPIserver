package com.emailcompany.mailserver.controller;

import com.emailcompany.mailserver.model.Email;
import com.emailcompany.mailserver.repository.EmailRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    private final EmailRepository emailRepository;

    public EmailController(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    // Get all emails
    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails() {
        List<Email> emails = emailRepository.findAll();
        return ResponseEntity.ok(emails);
    }

    // Get email by id
    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        return emailRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new email
    @PostMapping
    public ResponseEntity<Email> createEmail(@RequestBody Email email) {
        email.setTimestamp(LocalDateTime.now());
        Email savedEmail = emailRepository.save(email);
        return ResponseEntity.ok(savedEmail);
    }

    // Update email
    @PutMapping("/{id}")
    public ResponseEntity<Email> updateEmail(@PathVariable Long id, @RequestBody Email emailDetails) {
        return emailRepository.findById(id)
                .map(existingEmail -> {
                    existingEmail.setFromEmail(emailDetails.getFromEmail());
                    existingEmail.setToEmail(emailDetails.getToEmail());
                    existingEmail.setSubject(emailDetails.getSubject());
                    existingEmail.setBody(emailDetails.getBody());
                    // Don't update timestamp om edit
                    return ResponseEntity.ok(emailRepository.save(existingEmail));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete email
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmail(@PathVariable Long id) {
        return emailRepository.findById(id)
                .map(email -> {
                    emailRepository.delete(email);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
