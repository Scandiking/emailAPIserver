package com.emailcompany.mailserver.model;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emails")

public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fromEmail;

    @Column(nullable = false)
    private String toEmail;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, columnDefinition="TEXT")
    private String body;

    @Column(nullable = false)
    private LocalDateTime timestamp;

}
