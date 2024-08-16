package com.example.robotix.Test;

import com.example.robotix.Composante;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComposanteTest {

    Composante cpu;

    @BeforeEach
    public void setUp() {
        cpu = new Composante("CPU", "interne", "obligatoire", 4999);
    }

    @Test
    public void testGetComposanteNom() {
        assertEquals("Nom de la composante: CPU", "Nom de la composante: " + cpu.getNom());
    }
}

