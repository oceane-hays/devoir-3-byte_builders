package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * La classe {@code Interet} représente un intérêt avec un numéro unique et une description.
 */
public class Interet {

    private int num;
    private String description;

    /**
     * Constructeur par défaut de la classe {@code Interet}.
     */
    public Interet() {}

    /**
     * Constructeur paramétré de la classe {@code Interet} avec annotations Jackson pour la désérialisation JSON.
     *
     * @param num         Le numéro unique de l'intérêt.
     * @param description La description de l'intérêt.
     */
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

    @JsonIgnore
    public Integer getId() {
        return num;
    }
}
