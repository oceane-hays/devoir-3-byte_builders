package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;

/**
 * La classe {@code Fournisseur} représente un fournisseur avec des attributs tels que le nom de la compagnie,
 * le mot de passe, l'adresse, le courriel, le téléphone, la capacité de fabrication et une liste de composantes.
 */
public class Fournisseur {

    private String nom_compagnie;
    private String mot_de_passe;
    private String adresse;
    private String courriel;
    private String telephone;
    private int capacite_fabrication;

    @JsonDeserialize(keyUsing = MapDeserialiser.class)
    public HashMap<Composante, Integer> composantes = new HashMap<>();

    /**
     * Constructeur paramétré de la classe {@code Fournisseur} avec annotations Jackson pour la désérialisation JSON.
     *
     * @param nom_compagnie        Le nom de la compagnie du fournisseur.
     * @param mot_de_passe         Le mot de passe du compte fournisseur.
     * @param adresse              L'adresse du fournisseur.
     * @param courriel             L'adresse courriel du fournisseur.
     * @param telephone            Le numéro de téléphone du fournisseur.
     * @param capacite_fabrication La capacité de fabrication du fournisseur.
     * @param composantes          Une carte des composantes avec leurs quantités respectives.
     */
    @JsonCreator
    public Fournisseur(
            @JsonProperty("nom_compagnie") String nom_compagnie,
            @JsonProperty("mot_de_passe") String mot_de_passe,
            @JsonProperty("adresse") String adresse,
            @JsonProperty("courriel") String courriel,
            @JsonProperty("telephone") String telephone,
            @JsonProperty("capacite_fabrication") int capacite_fabrication,
            @JsonProperty("composantes") HashMap<Composante, Integer> composantes) {

        this.nom_compagnie = nom_compagnie;
        this.mot_de_passe = mot_de_passe;
        this.adresse = adresse;
        this.courriel = courriel;
        this.telephone = telephone;
        this.capacite_fabrication = capacite_fabrication;
        this.composantes = composantes;
    }
    @JsonProperty("mot_de_passe")
    public String getMotDePasse() {
        return mot_de_passe;
    }

    @JsonProperty("nom_compagnie")
    public String getNomCompagnie() {
        return nom_compagnie;
    }

    @Override
    public String toString() {
        return "Nom compagnie : " + nom_compagnie + '\n' +
                "Adresse : " + adresse + '\n' +
                "Courriel : " + courriel + '\n' +
                "Téléphone : " + telephone + '\n';
    }

    public void setCapaciteComposantes(Composante composante, Integer nouvInventaire) {
        if (composantes.containsKey(composante)) {
            composantes.put(composante, nouvInventaire);
            System.out.println("Votre inventaire à été mis à jour.");
        } else {
            System.out.println("Nous n'avons pas pu trouve cette composante.");
        }
    }

    public void setMotDePasse(String nouveauMotDePasse) {
        this.mot_de_passe = nouveauMotDePasse;
    }

    public void setCourriel(String nouveauCourriel) {
        this.courriel = nouveauCourriel;
    }

    public void setTelephone(String nouveauTelephone) {
        this.telephone = nouveauTelephone;
    }

    public void setCapaciteFabrication(int nouvelleCapaciteFabrication) {
        this.capacite_fabrication = nouvelleCapaciteFabrication;
    }

    public void setAdresse(String nouvelleAdresse) {
        this.adresse = nouvelleAdresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public HashMap<Composante, Integer> getComposantes() {
        return composantes;
    }

    public String fournisseur() {
        return "Fournisseur : " + '\n' +
                "Compagnie : " + nom_compagnie + '\n' +
                "Types : " + composantes.entrySet() + '\n';
    }

    public String toStringFournisseur() {
        return "Fournisseur : " + '\n' +
                "Compagnie : " + nom_compagnie + '\n' +
                "adresse : " + adresse + '\n' +
                "email : " + courriel + '\n' +
                "capacite de fabrication : " + capacite_fabrication + '\n' +
                "telephone : " + telephone + '\n' +
                "composantes : " + composantes + '\n';
    }
}
