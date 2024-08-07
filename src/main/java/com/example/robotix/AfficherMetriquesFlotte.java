package com.example.robotix;

import java.util.List;


public class AfficherMetriquesFlotte {
    private int robotsDisponibles;
    private int etatGeneral;
    private int utilisationGlobale;

    public AfficherMetriquesFlotte(int robotsDisponibles, int etatGeneral, int utilisationGlobale) {
        this.robotsDisponibles = robotsDisponibles;
        this.etatGeneral = etatGeneral;
        this.utilisationGlobale = utilisationGlobale;
    }

    public void afficherMetriques() {
        System.out.println("Robots disponibles: " + robotsDisponibles);
        System.out.println("État général: " + etatGeneral);
        System.out.println("Utilisation globale: " + utilisationGlobale);
    }

    public void afficherMetriques(List<Robot> robots) {
        for (Robot robot : robots) {
            afficherDetailsRobot(robot);
            System.out.println("-----------------------------------");
        }
    }

    public String afficherDetailsRobot(Robot robot) {
        return "Robot: " + robot.getNom() + '\n' +
                "Numéro de série: " + robot.getNumSerie() + '\n' +
                "Position: " + robot.getPosition() + '\n' +
                "Vitesse: " + robot.getVitesse() + '\n' +
                "Niveau de batterie: " + robot.getNiveauBatterie() + '\n' +
                "Consommation CPU: " + robot.getConsommationCPU() + '\n' +
                "Consommation mémoire: " + robot.getConsommationMemoire();
    }

}