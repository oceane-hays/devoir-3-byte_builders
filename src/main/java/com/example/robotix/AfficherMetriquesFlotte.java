package com.example.robotix;

import java.util.List;


/**
 * La classe {@code AfficherMetriquesFlotte} est utilisée pour afficher les métriques
 * d'une flotte de robots, notamment le nombre de robots disponibles, l'état général
 * de la flotte, et l'utilisation globale.
 */
public class AfficherMetriquesFlotte {
    private int robotsDisponibles;
    private int etatGeneral;
    private int utilisationGlobale;

    /**
     * Constructeur paramétré pour initialiser les métriques de la flotte.
     *
     * @param robotsDisponibles Le nombre de robots disponibles dans la flotte.
     * @param etatGeneral       L'état général de la flotte.
     * @param utilisationGlobale Le pourcentage d'utilisation globale de la flotte.
     */
    public AfficherMetriquesFlotte(int robotsDisponibles, int etatGeneral, int utilisationGlobale) {
        this.robotsDisponibles = robotsDisponibles;
        this.etatGeneral = etatGeneral;
        this.utilisationGlobale = utilisationGlobale;
    }

    /**
     * Affiche les métriques générales de la flotte.
     */
    public void afficherMetriques() {
        System.out.println("Robots disponibles: " + robotsDisponibles);
        System.out.println("État général: " + etatGeneral);
        System.out.println("Utilisation globale: " + utilisationGlobale);
    }

    /**
     * Affiche les détails des robots individuels dans la flotte.
     *
     * @param robots Une liste de robots pour lesquels les détails doivent être affichés.
     */
    public void afficherMetriques(List<Robot> robots) {
        for (Robot robot : robots) {
            afficherDetailsRobot(robot);
            System.out.println("\n");
        }
    }

    public static String afficherDetailsRobot(Robot robot) {
        return "Robot: " + robot.getNom() + '\n' +
                "Numéro de série: " + robot.getNumSerie() + '\n' +
                "Position: " + robot.getPosition() + '\n' +
                "Vitesse: " + robot.getVitesse() + '\n' +
                "Niveau de batterie: " + robot.getNiveauBatterie() + '\n' +
                "Consommation CPU: " + robot.getConsommationCPU() + '\n' +
                "Consommation mémoire: " + robot.getConsommationMemoire();
    }

}