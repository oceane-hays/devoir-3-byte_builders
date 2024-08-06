package com.example.robotix;

public class Composante {
    private String nom;
    private String type;
    private String description;
    private int prix;


    public Composante(String nom, String type, String description, int prix) {
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getPrix() {
        return prix;
    }


    @Override
    public String toString() {
        return "Composante : " + '\n' +
                "nom : " + nom + '\n' +
                "type : " + type + '\n' +
                "description : " + description + '\n' +
                "prix : " + prix  + '\n';
    }
}

