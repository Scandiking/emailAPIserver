/*
This class represents an Email entity in the database.
It contains fields for the email's ID, sender's email address, recipient's email address, subject, body, and timestamp.
 */

package com.emailcompany.mailserver.model;

// Lombok makes it easier to create Java classes by generating boilerplate code like getters, setters, and constructors.
import lombok.*;

// Jakarta Persistence is a specification for accessing, persisting, and managing data between Java objects and relational databases.
import jakarta.persistence.*;

import java.time.LocalDateTime;

// @Getter and @Setter are annotations from Lombok that automatically generate getter and setter methods for the fields in the class.
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
// @Entity is a JPA annotation that specifies that the class is an entity and is mapped to a database table.
@Entity
// @Table is a JPA annotation that specifies the name of the database table to which the entity is mapped.
@Table(name = "emails")

public class Email {
    @Id
    // GenerationType.IDENTITY is a strategy for generating unique primary keys for entities.
    // This way you won't have to worry about generating unique IDs manually in Postman
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
