package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Robot {

    private String numSerie; // numéro de série
    private String nom;      // nom du robot
    private String position; // position du robot
    private int vitesse;     // vitesse du robot
    private String type;     // type de robot
    private int niveauBatterie;
    private int consommationCPU;
    private int consommationMemoire;
    private ArrayList<Composante> liste_composante = new ArrayList<>();

    // Parameterized constructor with Jackson annotations
    @JsonCreator
    public Robot(
            @JsonProperty("numSerie") String numSerie,
            @JsonProperty("nom") String nom,
            @JsonProperty("type") String type,
            @JsonProperty("niveauBatterie") int niveauBatterie,
            @JsonProperty("consommationCPU") int consommationCPU,
            @JsonProperty("consommationMemoire") int consommationMemoire,
            @JsonProperty("vitesse") int vitesse,
            @JsonProperty("position") String position,
            @JsonProperty("liste_composante") ArrayList<Composante> liste_composante) {
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
    @JsonProperty("numSerie")
    public String getNumSerie() {
        return numSerie;
    }

    @JsonProperty("nom")
    public String getNom() {
        return nom;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    @JsonProperty("vitesse")
    public int getVitesse() {
        return vitesse;
    }

    @JsonProperty("niveauBatterie")
    public int getNiveauBatterie() {
        return niveauBatterie;
    }

    @JsonProperty("consommationCPU")
    public int getConsommationCPU() {
        return consommationCPU;
    }

    @JsonProperty("consommationMemoire")
    public int getConsommationMemoire() {
        return consommationMemoire;
    }

    @JsonProperty("liste_composante")
    public ArrayList<Composante> getComposantes() {
        return liste_composante;
    }

    // Setters
    @JsonProperty("numSerie")
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    @JsonProperty("nom")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty("vitesse")
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    @JsonProperty("niveauBatterie")
    public void setNiveauBatterie(int niveauBatterie) {
        this.niveauBatterie = niveauBatterie;
    }

    @JsonProperty("consommationCPU")
    public void setConsommationCPU(int consommationCPU) {
        this.consommationCPU = consommationCPU;
    }

    @JsonProperty("consommationMemoire")
    public void setConsommationMemoire(int consommationMemoire) {
        this.consommationMemoire = consommationMemoire;
    }

    @JsonProperty("liste_composante")
    public void setComposantes(ArrayList<Composante> liste_composante) {
        this.liste_composante = liste_composante;
    }

    @Override
    public String toString() {
        // Build the complete string representation of the Robot object
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

    public String robot() {
        return "numero de serie : " + numSerie + '\n' +
                "nom : " + nom + '\n' +
                "type : " + type + '\n' +
                "composantes : " + liste_composante;
    }

    public void supprimerComposante(Composante composante) {
        this.liste_composante.remove(composante);
    }

    public void ajouterComposante(Composante composante) {
        this.liste_composante.add(composante);
    }
}
