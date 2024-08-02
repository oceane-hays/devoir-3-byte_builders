import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Assurez-vous d'importer votre classe Robot et les autres nécessaires

public class AfficherMetriquesFlotteTest {
    private AfficherMetriquesFlotte afficherMetriquesFlotte;

    @BeforeEach
    public void setUp() {
        afficherMetriquesFlotte = new AfficherMetriquesFlotte(10, 75, 60);
    }

    @Test
    public void testAfficherMetriques() {
        // Créez des robots pour le test
        List<Robot> robots = new ArrayList<>();
        robots.add(new Robot("001","Bob:D", "Hybide",80, 20));
        robots.add(new Robot("002", "Gerard","Mobile", 45, 30));

        // Capturez la sortie de la console
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Appelez la méthode à tester
        afficherMetriquesFlotte.afficherMetriques(robots);

        // Restaurez la sortie de la console
        System.setOut(originalOut);

        // Vérifiez la sortie capturée
        String expectedOutput =
                "Robot: Bob:D\r\n" +
                "Niveau de batterie: 80\r\n" +
                "Consommation CPU: 20\r\n" +
                "-----------------------------------\r\n" +
                "Robot: Gerard\r\n" +
                "Niveau de batterie: 45\r\n" +
                "Consommation CPU: 30\r\n" +
                "-----------------------------------\r\n";
         assertEquals(expectedOutput, outputStream.toString(), "La sortie affichée ne correspond pas à ce" +
                " qui est attendu.");

    }
}