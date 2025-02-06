package com.example.pantrypal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.List;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @Setter
    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    @Column(unique = true, nullable = false)
    private String password;

    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ProductUser> productUsers;

    //Constructor
    public User() {}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
