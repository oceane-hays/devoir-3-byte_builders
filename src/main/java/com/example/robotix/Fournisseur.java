package com.example.robotix;

import java.util.HashMap;

/**
 * Classe représentant un fournisseur avec ses attributs et méthodes associées.
 */
public class Fournisseur {
    private String nom_compagnie;
    private String mot_de_passe;
    private String adresse;
    private String courriel;
    private String telephone;
    private int capacite_fabrication;
    public HashMap<Composante, Integer> composantes = new HashMap<>();

    /**
     * Constructeur paramétré pour créer un fournisseur.
     *
     * @param nom_compagnie Le nom de la compagnie.
     * @param mot_de_passe Le mot de passe du fournisseur.
     * @param adresse L'adresse du fournisseur.
     * @param courriel Le courriel du fournisseur.
     * @param telephone Le numéro de téléphone du fournisseur.
     * @param capacite_fabrication La capacité de fabrication du fournisseur.
     */
    public Fournisseur(String nom_compagnie, String mot_de_passe, String adresse,
                       String courriel, String telephone, int capacite_fabrication) {
        this.nom_compagnie = nom_compagnie;
        this.mot_de_passe = mot_de_passe;
        this.adresse = adresse;
        this.courriel = courriel;
        this.telephone = telephone;
        this.capacite_fabrication = capacite_fabrication;
        this.composantes = composantes;
    }

    /**
     * Obtient le mot de passe du fournisseur.
     *
     * @return Le mot de passe du fournisseur.
     */
    public String getMotDePasse() {
        return mot_de_passe;
    }

    /**
     * Obtient le nom de la compagnie du fournisseur.
     *
     * @return Le nom de la compagnie du fournisseur.
     */
    public String getNomCompagnie() {
        return nom_compagnie;
    }

    /**
     * Retourne une représentation textuelle du fournisseur.
     *
     * @return Une chaîne de caractères représentant le fournisseur.
     */
    @Override
    public String toString() {
        return "Nom compagnie : " + nom_compagnie + '\n' +
                "Adresse : " + adresse + '\n' +
                "Courriel : " + courriel + '\n' +
                "Téléphone : " + telephone + '\n';
    }

    /**
     * Met à jour la capacité des composantes du fournisseur.
     *
     * @param composante La composante à mettre à jour.
     * @param nouvInventaire Le nouvel inventaire de la composante.
     */
    public void setCapaciteComposantes(Composante composante, Integer nouvInventaire) {
        if (composantes.containsKey(composante)) {
            composantes.put(composante, nouvInventaire);
            System.out.println("Votre inventaire à été mis à jour.");
        } else {
            System.out.println("Nous n'avons pas pu trouve cette composante.");
        }
    }

    /**
     * Définit le mot de passe du fournisseur.
     *
     * @param nouveauMotDePasse Le nouveau mot de passe du fournisseur.
     */
    public void setMotDePasse(String nouveauMotDePasse) {
        this.mot_de_passe = nouveauMotDePasse;
    }

    /**
     * Définit le courriel du fournisseur.
     *
     * @param nouveauCourriel Le nouveau courriel du fournisseur.
     */
    public void setCourriel(String nouveauCourriel) {
        this.courriel = nouveauCourriel;
    }

    /**
     * Définit le numéro de téléphone du fournisseur.
     *
     * @param nouveauTelephone Le nouveau numéro de téléphone du fournisseur.
     */
    public void setTelephone(String nouveauTelephone) {
        this.telephone = nouveauTelephone;
    }

    /**
     * Définit la capacité de fabrication du fournisseur.
     *
     * @param nouvelleCapaciteFabrication La nouvelle capacité de fabrication du fournisseur.
     */
    public void setCapaciteFabrication(int nouvelleCapaciteFabrication) {
        this.capacite_fabrication = nouvelleCapaciteFabrication;
    }

    /**
     * Définit l'adresse du fournisseur.
     *
     * @param nouvelleAdresse La nouvelle adresse du fournisseur.
     */
    public void setAdresse(String nouvelleAdresse) {
        this.adresse = nouvelleAdresse;
    }

    /**
     * Obtient l'adresse du fournisseur.
     *
     * @return L'adresse du fournisseur.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Obtient les composantes et leurs quantités du fournisseur.
     *
     * @return Une HashMap des composantes et leurs quantités.
     */
    public HashMap<Composante, Integer> getComposantes() {
        return composantes;
    }

    /**
     * Retourne une représentation textuelle détaillée du fournisseur.
     *
     * @return Une chaîne de caractères détaillant le fournisseur.
     */
    public String fournisseur() {
        return "Fournisseur : " + '\n' +
                "Compagnie : " + nom_compagnie + '\n' +
                "Types : " + composantes.entrySet() + '\n';
    }

    /**
     * Retourne une représentation textuelle détaillée du fournisseur, incluant les composantes.
     *
     * @return Une chaîne de caractères détaillant le fournisseur et ses composantes.
     */
    public String toStringFournisseur() {
        return "Fournisseur : " + '\n' +
                "Compagnie : " + nom_compagnie + '\n' +
                "adresse : " + adresse + '\n' +
                "email : " + courriel + '\n' +
                "capacite de fabrication : " + capacite_fabrication  + '\n' +
                "telephone : " + telephone + '\n' +
                "composantes : " + composantes + '\n';
    }
}
