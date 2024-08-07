package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe représentant une composante avec ses attributs et méthodes associées.
 */
public class Composante {

    private String nom;
    private String type;
    private String description;
    private int prix;

    /**
     * Constructeur par défaut.
     */
    public Composante() {}

    /**
     * Constructeur paramétré avec des annotations Jackson pour la désérialisation JSON.
     *
     * @param nom Le nom de la composante.
     * @param type Le type de la composante.
     * @param description La description de la composante.
     * @param prix Le prix de la composante.
     */
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

    /**
     * Obtient le nom de la composante.
     *
     * @return Le nom de la composante.
     */
    @JsonProperty("nom")
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la composante.
     *
     * @param nom Le nom de la composante.
     */
    @JsonProperty("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le type de la composante.
     *
     * @return Le type de la composante.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Définit le type de la composante.
     *
     * @param type Le type de la composante.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Obtient la description de la composante.
     *
     * @return La description de la composante.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description de la composante.
     *
     * @param description La description de la composante.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtient le prix de la composante.
     *
     * @return Le prix de la composante.
     */
    @JsonProperty("prix")
    public int getPrix() {
        return prix;
    }

    /**
     * Définit le prix de la composante.
     *
     * @param prix Le prix de la composante.
     */
    @JsonProperty("prix")
    public void setPrix(int prix) {
        this.prix = prix;
    }

    /**
     * Applique une réduction au prix de la composante.
     *
     * @param pourcentage Le pourcentage de la réduction.
     * @throws IllegalArgumentException Si le pourcentage est invalide (hors de 0 à 100).
     */
    public void appliquerReduction(int pourcentage) {
        if (pourcentage < 0 || pourcentage > 100) {
            throw new IllegalArgumentException("Pourcentage invalide");
        }
        this.prix -= this.prix * pourcentage / 100;
    }

    /**
     * Formate la description de la composante.
     *
     * @return La description formatée de la composante.
     */
    public String formaterDescription() {
        return nom + " (" + type + "): " + description;
    }

    /**
     * Retourne une représentation textuelle de la composante.
     *
     * @return Une chaîne de caractères représentant la composante.
     */
    @Override
    public String toString() {
        return "Composante : " + '\n' +
                "nom : " + nom + '\n' +
                "type : " + type + '\n' +
                "description : " + description + '\n' +
                "prix : " + prix + '\n';
    }
}
