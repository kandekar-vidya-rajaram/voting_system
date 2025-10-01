package com.project.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @Min(18)
    private int age;

    @Column(unique = true)
    private String voterId;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getVoterId() { return voterId; }
    public void setVoterId(String voterId) { this.voterId = voterId; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public enum Role {
        USER, ADMIN
    }
}
