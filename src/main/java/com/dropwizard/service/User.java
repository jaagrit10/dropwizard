package com.dropwizard.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private int id;
    private String name;

    public User() {}

    public User(int _id, String _name) {
        this.id = _id;
        this.name = _name;
    }

    @JsonProperty
    public int getid() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }
}