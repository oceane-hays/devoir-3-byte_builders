package com.example.robotix;

import java.util.ArrayList;

/**
 * Classe responsable de la gestion de la flotte de robots d'un utilisateur.
 */
public class GestionnaireFlotte {
    private static Utilisateur utilisateur;

    /**
     * Constructeur pour initialiser le gestionnaire de flotte avec un utilisateur.
     *
     * @param utilisateur L'utilisateur auquel appartient la flotte de robots.
     */
    public GestionnaireFlotte(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Ajoute un robot à la flotte de l'utilisateur.
     *
     * @param numeroSerie Le numéro de série du robot.
     * @param nom Le nom du robot.
     * @param type Le type du robot.
     * @param batterie Le niveau de batterie du robot.
     * @param consommationCPU La consommation en CPU du robot.
     */
    public void ajouterRobot(String numeroSerie, String nom, String type, int batterie, int consommationCPU) {
        Robot robot = new Robot(numeroSerie, nom, type, batterie, consommationCPU, null);
        utilisateur.ajouterRobot(robot);
    }

    /**
     * Supprime un robot de la flotte de l'utilisateur en se basant sur le numéro de série.
     *
     * @param numeroSerie Le numéro de série du robot à supprimer.
     */
    public void supprimerRobot(String numeroSerie) {
        for (Robot robot : utilisateur.liste_robot) {
            if (robot.getNumSerie().equals(numeroSerie)) {
                utilisateur.supprimerRobot(robot);
                break;
            }
        }
    }

    /**
     * Ajoute une composante à un robot spécifique en se basant sur le numéro de série du robot.
     *
     * @param numeroSerie Le numéro de série du robot auquel ajouter la composante.
     * @param composante La composante à ajouter au robot.
     */
    public void ajouterComposanteAuRobot(String numeroSerie, Composante composante) {
        for (Robot robot : utilisateur.liste_robot) {
            if (robot.getNumSerie().equals(numeroSerie)) {
                robot.ajouterComposante(composante);
                break;
            }
        }
    }

    /**
     * Supprime une composante d'un robot spécifique en se basant sur le numéro de série du robot et le nom de la composante.
     *
     * @param numeroSerie Le numéro de série du robot dont la composante sera supprimée.
     * @param nomComposante Le nom de la composante à supprimer.
     */
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

    /**
     * Affiche l'état de la flotte de robots de l'utilisateur, y compris les détails des robots et leurs composantes.
     */
    public static void afficherEtatFlotte() {
        if (!utilisateur.liste_robot.isEmpty()) {
            for (Robot robot : utilisateur.liste_robot) {
                System.out.println("Robot : " + robot.getNom() + " (" + robot.getNumSerie() + ")");
                if (robot.getComposantes() == null) robot.setComposantes(new ArrayList<>());
                for (Composante composante : robot.getComposantes()) {
                    System.out.println("  Composante : " + composante.getNom() + " - " + composante.getType());
                }
            }
        } else {
            System.out.println("Votre flotte ne contient aucun robot.");
        }
    }
}
