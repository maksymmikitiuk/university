package com.maksymmikitiuk.university.model;

import javax.persistence.*;
import java.security.PrivateKey;
import java.security.Timestamp;

@Entity
@Table(name = "persistent_logins")
public class PersistentLogins {

    @Id
    @Column(name = "persistent_logins_id", unique = true)
    @SequenceGenerator(name = "persistent_logins_seq", sequenceName = "persistent_logins_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persistent_logins_seq")
    private Long id;

    @Column(name = "username", nullable = false, length = 64)
    private String username;

    @Column(name = "series", nullable = false, length = 64)
    private String series;

    @Column(name = "token", nullable = false, length = 64)
    private String token;

    @Column(name = "last_used", nullable = false)
    private Timestamp lastUsed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Timestamp lastUsed) {
        this.lastUsed = lastUsed;
    }
}
