/*
This class represents a User entity in the database. It contains fields for the user's ID, username, email, and password.
 */

// com.emailcompany.mailserver.model is used to define the model classes for the application.
package com.emailcompany.mailserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
// jakarta.validation.constraints is used for validating the fields in the User class, e.g. not null, unique, and email format.
import jakarta.validation.constraints.Email;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique=true)
    private String username;

    @Column(nullable = false, unique = true)
    // @Email is a validation annotation that checks if the email format is valid.
    @Email(message = "Email should be valid. Remember '@' and '.'")
    private String email;

    @Column(nullable = false)
    private String password;

}
