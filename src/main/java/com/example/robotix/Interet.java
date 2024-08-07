package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Interet {
    private int num;
    private String description;

    // Default constructor
    public Interet() {}

    // Parameterized constructor with annotations
    @JsonCreator
    public Interet(
            @JsonProperty("num") int num,
            @JsonProperty("description") String description) {
        this.num = num;
        this.description = description;
    }

    // Getters
    @JsonProperty("num")
    public int getNum() {
        return num;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    // Setters
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public Integer getId() {
        return null;
    }
}
