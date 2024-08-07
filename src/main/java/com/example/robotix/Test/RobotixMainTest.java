package com.example.robotix.Test;

import com.example.robotix.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RobotixMainTest {

    private Systeme systeme;
    private HashMap<String, Utilisateur> liste_utilisateur;
    private HashMap<String, Fournisseur> liste_fournisseur;
    private HashMap<Integer, Activite> liste_activites;
    private HashMap<Integer, Interet> liste_interet;

    @BeforeEach
    public void setUp() {
        // Configuration de l'environnement de test
        liste_utilisateur = new HashMap<>();
        liste_fournisseur = new HashMap<>();
        liste_activites = new HashMap<>();
        liste_interet = new HashMap<>();

        // Configuration des données de test
        setupData();
        systeme = new Systeme(liste_utilisateur, liste_fournisseur, liste_activites, liste_interet, new ArrayList<>());
    }

    private void setupData() {
        // Ajoutez ici les données de test pour utilisateurs, fournisseurs, activités, intérêts, etc.
        // Exemple d'ajout d'un utilisateur et d'un fournisseur
        Utilisateur john = new Utilisateur("johndoe", "Doe", "John", "securepassword",
                "johndoe@example.com", "+1234567890", "Robotix Inc.", true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        liste_utilisateur.put(john.getIdentifiant(), john);

        Fournisseur fournisseur1 = new Fournisseur("Hello World", "password1", "2035 rue de la Cornemuse",
                "email1@example.com", "+1234567890", 100);
        liste_fournisseur.put(fournisseur1.getNomCompagnie(), fournisseur1);
    }

    @Test
    public void testAjouterUtilisateur() {
        Utilisateur newUser = new Utilisateur("janedoe", "Doe", "Jane", "password",
                "janedoe@example.com", "+0987654321", "Company", true, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>());
        systeme.ajouterUtilisateur(newUser.getIdentifiant(), newUser);

        assertTrue(liste_utilisateur.containsKey(newUser.getIdentifiant()));
        assertEquals(newUser, liste_utilisateur.get(newUser.getIdentifiant()));
    }

    @Test
    public void testAjouterFournisseur() {
        Fournisseur newFournisseur = new Fournisseur("Tech Supply", "password", "123 Tech Road",
                "tech@example.com", "+1112223333", 200);
        systeme.ajouterFournisseur(newFournisseur.getNomCompagnie(), newFournisseur);

        assertTrue(liste_fournisseur.containsKey(newFournisseur.getNomCompagnie()));
        assertEquals(newFournisseur, liste_fournisseur.get(newFournisseur.getNomCompagnie()));
    }
}
