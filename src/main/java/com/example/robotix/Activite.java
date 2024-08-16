package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * La classe {@code Activite} représente une activité dans le système Robotix,
 * avec des informations sur son nom, statut, dates de début et de fin, ainsi que
 * le nombre de points associés.
 */
public class Activite {
    private String nom;
    private String statut;
    private String date_debut;
    private String date_fin;
    private int nombre_point;

    /**
     * Constructeur par défaut pour créer une instance vide de {@code Activite}.
     */
    public Activite() {}

    /**
     * Constructeur paramétré pour créer une instance de {@code Activite} avec des valeurs
     * spécifiées pour ses attributs.
     *
     * @param nom           Le nom de l'activité.
     * @param statut        Le statut de l'activité (ex. : "en cours", "terminée").
     * @param date_debut    La date de début de l'activité.
     * @param date_fin      La date de fin de l'activité.
     * @param nombre_point  Le nombre de points associés à l'activité.
     */
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
