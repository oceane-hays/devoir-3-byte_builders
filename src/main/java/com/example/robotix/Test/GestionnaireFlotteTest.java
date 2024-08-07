package com.example.robotix.Test;

import com.example.robotix.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


// Test Junit 1 Sophie. Méthode supprimer Robot.
// Fait en copie locale, constructeur rajouté ds sys et utilisateur.

public class GestionnaireFlotteTest {
    private Systeme systeme;
    private Utilisateur utilisateur;
    private GestionnaireFlotte gestionnaireFlotte;
    public HashMap<String, Utilisateur> liste_utilisateur = new HashMap<>(); // < identifiant , utilisateur >
    public HashMap<String, Fournisseur> liste_fournisseur = new HashMap<>(); // < nom_compagnie , fournisseur >
    public HashMap<Integer, Activite> liste_activites = new HashMap<>();
    public HashMap<Integer, Interet> liste_interet = new HashMap<>();
    public ArrayList<Composante> liste_composante = new ArrayList<>();

    @BeforeEach
    public void setUp() {

        systeme = new Systeme(liste_utilisateur,liste_fournisseur,liste_activites,liste_interet,liste_composante); // ici, eu besoin de creer constructeur ds systeme.
        // on met utilisateur "ds" systeme.
        gestionnaireFlotte = new GestionnaireFlotte(utilisateur);
    }


    @Test
    public void testSupprimerRobot() {

        Robot robot1 = new Robot("001", "1erRobot", "Menager", 100, 10, 2,0, "sda", new ArrayList<>());
        Robot robot2 = new Robot("002", "2eRobot", "Acrobate", 200, 60, 2, 0, "sda", new ArrayList<>());
        // rajout de robots random et test de si on les a enleves ensuite.
        utilisateur.ajouterRobot(robot1);
        utilisateur.ajouterRobot(robot2);

        // robots ajoutés ?
        assertEquals(2, utilisateur.liste_robot.size(), "Erreur : La taille de la liste des robots devrait être 2 après l'ajout des robots.");

        // supprime un robot et ensuite verifie.
        gestionnaireFlotte.supprimerRobot("001");
        assertEquals(1, utilisateur.liste_robot.size(), "Erreur : La taille de la liste des robots devrait être 1 après la suppression du robot avec le numéro de série '123'.");
        assertFalse(utilisateur.liste_robot.contains(robot1), "Erreur : Le robot avec le numéro de série '001' devrait avoir été supprimé de la liste.");
        assertTrue(utilisateur.liste_robot.contains(robot2), "Erreur : Le robot avec le numéro de série '002' devrait toujours être présent dans la liste.");
    }
}
