package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Activite {
    private String nom;
    private String statut;
    private String date_debut;
    private String date_fin;
    private int nombre_point;

    // Default constructor
    public Activite() {}

    // Parameterized constructor with annotations
    @JsonCreator
    public Activite(
            @JsonProperty("nom") String nom,
            @JsonProperty("statut") String statut,
            @JsonProperty("date_debut") String date_debut,
            @JsonProperty("date_fin") String date_fin,
            @JsonProperty("nombre_point") int nombre_point) {
        this.nom = nom;
        this.statut = statut;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nombre_point = nombre_point;
    }

    // Getters
    @JsonProperty("nom")
    public String getNom() {
        return nom;
    }

    @JsonProperty("statut")
    public String getStatut() {
        return statut;
    }

    @JsonProperty("date_debut")
    public String getDateDebut() {
        return date_debut;
    }

    @JsonProperty("date_fin")
    public String getDateFin() {
        return date_fin;
    }

    @JsonProperty("nombre_point")
    public int getNombrePoint() {
        return nombre_point;
    }

    // Setters
    @JsonProperty("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @JsonProperty("statut")
    public void setStatut(String statut) {
        this.statut = statut;
    }

    @JsonProperty("date_debut")
    public void setDateDebut(String date_debut) {
        this.date_debut = date_debut;
    }

    @JsonProperty("date_fin")
    public void setDateFin(String date_fin) {
        this.date_fin = date_fin;
    }

    @JsonProperty("nombre_point")
    public void setNombrePoint(int nombre_point) {
        this.nombre_point = nombre_point;
    }

    @Override
    public String toString() {
        return String.format(
                "Activite [nom=%s, statut=%s, date_debut=%s, date_fin=%s, nombre_point=%d]",
                nom,
                statut,
                date_debut,
                date_fin,
                nombre_point
        );
    }
}
