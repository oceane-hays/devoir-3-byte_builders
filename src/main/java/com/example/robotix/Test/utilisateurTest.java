import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class UtilisateurTest {

    @Test
    public void testCreationUtilisateur() {
        ArrayList<Interet> interets = new ArrayList<>();
        ArrayList<Utilisateur> followers = new ArrayList<>();
        ArrayList<Activite> activites = new ArrayList<>();
        
        Utilisateur utilisateur = new Utilisateur("JohnDoe", "John", "Doe", "password123", "john.doe@example.com", "1234567890", "CompanyX", true, interets, followers, activites);
        assertNotNull(utilisateur);
        assertEquals("JohnDoe", utilisateur.getIdentifiant());
        assertEquals("John", utilisateur.getNom());
        assertEquals("Doe", utilisateur.getPrenom());
        assertEquals("password123", utilisateur.getMotDePasse());
        assertEquals("john.doe@example.com", utilisateur.getCourriel());
        assertEquals("1234567890", utilisateur.getTelephone());
        assertEquals("CompanyX", utilisateur.getCompagnie());
        assertTrue(utilisateur.isEmailNotificationsEnabled());
        assertEquals(interets, utilisateur.getInteret());
        assertEquals(followers, utilisateur.getFollowers());
        assertEquals(activites, utilisateur.getActivite());
    }

    @Test
    public void testEquals() {
        ArrayList<Interet> interets = new ArrayList<>();
        ArrayList<Utilisateur> followers = new ArrayList<>();
        ArrayList<Activite> activites = new ArrayList<>();

        Utilisateur utilisateur1 = new Utilisateur("JohnDoe", "John", "Doe", "password123", "john.doe@example.com", "1234567890", "CompanyX", true, interets, followers, activites);
        Utilisateur utilisateur2 = new Utilisateur("JohnDoe", "John", "Doe", "password123", "john.doe@example.com", "1234567890", "CompanyX", true, interets, followers, activites);
        Utilisateur utilisateur3 = new Utilisateur("JaneDoe", "Jane", "Doe", "password123", "jane.doe@example.com", "1234567890", "CompanyY", true, interets, followers, activites);

        assertEquals(utilisateur1, utilisateur2);
        assertNotEquals(utilisateur1, utilisateur3);
    }

    @Test
    public void testToString() {
        ArrayList<Interet> interets = new ArrayList<>();
        ArrayList<Utilisateur> followers = new ArrayList<>();
        ArrayList<Activite> activites = new ArrayList<>();

        Utilisateur utilisateur = new Utilisateur("JohnDoe", "John", "Doe", "password123", "john.doe@example.com", "1234567890", "CompanyX", true, interets, followers, activites);
        String expected = "identifiant : JohnDoe\nnom : John\nprenom : Doe\ncourriel : john.doe@example.com\ntelephone : 1234567890\ncompagnie : CompanyX\ninterets : []\nfollowers : \nactivites : []\n";
        assertEquals(expected, utilisateur.toString());
    }

    @Test
    public void testToStringUtilisateur() {
        ArrayList<Interet> interets = new ArrayList<>();
        ArrayList<Utilisateur> followers = new ArrayList<>();
        ArrayList<Activite> activites = new ArrayList<>();

        Utilisateur utilisateur = new Utilisateur("JohnDoe", "John", "Doe", "password123", "john.doe@example.com", "1234567890", "CompanyX", true, interets, followers, activites);
        String expected = "identifiant : JohnDoe\nnom : John\nprenom : Doe\n";
        assertEquals(expected, utilisateur.toStringUtilisateur());
    }

    @Test
    public void testToStringInteret() {
        ArrayList<Interet> interets = new ArrayList<>();
        ArrayList<Utilisateur> followers = new ArrayList<>();
        ArrayList<Activite> activites = new ArrayList<>();

        Utilisateur utilisateur = new Utilisateur("JohnDoe", "John", "Doe", "password123", "john.doe@example.com", "1234567890", "CompanyX", true, interets, followers, activites);
        String expected = "interets : []";
        assertEquals(expected, utilisateur.toStringInteret());
    }

    @Test
    public void testToStringActivite() {
        ArrayList<Interet> interets = new ArrayList<>();
        ArrayList<Utilisateur> followers = new ArrayList<>();
        ArrayList<Activite> activites = new ArrayList<>();

        Utilisateur utilisateur = new Utilisateur("JohnDoe", "John", "Doe", "password123", "john.doe@example.com", "1234567890", "CompanyX", true, interets, followers, activites);
        String expected = "activite : []\n";
        assertEquals(expected, utilisateur.toStringActivite());
    }

    @Test
    public void testToStringFollowers() {
        ArrayList<Interet> interets = new ArrayList<>();
        ArrayList<Utilisateur> followers = new ArrayList<>();
        ArrayList<Activite> activites = new ArrayList<>();

        Utilisateur utilisateur = new Utilisateur("JohnDoe", "John", "Doe", "password123", "john.doe@example.com", "1234567890", "CompanyX", true, interets, followers, activites);
        String expected = "utilisateur : []\n";
        assertEquals(expected, utilisateur.toStringFollowers());
    }

    @Test
    public void testEmailNotificationsEnabled() {
        ArrayList<Interet> interets = new ArrayList<>();
        ArrayList<Utilisateur> followers = new ArrayList<>();
        ArrayList<Activite> activites = new ArrayList<>();

        Utilisateur utilisateur = new Utilisateur("JohnDoe", "John", "Doe", "password123", "john.doe@example.com", "1234567890", "CompanyX", true, interets, followers, activites);
        assertTrue(utilisateur.isEmailNotificationsEnabled());
    }
}
