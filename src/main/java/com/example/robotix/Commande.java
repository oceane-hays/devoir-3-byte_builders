package com.example.robotix;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Classe Commande contenant diverses méthodes pour gérer les utilisateurs, les fournisseurs,
 * les intérêts et les fichiers CSV.
 */
public class Commande {

    /**
     * Ajoute un pseudo unique à la liste des utilisateurs.
     *
     * @param scanner Le scanner pour lire les entrées utilisateur.
     * @param liste_utilisateur La liste des utilisateurs existants.
     * @return Le pseudo unique ajouté.
     */
    public static String ajouterPseudoUnique(Scanner scanner, HashMap<String, Utilisateur> liste_utilisateur) {
        boolean cherchePseudo = true;
        System.out.println("entrez votre pseudo : ");
        String pseudo = "";

        while (cherchePseudo) {
            pseudo = Validation.validerPseudo(scanner.nextLine());
            boolean notInList = true;

            for (Map.Entry<String, Utilisateur> pseud : liste_utilisateur.entrySet()) {
                if (pseud.getKey().equals(pseudo)) {
                    notInList = false;
                    break;
                }
            }

            if (notInList) {
                cherchePseudo = false;
                System.out.println("Pseudo ajouté avec succès !");
            } else {
                System.out.println("Votre pseudo existe déjà, veuillez en entrer un autre : ");
            }
        }
        return pseudo;
    }

    /**
     * Ajoute une adresse email unique à la liste des utilisateurs.
     *
     * @param scanner Le scanner pour lire les entrées utilisateur.
     * @param liste_utilisateur La liste des utilisateurs existants.
     * @return L'email unique ajouté.
     */
    public static String ajouterEmailUnique(Scanner scanner, HashMap<String, Utilisateur> liste_utilisateur) {
        boolean chercheEmail = true;
        System.out.println("entrez votre adresse email : ");
        String email = "";

        while (chercheEmail) {
            email = Validation.validerEmail(scanner.nextLine());
            boolean notInList = true;

            for (Map.Entry<String, Utilisateur> mail : liste_utilisateur.entrySet()) {
                if (mail.getKey().equals(email)) {
                    notInList = false;
                    break;
                }
            }

            if (notInList) {
                chercheEmail = false;
                System.out.println("Email ajouté avec succès !");
            } else {
                System.out.println("Cette adresse email existe déjà dans nos services, " +
                        "veuillez en entrer une autre ou vous connecter : ");
            }
        }
        return email;
    }

    /**
     * Permet à un utilisateur de choisir ses intérêts parmi une liste.
     *
     * @param scanner Le scanner pour lire les entrées utilisateur.
     * @param liste_interet La liste des intérêts disponibles.
     * @return La liste des intérêts choisis par l'utilisateur.
     */
    public static ArrayList<Interet> choisirInteret(Scanner scanner, HashMap<Integer, Interet> liste_interet) {
        ArrayList<Interet> utilisateur_interet = new ArrayList<>();
        boolean encours = true;
        int nbInteretsChoisis = 0;
        final int maximum = 10; // Limite de 10 intérêts

        while (encours) {
            if (nbInteretsChoisis >= maximum) {
                System.out.println("Vous avez atteint la limite de 10 intérêts.");
                break;
            }

            System.out.println("Quels sont vos intérêts ? (0 pour arrêter) : ");
            int choixInteret = scanner.nextInt();

            if (choixInteret == 0) {
                encours = false;
            } else {
                Interet interet = liste_interet.get(choixInteret);
                if (interet != null && !utilisateur_interet.contains(interet)) {
                    utilisateur_interet.add(interet);
                    nbInteretsChoisis++;
                } else {
                    System.out.println("Intérêt inconnu ou déjà choisi. Veuillez réessayer.");
                }
            }
        }
        return utilisateur_interet;
    }

    /**
     * Ajoute un nom de compagnie unique à la liste des fournisseurs.
     *
     * @param scanner Le scanner pour lire les entrées utilisateur.
     * @param liste_founisseur La liste des fournisseurs existants.
     * @return Le nom de compagnie unique ajouté.
     */
    public static String ajouterNomCompagnieUnique(Scanner scanner, HashMap<String, Fournisseur> liste_founisseur) {
        boolean cherchePseudo = true;
        System.out.println("Entrez le nom de la compagnie : ");
        String nom_compagnie = "";

        while (cherchePseudo) {
            nom_compagnie = scanner.nextLine();
            boolean notInList = true;

            for (Map.Entry<String, Fournisseur> nom : liste_founisseur.entrySet()) {
                if (nom.getKey().equals(nom_compagnie)) {
                    notInList = false;
                    break;
                }
            }

            if (notInList) {
                cherchePseudo = false;
                System.out.println("Bonjour " + nom_compagnie);
            } else {
                System.out.println("Cette compagnie existe déjà, veuillez en entrer un autre : ");
            }
        }
        return nom_compagnie;
    }

