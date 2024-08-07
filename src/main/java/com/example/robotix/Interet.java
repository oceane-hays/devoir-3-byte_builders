package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Représente un intérêt avec un numéro unique et une description.
 */
public class Interet {
    private int num;
    private String description;

    /**
     * Constructeur par défaut.
     */
    public Interet() {}

    /**
     * Constructeur paramétré pour créer un intérêt avec un numéro et une description.
     *
     * @param num Le numéro unique de l'intérêt.
     * @param description La description de l'intérêt.
     */
    @JsonCreator
    public Interet(
            @JsonProperty("num") int num,
            @JsonProperty("description") String description) {
        this.num = num;
        this.description = description;
    }

    /**
     * Obtient le numéro de l'intérêt.
     *
     * @return Le numéro de l'intérêt.
     */
    @JsonProperty("num")
    public int getNum() {
        return num;
    }

    /**
     * Obtient la description de l'intérêt.
     *
     * @return La description de l'intérêt.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description de l'intérêt.
     *
     * @param description La nouvelle description de l'intérêt.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'intérêt.
     *
     * @return La description de l'intérêt.
     */
    @Override
    public String toString() {
        return description;
    }

    /**
     * Retourne l'identifiant de l'intérêt.
     * Note : Cette méthode retourne toujours `null` dans l'implémentation actuelle.
     *
     * @return L'identifiant de l'intérêt, toujours `null` dans cette version.
     */
    public Integer getId() {
        return null;
    }
}
