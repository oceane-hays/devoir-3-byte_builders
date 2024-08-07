package com.example.robotix;

import java.util.ArrayList;

public class GestionnaireFlotte {
    private static Utilisateur utilisateur;

    public GestionnaireFlotte(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void ajouterRobot(String numeroSerie, String nom, String type, int vitesse, String position,
                             int batterie, int consommationCPU, int consommationMemoire, ArrayList<Composante> composantes) {
        Robot robot = new Robot(numeroSerie, nom, type, batterie, consommationCPU, consommationMemoire,vitesse,position,composantes);
        utilisateur.ajouterRobot(robot);
    }

    public void supprimerRobot(String numeroSerie) {
        for (Robot robot : utilisateur.liste_robot) {
            if (robot.getNumSerie().equals(numeroSerie)) {
                utilisateur.supprimerRobot(robot);
                break;
            }
        }
    }

    public void ajouterComposanteAuRobot(String numeroSerie, Composante composante) {
        for (Robot robot : utilisateur.liste_robot) {
            if (robot.getNumSerie().equals(numeroSerie)) {
                robot.ajouterComposante(composante);
                break;
            }
        }
    }

    public void supprimerComposanteDuRobot(String numeroSerie, String nomComposante) {
        for (Robot robot : utilisateur.liste_robot) {
            if (robot.getNumSerie().equals(numeroSerie)) {
                for (Composante composante : robot.getComposantes()) {
                    if (composante.getNom().equals(nomComposante)) {
                        robot.supprimerComposante(composante);
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void afficherEtatFlotte() {
        if (!utilisateur.liste_robot.isEmpty()) {
            for (Robot robot : utilisateur.liste_robot) {

                AfficherMetriquesFlotte.afficherDetailsRobot(robot);


                if(robot.getComposantes() == null) robot.setComposantes(new ArrayList<>());

                for (Composante composante : robot.getComposantes()) {
                    System.out.println("  Composante : " + composante.getNom() + " - " + composante.getType());
                }

            }
        } else {
            System.out.println("Votre flotte ne contient aucun robot. ");
        }

    }
}
