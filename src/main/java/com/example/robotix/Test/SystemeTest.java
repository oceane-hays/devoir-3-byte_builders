package com.example.robotix.Test;

import com.example.robotix.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


// Cette classe vise a faire les deux autres tests Junit (Sophie) Les méthodes testées sont 1. rechercherComposante
public class SystemeTest {
    private Systeme systeme;
    private Utilisateur utilisateurDeTest; // besoin de creer un private field pour gain access a utilisateur
    public HashMap<String, Utilisateur> liste_utilisateur = new HashMap<>(); // < identifiant , utilisateur >
    public HashMap<String, Fournisseur> liste_fournisseur = new HashMap<>(); // < nom_compagnie , fournisseur >
    public HashMap<Integer, Activite> liste_activites = new HashMap<>();
    public HashMap<Integer, Interet> liste_interet = new HashMap<>();
    public ArrayList<Composante> liste_composante = new ArrayList<>();

    @BeforeEach
    public void setUp() {

        systeme = new Systeme(liste_utilisateur,liste_fournisseur,liste_activites,liste_interet,liste_composante);

        // j'initie liste composante avec des données fictives.
        Composante composante1 = new Composante("Roue", "Metal", "Petite roue (rayon = 5cm) en" +
                " métal avec capteurs.", 2);
        Composante composante2 = new Composante("Antenne", "Radio", "Antenne permettant à un robot " +
                "de recevoir des ondes radios.", 8);

        systeme.liste_composante.add(composante1);
        systeme.liste_composante.add(composante2);
    }

    @Test
    public void testRechercherComposante() {
        // on cherche une composante dans la liste
        Composante result1 = systeme.rechercherComposante("Roue");
        assertNotNull(result1, "Erreur : La composante 'Roue' devrait être trouvée.");
        assertEquals("Roue", result1.getNom(), "Erreur : Le nom de la composante trouvée devrait être" +
                " 'Roue'.");
        // vs on cherche une composante qui n'est pas dans la liste
        Composante result2 = systeme.rechercherComposante("ComposanteInexistante");
        assertNull(result2, "Erreur : Aucune composante ne devrait être trouvée pour 'ComposanteInexistante'.");
    }


}
