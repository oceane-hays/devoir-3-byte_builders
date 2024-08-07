package com.example.robotix;

import java.util.List;

/**
 * Classe pour afficher les métriques de la flotte de robots.
 */
public class AfficherMetriquesFlotte {
    private int robotsDisponibles;
    private int etatGeneral;
    private int utilisationGlobale;

    /**
     * Constructeur pour initialiser les métriques de la flotte.
     *
     * @param robotsDisponibles Le nombre de robots disponibles.
     * @param etatGeneral L'état général des robots.
     * @param utilisationGlobale L'utilisation globale des robots.
     */
    public AfficherMetriquesFlotte(int robotsDisponibles, int etatGeneral, int utilisationGlobale) {
        this.robotsDisponibles = robotsDisponibles;
        this.etatGeneral = etatGeneral;
        this.utilisationGlobale = utilisationGlobale;
    }

    /**
     * Affiche les métriques générales de la flotte de robots.
     */
    public void afficherMetriques() {
        System.out.println("Robots disponibles: " + robotsDisponibles);
        System.out.println("État général: " + etatGeneral);
        System.out.println("Utilisation globale: " + utilisationGlobale);
    }

    /**
     * Affiche les détails des métriques pour chaque robot dans la liste fournie.
     *
     * @param robots La liste des robots pour lesquels afficher les détails des métriques.
     */
    public void afficherMetriques(List<Robot> robots) {
        for (Robot robot : robots) {
            System.out.println(afficherDetailsRobot(robot));
            System.out.println("-----------------------------------");
        }
    }

    /**
     * Retourne une chaîne de caractères contenant les détails des métriques d'un robot.
     *
     * @param robot Le robot dont les détails des métriques doivent être affichés.
     * @return Une chaîne de caractères contenant les détails des métriques du robot.
     */
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
