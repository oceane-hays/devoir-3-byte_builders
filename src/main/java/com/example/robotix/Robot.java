package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Représente un robot avec divers attributs tels que le numéro de série, le nom, le type,
 * la position, la vitesse, le niveau de batterie, la consommation CPU, et une liste de composants.
 */
public class Robot {

    private String numSerie; // Numéro de série du robot
    private String nom;      // Nom du robot
    private String position; // Position actuelle du robot
    private int vitesse;     // Vitesse du robot
    private String type;     // Type de robot
    private int niveauBatterie; // Niveau de batterie du robot
    private int consommationCPU; // Consommation CPU du robot
    private int consommationMemoire; // Consommation mémoire du robot
    private ArrayList<Composante> liste_composante = new ArrayList<>(); // Liste des composants du robot

    /**
     * Constructeur paramétré pour créer un robot avec les attributs spécifiés.
     *
     * @param numSerie Numéro de série du robot.
     * @param nom Nom du robot.
     * @param type Type de robot.
     * @param niveauBatterie Niveau de batterie du robot.
     * @param consommationCPU Consommation CPU du robot.
     * @param position Position actuelle du robot.
     */
    @JsonCreator
    public Robot(
            @JsonProperty("numSerie") String numSerie,
            @JsonProperty("nom") String nom,
            @JsonProperty("type") String type,
            @JsonProperty("niveauBatterie") int niveauBatterie,
            @JsonProperty("consommationCPU") int consommationCPU,
            @JsonProperty("position") String position) {
        this.numSerie = numSerie;
        this.nom = nom;
        this.type = type;
        this.position = position;
        this.vitesse = vitesse;
        this.consommationMemoire = consommationMemoire;
        this.niveauBatterie = niveauBatterie;
        this.consommationCPU = consommationCPU;
        this.liste_composante = liste_composante;
    }

    // Getters

    /**
     * Obtient le numéro de série du robot.
     *
     * @return Le numéro de série du robot.
     */
    @JsonProperty("numSerie")
    public String getNumSerie() {
        return numSerie;
    }

    /**
     * Obtient le nom du robot.
     *
     * @return Le nom du robot.
     */
    @JsonProperty("nom")
    public String getNom() {
        return nom;
    }

    /**
     * Obtient le type du robot.
     *
     * @return Le type du robot.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Obtient la position actuelle du robot.
     *
     * @return La position actuelle du robot.
     */
    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    /**
     * Obtient la vitesse du robot.
     *
     * @return La vitesse du robot.
     */
    @JsonProperty("vitesse")
    public int getVitesse() {
        return vitesse;
    }

    /**
     * Obtient le niveau de batterie du robot.
     *
     * @return Le niveau de batterie du robot.
     */
    @JsonProperty("niveauBatterie")
    public int getNiveauBatterie() {
        return niveauBatterie;
    }

    /**
     * Obtient la consommation CPU du robot.
     *
     * @return La consommation CPU du robot.
     */
    @JsonProperty("consommationCPU")
    public int getConsommationCPU() {
        return consommationCPU;
    }

    /**
     * Obtient la consommation mémoire du robot.
     *
     * @return La consommation mémoire du robot.
     */
    @JsonProperty("consommationMemoire")
    public int getConsommationMemoire() {
        return consommationMemoire;
    }

    /**
     * Obtient la liste des composants du robot.
     *
     * @return La liste des composants du robot.
     */
    @JsonProperty("liste_composante")
    public ArrayList<Composante> getComposantes() {
        return liste_composante;
    }

    // Setters

    /**
     * Définit le numéro de série du robot.
     *
     * @param numSerie Le nouveau numéro de série du robot.
     */
    @JsonProperty("numSerie")
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    /**
     * Définit le nom du robot.
     *
     * @param nom Le nouveau nom du robot.
     */
    @JsonProperty("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le type du robot.
     *
     * @param type Le nouveau type du robot.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Définit la position actuelle du robot.
     *
     * @param position La nouvelle position du robot.
     */
    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Définit la vitesse du robot.
     *
     * @param vitesse La nouvelle vitesse du robot.
     */
    @JsonProperty("vitesse")
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    /**
     * Définit le niveau de batterie du robot.
     *
     * @param niveauBatterie Le nouveau niveau de batterie du robot.
     */
    @JsonProperty("niveauBatterie")
    public void setNiveauBatterie(int niveauBatterie) {
        this.niveauBatterie = niveauBatterie;
    }

    /**
     * Définit la consommation CPU du robot.
     *
     * @param consommationCPU La nouvelle consommation CPU du robot.
     */
    @JsonProperty("consommationCPU")
    public void setConsommationCPU(int consommationCPU) {
        this.consommationCPU = consommationCPU;
    }

    /**
     * Définit la consommation mémoire du robot.
     *
     * @param consommationMemoire La nouvelle consommation mémoire du robot.
     */
    @JsonProperty("consommationMemoire")
    public void setConsommationMemoire(int consommationMemoire) {
        this.consommationMemoire = consommationMemoire;
    }

    /**
     * Définit la liste des composants du robot.
     *
     * @param liste_composante La nouvelle liste des composants du robot.
     */
    @JsonProperty("liste_composante")
    public void setComposantes(ArrayList<Composante> liste_composante) {
        this.liste_composante = liste_composante;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'objet Robot.
     *
     * @return Une chaîne de caractères décrivant le robot.
     */
    @Override
    public String toString() {
        return "Robot {" +
                "numSerie='" + numSerie + '\'' +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", position='" + position + '\'' +
                ", vitesse=" + vitesse +
                ", niveauBatterie=" + niveauBatterie +
                ", consommationCPU=" + consommationCPU +
                ", consommationMemoire=" + consommationMemoire +
                ", liste_composante=\n" + liste_composante.toString() +
                '}';
    }

    /**
     * Retourne une chaîne de caractères décrivant les attributs principaux du robot.
     *
     * @return Une chaîne de caractères décrivant le robot.
     */
    public String robot() {
        return "numero de serie : " + numSerie + '\n' +
                "nom : " + nom + '\n' +
                "type : " + type + '\n' +
                "composantes : " + liste_composante;
    }

    /**
     * Supprime une composante de la liste des composants du robot.
     *
     * @param composante La composante à supprimer.
     */
    public void supprimerComposante(Composante composante) {
        this.liste_composante.remove(composante);
    }

    /**
     * Ajoute une composante à la liste des composants du robot.
     *
     * @param composante La composante à ajouter.
     */
    public void ajouterComposante(Composante composante) {
        this.liste_composante.add(composante);
    }
}
