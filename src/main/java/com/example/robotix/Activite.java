package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Représente une activité dans le système Robotix.
 */
public class Activite {
    private String nom;
    private String statut;
    private String date_debut;
    private String date_fin;
    private int nombre_point;

    /**
     * Constructeur par défaut.
     */
    public Activite() {}

    /**
     * Constructeur avec paramètres.
     *
     * @param nom Le nom de l'activité.
     * @param statut Le statut de l'activité.
     * @param date_debut La date de début de l'activité.
     * @param date_fin La date de fin de l'activité.
     * @param nombre_point Le nombre de points de l'activité.
     */
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

    /**
     * Obtient le nom de l'activité.
     *
     * @return Le nom de l'activité.
     */
    @JsonProperty("nom")
    public String getNom() {
        return nom;
    }

    /**
     * Obtient le statut de l'activité.
     *
     * @return Le statut de l'activité.
     */
    @JsonProperty("statut")
    public String getStatut() {
        return statut;
    }

    /**
     * Obtient la date de début de l'activité.
     *
     * @return La date de début de l'activité.
     */
    @JsonProperty("date_debut")
    public String getDateDebut() {
        return date_debut;
    }

    /**
     * Obtient la date de fin de l'activité.
     *
     * @return La date de fin de l'activité.
     */
    @JsonProperty("date_fin")
    public String getDateFin() {
        return date_fin;
    }

    /**
     * Obtient le nombre de points de l'activité.
     *
     * @return Le nombre de points de l'activité.
     */
    @JsonProperty("nombre_point")
    public int getNombrePoint() {
        return nombre_point;
    }

    /**
     * Définit le nom de l'activité.
     *
     * @param nom Le nouveau nom de l'activité.
     */
    @JsonProperty("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le statut de l'activité.
     *
     * @param statut Le nouveau statut de l'activité.
     */
    @JsonProperty("statut")
    public void setStatut(String statut) {
        this.statut = statut;
    }

    /**
     * Définit la date de début de l'activité.
     *
     * @param date_debut La nouvelle date de début de l'activité.
     */
    @JsonProperty("date_debut")
    public void setDateDebut(String date_debut) {
        this.date_debut = date_debut;
    }

    /**
     * Définit la date de fin de l'activité.
     *
     * @param date_fin La nouvelle date de fin de l'activité.
     */
    @JsonProperty("date_fin")
    public void setDateFin(String date_fin) {
        this.date_fin = date_fin;
    }

    /**
     * Définit le nombre de points de l'activité.
     *
     * @param nombre_point Le nouveau nombre de points de l'activité.
     */
    @JsonProperty("nombre_point")
    public void setNombrePoint(int nombre_point) {
        this.nombre_point = nombre_point;
    }

    /**
     * Retourne une représentation en chaîne de caractères de l'activité.
     *
     * @return Une chaîne de caractères représentant l'activité.
     */
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
