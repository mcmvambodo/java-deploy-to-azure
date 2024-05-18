package com.doitwell.genericsdemo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends Users {
    @Column(name = "published_articles")
    private List<String> publishedArticles;
    @Column(name = "connected_at")
    private String connectedAt;

    public Manager() {
        this.publishedArticles = new ArrayList<>();
    }

    public Manager(String firstname, String lastname, String email, String password, boolean isAdmin, List<String> publishedArticles) {
        super(firstname, lastname, email, password, isAdmin);
        this.publishedArticles = publishedArticles;;
        this.connectedAt = LocalDateTime.now().toString();
    }

    @Override
    public boolean login() {
        this.connectedAt = LocalDateTime.now().toString();
        this.isConnected = true;
        return true;
    }

    @Override
    public boolean logout() {
        this.isConnected =false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getPublishedArticles() {
        return publishedArticles;
    }

    public void setPublishedArticles(List<String> publishedArticles) {
        this.publishedArticles = publishedArticles;
    }

    public List<String> addArticle(String article){
        this.publishedArticles.add(article);
        return this.publishedArticles;
    }

    public String getConnectedAt() {
        return connectedAt;
    }

    public void setConnectedAt(String connectedAt) {
        this.connectedAt = connectedAt;
    }
}
