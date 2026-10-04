package com.lelisdev.JWTAuth.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @Size(min = 1, max = 100)
    private String name;

    @Column(unique = true)
    @Email
    @Size(min = 1, max = 100)
    private String email;

    @Column(unique = true)
    @Size(min = 1, max = 25)
    private String username;

    @Column
    private String password;

}
