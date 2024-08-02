package com.example.robotix;

import java.util.ArrayList;

public class Robot {

    private String numSerie; // numéro de série
    private String nom;    // nom du robot
    private String type;  // type de robot

    private int niveauBatterie;
    private int consomationCPU;
    public ArrayList<Composante> liste_composante = new ArrayList<Composante>();


    public Robot(String numSerie, String nom, String type, int niveauBatterie, int consomationCPU) {
        this.numSerie = numSerie;
        this.nom = nom;
        this.type = type;
        this.niveauBatterie = niveauBatterie;
        this.consomationCPU = consomationCPU;

    }


    public String getNumSerie() {
        return numSerie;
    }


    public String getNom() {
        return nom;
    }


    public ArrayList<Composante> getComposantes() {
        return liste_composante;
    }

    public int getNiveauBatterie() {return niveauBatterie;}

    public int getConsommationCPU() {return consomationCPU; }

    public void ajouterComposante(Composante composante) {
        liste_composante.add(composante);
    }

    public void supprimerComposante(Composante composante) {
        liste_composante.remove(composante);
    }

    @Override
    public String toString() {
        return "numero de serie : " + numSerie + '\n' +
                "nom : " + nom + '\n' +
                "type : " + type + '\n' +
                "composantes : " + liste_composante ;
    }

}
