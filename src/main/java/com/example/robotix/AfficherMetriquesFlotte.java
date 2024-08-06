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

    private void afficherDetailsRobot(Robot robot) {
        System.out.println("Robot: " + robot.getNom());
        System.out.println("Niveau de batterie: " + robot.getNiveauBatterie());
        System.out.println("Consommation CPU: " + robot.getConsommationCPU());

    }

    // Getters et Setters
    public int getRobotsDisponibles() {
        return robotsDisponibles;
    }

    public void setRobotsDisponibles(int robotsDisponibles) {
        this.robotsDisponibles = robotsDisponibles;
    }

    public int getEtatGeneral() {
        return etatGeneral;
    }

    public void setEtatGeneral(int etatGeneral) {
        this.etatGeneral = etatGeneral;
    }

    public int getUtilisationGlobale() {
        return utilisationGlobale;
    }

    public void setUtilisationGlobale(int utilisationGlobale) {
        this.utilisationGlobale = utilisationGlobale;
    }
}

// package com.example.robotix;

// import java.util.List;

// public class AfficherMetriquesFlotte {
//     private int robotsDisponibles; // Nombre de robots disponibles
//     private int etatGeneral; // État général de la flotte de robots
//     private int utilisationGlobale; // Utilisation globale de la flotte de robots

//     // Constructeur pour initialiser les métriques
//     public AfficherMetriquesFlotte(int robotsDisponibles, int etatGeneral, int utilisationGlobale) {
//         this.robotsDisponibles = robotsDisponibles;
//         this.etatGeneral = etatGeneral;
//         this.utilisationGlobale = utilisationGlobale;
//     }

//     // Méthode pour afficher les métriques globales de la flotte
//     public void afficherMetriques() {
//         System.out.println("Métriques globales de la flotte:");
//         System.out.println("Robots disponibles: " + robotsDisponibles);
//         System.out.println("État général: " + etatGeneral);
//         System.out.println("Utilisation globale: " + utilisationGlobale);
//     }

//     // Méthode pour afficher les métriques détaillées pour chaque robot de la liste
//     public void afficherMetriques(List<Robot> robots) {
//         System.out.println("Détails des robots de la flotte:");
//         for (Robot robot : robots) {
//             afficherDetailsRobot(robot);
//             System.out.println("-----------------------------------");
//         }
//     }

//     // Méthode privée pour afficher les détails d'un robot
//     private void afficherDetailsRobot(Robot robot) {
//         System.out.println("Nom du robot: " + robot.getNom());
//         System.out.println("Niveau de batterie: " + robot.getNiveauBatterie() + "%");
//         System.out.println("Consommation CPU: " + robot.getConsommationCPU() + "%");
//     }

//     // Getters et Setters
//     public int getRobotsDisponibles() {
//         return robotsDisponibles;
//     }

//     public void setRobotsDisponibles(int robotsDisponibles) {
//         this.robotsDisponibles = robotsDisponibles;
//     }

//     public int getEtatGeneral() {
//         return etatGeneral;
//     }

//     public void setEtatGeneral(int etatGeneral) {
//         this.etatGeneral = etatGeneral;
//     }

//     public int getUtilisationGlobale() {
//         return utilisationGlobale;
//     }

//     public void setUtilisationGlobale(int utilisationGlobale) {
//         this.utilisationGlobale = utilisationGlobale;
//     }
// }
