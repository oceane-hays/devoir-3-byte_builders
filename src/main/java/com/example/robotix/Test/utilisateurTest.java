package com.example.robotix.Test;

import com.example.robotix.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
public class UtilisateurTest {

    @Test
    public void testCreationUtilisateur() {
        Utilisateur utilisateur = new Utilisateur("JohnDoe", "password123", "John", "Doe", "john.doe@example.com");
        assertNotNull(utilisateur);
        assertEquals("JohnDoe", utilisateur.getUsername());
        assertEquals("password123", utilisateur.getPassword());
        assertEquals("John", utilisateur.getFirstName());
        assertEquals("Doe", utilisateur.getLastName());
        assertEquals("john.doe@example.com", utilisateur.getEmail());
    }

    @Test
    public void testSettersAndGetters() {
        Utilisateur utilisateur = new Utilisateur("JohnDoe", "password123", "John", "Doe", "john.doe@example.com");

        utilisateur.setUsername("JaneDoe");
        assertEquals("JaneDoe", utilisateur.getUsername());

        utilisateur.setPassword("newpassword");
        assertEquals("newpassword", utilisateur.getPassword());

        utilisateur.setFirstName("Jane");
        assertEquals("Jane", utilisateur.getFirstName());

        utilisateur.setLastName("Smith");
        assertEquals("Smith", utilisateur.getLastName());

        utilisateur.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", utilisateur.getEmail());
    }

    @Test
    public void testEquals() {
        Utilisateur utilisateur1 = new Utilisateur("JohnDoe", "password123", "John", "Doe", "john.doe@example.com");
        Utilisateur utilisateur2 = new Utilisateur("JohnDoe", "password123", "John", "Doe", "john.doe@example.com");
        Utilisateur utilisateur3 = new Utilisateur("JaneDoe", "password123", "Jane", "Doe", "jane.doe@example.com");

        assertEquals(utilisateur1, utilisateur2);
        assertNotEquals(utilisateur1, utilisateur3);
    }

    @Test
    public void testToString() {
        Utilisateur utilisateur = new Utilisateur("JohnDoe", "password123", "John", "Doe", "john.doe@example.com");
        String expected = "Utilisateur{username='JohnDoe', firstName='John', lastName='Doe', email='john.doe@example.com'}";
        assertEquals(expected, utilisateur.toString());
    }
}
