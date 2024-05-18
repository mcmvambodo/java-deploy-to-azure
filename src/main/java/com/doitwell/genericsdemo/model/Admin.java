package com.doitwell.genericsdemo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Users {
    @Column(name = "created_at")
    private String createdAt;
    @Column
    private Long credit = 1000L;
    public Admin(){
        this.isAdmin = true;
        this.createdAt = LocalDateTime.now().toString();
    }

    public Admin(String firstname, String lastname, String email, String password, boolean isAdmin, Long credit) {
        super(firstname, lastname, email, password, isAdmin);
        this.credit = credit;
        this.isAdmin = true;
        this.createdAt = LocalDateTime.now().toString();
    }

    @Override
    public boolean login() {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "createdAt=" + createdAt +
                '}';
    }
}
