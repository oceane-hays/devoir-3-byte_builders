package com.example.robotix.Test;

import com.example.robotix.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CommandeTest {

    private HashMap<String, Utilisateur> liste_utilisateur;
    private HashMap<Integer, Interet> liste_interet;
    private Scanner scanner;

    @BeforeEach
    public void setUp() {
        liste_utilisateur = new HashMap<>();
        liste_interet = new HashMap<>();
        scanner = new Scanner(System.in);

        // Ajoutez ici les données de test pour utilisateurs, intérêts, etc.
        Utilisateur john = new Utilisateur("johndoe", "Doe", "John", "securepassword",
                "johndoe@example.com", "+1234567890", "Robotix Inc.", true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        liste_utilisateur.put(john.getIdentifiant(), john);

        Interet interet1 = new Interet(1, "Robotics");
        Interet interet2 = new Interet(2, "AI");
        liste_interet.put(interet1.getId(), interet1);
        liste_interet.put(interet2.getId(), interet2);
    }

    @Test
    public void testAjouterPseudoUnique() {
        // Simulation de l'entrée utilisateur pour un pseudo unique
        scanner = new Scanner("newuser\n");
        String pseudo = Commande.ajouterPseudoUnique(scanner, liste_utilisateur);

        assertEquals("newuser", pseudo);
    }

    @Test
    public void testAjouterEmailUnique() {
        // Simulation de l'entrée utilisateur pour un email unique
        scanner = new Scanner("newuser@example.com\n");
        String email = Commande.ajouterEmailUnique(scanner, liste_utilisateur);

        assertEquals("newuser@example.com", email);
    }

    @Test
    public void testChoisirInteret() {
        // Simulation de l'entrée utilisateur pour choisir des intérêts
        scanner = new Scanner("1\n2\n0\n");
        ArrayList<Interet> interets = Commande.choisirInteret(scanner, liste_interet);

        assertEquals(2, interets.size());
        assertTrue(interets.contains(liste_interet.get(1)));
        assertTrue(interets.contains(liste_interet.get(2)));
    }
}
