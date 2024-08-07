package com.example.robotix.Test;

import com.example.robotix.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
public class CommandeTest {

    @Test
    public void testCreationCommande() {
        Commande commande = new Commande(1, "Client001", "ProduitA", 10);
        assertNotNull(commande);
        assertEquals(1, commande.getId());
        assertEquals("Client001", commande.getClient());
        assertEquals("ProduitA", commande.getProduit());
        assertEquals(10, commande.getQuantite());
    }

    @Test
    public void testEquals() {
        Commande commande1 = new Commande(1, "Client001", "ProduitA", 10);
        Commande commande2 = new Commande(1, "Client001", "ProduitA", 10);
        Commande commande3 = new Commande(2, "Client002", "ProduitB", 5);

        assertEquals(commande1, commande2);
        assertNotEquals(commande1, commande3);
    }

    @Test
    public void testToString() {
        Commande commande = new Commande(1, "Client001", "ProduitA", 10);
        String expected = "Commande{id=1, client='Client001', produit='ProduitA', quantite=10}";
        assertEquals(expected, commande.toString());
    }
}
