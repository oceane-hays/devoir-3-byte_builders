package com.example.robotix.Test;

import com.example.robotix.Composante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComposanteTest {

    private Composante composante;

    @BeforeEach
    public void setUp() {
        composante = new Composante("Moteur", "Mécanique", "Moteur haute performance", 100);
    }

    @Test
    public void testAppliquerReduction() {
        composante.appliquerReduction(20);
        assertEquals(80, composante.getPrix());

        composante.appliquerReduction(50);
        assertEquals(40, composante.getPrix());
    }

    @Test
    public void testAppliquerReductionInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            composante.appliquerReduction(-10);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            composante.appliquerReduction(110);
        });
    }

    @Test
    public void testFormaterDescription() {
        String descriptionFormatee = composante.formaterDescription();
        assertEquals("Moteur (Mécanique): Moteur haute performance", descriptionFormatee);
    }
}

