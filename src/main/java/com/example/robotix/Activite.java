package com.example.robotix;

public class Activite {
    private String nom;
    private String statut;
    private String date_debut;
    private String date_fin;
    private int nombre_point;


    public Activite(String nom, String statut, String date_debut, String date_fin, int nombre_point) {
        this.nom = nom;
        this.statut = statut;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nombre_point = nombre_point;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getStatut() {
        return statut;
    }

    public int getNombrePoint() {
        return nombre_point;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setNombrePoint(int nombre_point) {
        this.nombre_point = nombre_point;
    }

    @Override
    public String toString() {
        return "nom : " + nom + '\n' +
                "statut : " + statut + '\n' +
                "date début : " + date_debut + '\n' +
                "date fin : " + date_fin + '\n' +
                "nombre de point : " + nombre_point + '\n';
    }
}
