package com.maksymmikitiuk.university.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @Column(name = "role_id")
    @SequenceGenerator(name = "roles_seq", sequenceName = "roles_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    private Long id;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public UserRole() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}