    /**
     * Crée une liste d'intérêts basée sur les numéros fournis.
     *
     * @param liste_interet La liste des intérêts disponibles.
     * @param numeros Les numéros des intérêts à ajouter à la liste.
     * @return La liste des intérêts choisis.
     */
    public static ArrayList<Interet> creerListeInterets(HashMap<Integer, Interet> liste_interet, int... numeros) {
        ArrayList<Interet> listeInterets = new ArrayList<>();
        for (int num : numeros) {
            if (liste_interet.containsKey(num)) {
                listeInterets.add(liste_interet.get(num));
            }
        }
        return listeInterets;
    }

    /**
     * Crée une liste de followers basée sur les identifiants d'utilisateurs fournis.
     *
     * @param liste_utilisateur La liste des utilisateurs existants.
     * @param utilisateur Les identifiants des utilisateurs à ajouter à la liste des followers.
     * @return La liste des followers choisis.
     */
    public static ArrayList<Utilisateur> creerListeFollowers(HashMap<String, Utilisateur> liste_utilisateur, String... utilisateur) {
        ArrayList<Utilisateur> liste_followers = new ArrayList<>();
        for (String util : utilisateur) {
            if (liste_utilisateur.containsKey(util)) {
                liste_followers.add(liste_utilisateur.get(util));
            }
        }
        return liste_followers;
    }

    /**
     * Crée une liste d'activités basée sur les numéros fournis.
     *
     * @param liste_activites La liste des activités disponibles.
     * @param activite Les numéros des activités à ajouter à la liste.
     * @return La liste des activités choisies.
     */
    public static ArrayList<Activite> creerListeActivite(HashMap<Integer, Activite> liste_activites, int... activite) {
        ArrayList<Activite> liste_activite = new ArrayList<>();
        for (int num : activite) {
            if (liste_activites.containsKey(num)) {
                liste_activite.add(liste_activites.get(num));
            }
        }
        return liste_activite;
    }

    /**
     * Traite un fichier CSV.
     *
     * @param pathName Le chemin du fichier CSV à traiter.
     * @throws IOException Si une erreur d'entrée/sortie se produit.
     * @throws CsvValidationException Si une erreur de validation CSV se produit.
     */
    public static void traiterFichier(String pathName) throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new FileReader(pathName));
        String[] lines;
        // Code pour traiter les lignes du fichier CSV
    }

    /**
     * Met à jour les informations d'un utilisateur dans le fichier JSON.
     *
     * @param utilisateur L'utilisateur à mettre à jour.
     */
    public static void updateUtilisateur(Utilisateur utilisateur) {
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<Utilisateur> utilisateurs = LireUtilisateurs();
        boolean updated = false;

        // Parcourir la liste des utilisateurs pour trouver l'utilisateur à mettre à jour
        for (int i = 0; i < utilisateurs.size(); i++) {
            Utilisateur current = utilisateurs.get(i);
            if (current.getIdentifiant().equals(utilisateur.getIdentifiant())) {
                // Mettre à jour les informations de l'utilisateur
                utilisateurs.set(i, utilisateur);
                updated = true;
                break;
            }
        }

        if (updated) {
            try {
                // Réécrire la liste mise à jour dans le fichier JSON
                objectMapper.writeValue(new File("utilisateurs.json"), utilisateurs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Utilisateur not found in utilisateurs.json");
        }
    }

    /**
     * Lit la liste des utilisateurs à partir du fichier JSON.
     *
     * @return La liste des utilisateurs.
     */
    public static ArrayList<Utilisateur> LireUtilisateurs() {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

        try {
            // Deserialize the JSON file to a list of Utilisateur objects
            utilisateurs = (ArrayList<Utilisateur>) objectMapper.readValue(new File("utilisateurs.json"), new TypeReference<List<Utilisateur>>() {});
            System.out.println("List of Utilisateur objects deserialized from utilisateurs.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return utilisateurs;
    }

    /**
     * Convertit une liste d'utilisateurs en une HashMap.
     *
     * @param utilisateurs La liste des utilisateurs.
     * @return La HashMap des utilisateurs.
     */
    public static HashMap<String, Utilisateur> listeVersMap(ArrayList<Utilisateur> utilisateurs) {
        HashMap<String, Utilisateur> utilisateurMap = new HashMap<>();

        for (Utilisateur utilisateur : utilisateurs) {
            utilisateurMap.put(utilisateur.getIdentifiant(), utilisateur);
        }

        return utilisateurMap;
    }

    /**
     * Écrit un utilisateur dans le fichier JSON.
     *
     * @param utilisateur L'utilisateur à écrire.
     */
    public static void ecrireUserJson(Utilisateur utilisateur) {
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<Utilisateur> utilisateurs = LireUtilisateurs();
        utilisateurs.add(utilisateur);

        try {
            // Serialize the object to a JSON file
            objectMapper.writeValue(new File("utilisateurs.json"), utilisateurs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
