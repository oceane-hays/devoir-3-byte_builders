package com.example.robotix.Test;

import com.example.robotix.Activite;
import com.example.robotix.Utilisateur;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ActiviteTest {
    Utilisateur john = new Utilisateur("johndoe", "Doe", "John", "securepassword",
            "johndoe@example.com", "+1234567890", "Robotix Inc.", true,
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>());

    @Test
    public void testAjouterActivite() {
        Activite newActivite = new Activite("Yoga","en cours","27-02-2024", "non renseigné",48);
        john.activite.add(newActivite);
        assertEquals(1, john.getActivite().size());
    }

    @Test
    public void testSupprimerActivite() {
        Activite newActivite = new Activite("Yoga","en cours","27-02-2024", "non renseigné",48);
        john.activite.add(newActivite);
        john.activite.remove(newActivite);
        assertFalse(john.activite.contains(newActivite));
    }
}



