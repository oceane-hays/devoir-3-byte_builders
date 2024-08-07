package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Composante {

    private String nom;
    private String type;
    private String description;
    private int prix;

    // Default constructor
    public Composante() {}

    // Parameterized constructor with Jackson annotations
    @JsonCreator
    public Composante(
            @JsonProperty("nom") String nom,
            @JsonProperty("type") String type,
            @JsonProperty("description") String description,
            @JsonProperty("prix") int prix) {
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.prix = prix;
    }

    // Getters
    @JsonProperty("nom")
    public String getNom() {
        return nom;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("prix")
    public int getPrix() {
        return prix;
    }

    // Setters
    @JsonProperty("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("prix")
    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Composante : " + '\n' +
                "nom : " + nom + '\n' +
                "type : " + type + '\n' +
                "description : " + description + '\n' +
                "prix : " + prix + '\n';
    }
}
