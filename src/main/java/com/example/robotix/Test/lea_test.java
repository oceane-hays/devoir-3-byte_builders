import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ActiviteTest {
    @Test
    public void testAjouterParticipant() {
        Activite activite = new Activite("Yoga");
        activite.ajouterParticipant("Alice");
        assertEquals(1, activite.getParticipants().size());
        assertTrue(activite.getParticipants().contains("Alice"));
    }

    @Test
    public void testSupprimerParticipant() {
        Activite activite = new Activite("Yoga");
        activite.ajouterParticipant("Alice");
        activite.supprimerParticipant("Alice");
        assertFalse(activite.getParticipants().contains("Alice"));
    }
}

public class AfficherMetriquesFlotteTest {
    @Test
    public void testGetTotalRobots() {
        GestionnaireFlotte gestionnaire = new GestionnaireFlotte();
        AfficherMetriquesFlotte afficheur = new AfficherMetriquesFlotte(gestionnaire);
        gestionnaire.ajouterRobot(new Robot("R1"));
        gestionnaire.ajouterRobot(new Robot("R2"));
        assertEquals(2, afficheur.getTotalRobots());
    }

    @Test
    public void testGetListeRobots() {
        GestionnaireFlotte gestionnaire = new GestionnaireFlotte();
        AfficherMetriquesFlotte afficheur = new AfficherMetriquesFlotte(gestionnaire);
        gestionnaire.ajouterRobot(new Robot("R1"));
        gestionnaire.ajouterRobot(new Robot("R2"));
        assertEquals(List.of("R1", "R2"), afficheur.getListeRobots());
    }
}
public class ComposanteTest {
    @Test
    public void testGetComposanteNom() {
        Composante composante = new Composante("001", "Composant A");
        assertEquals("Nom de la composante: Composant A", composante.getComposanteNom());
    }
}
