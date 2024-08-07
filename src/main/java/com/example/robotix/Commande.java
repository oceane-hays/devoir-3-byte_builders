package com.example.robotix;

import com.fasterxml.jackson.core.type.TypeReference;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Commande {



    // ------------------------------------------------------------------------------- S'INSCRIRE EN TANT QU'UTILISATEUR
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


    public static ArrayList<Interet> choisirInteret(Scanner scanner, HashMap<Integer, Interet> liste_interet) {
        ArrayList<Interet> utilisateur_interet = new ArrayList<Interet>();
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

    // ------------------------------------------------------------------------------ S'INSCRIRE EN TANT QUE FOURNISSEUR
    public static String ajouterNomCompagnieUnique(Scanner scanner,
                                                 HashMap<String, Fournisseur> liste_founisseur) {
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



    // ------------------------------------------------------------------------------------------- CREER LISTE D'INTERET
    public static ArrayList<Interet> creerListeInterets(HashMap<Integer, Interet> liste_interet, int... numeros) {
        ArrayList<Interet> listeInterets = new ArrayList<Interet>();
        for (int num : numeros) {
            if (liste_interet.containsKey(num)) {
                listeInterets.add(liste_interet.get(num));
            }
        }
        return listeInterets;
    }


    public static ArrayList<Utilisateur> creerListeFollowers(HashMap<String, Utilisateur> liste_utilisateur, String... utilisateur) {
        ArrayList<Utilisateur> liste_followers = new ArrayList<Utilisateur>();
        for (String util : utilisateur) {
            if (liste_utilisateur.containsKey(util)) {
                liste_followers.add(liste_utilisateur.get(util));
            }
        }
        return liste_followers;
    }

    public static ArrayList<Activite> creerListeActivite(HashMap<Integer, Activite> liste_activites, int... activite) {
        ArrayList<Activite> liste_activite = new ArrayList<Activite>();
        for (int num : activite) {
            if (liste_activites.containsKey(num)) {
                liste_activite.add(liste_activites.get(num));
            }
        }
        return liste_activite;
    }


    // -------------------------------------------------------------------------------------------- COMMANDE FICHIER CSV
    public static void traiterFichier (String pathName) throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new FileReader(pathName)) ;
        String[] lines;
        /*while ((lines = csvReader.readNext()) != null) {

            for (int i = 0; i < lines.length; i++) {

            }
        }*/
    }

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

    public static void updateFournisseur(Fournisseur utilisateur) {
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<Fournisseur> utilisateurs = LireFournisseur();
        boolean updated = false;

        // Parcourir la liste des utilisateurs pour trouver l'utilisateur à mettre à jour
        for (int i = 0; i < utilisateurs.size(); i++) {
            Fournisseur current = utilisateurs.get(i);
            if (current.getNomCompagnie().equals(utilisateur.getNomCompagnie())) {
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


    public static ArrayList<Fournisseur> LireFournisseur() {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Fournisseur> utilisateurs = new ArrayList<>();

        try {
            // Deserialize the JSON file to a list of Utilisateur objects
            utilisateurs = (ArrayList<Fournisseur>) objectMapper.readValue(new File("fournisseurs.json"), new TypeReference<List<Fournisseur>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return utilisateurs;
    }

    public static void ecrireFournisseurJson(Fournisseur utilisateur){

        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<Fournisseur> utilisateurs = LireFournisseur();
        utilisateurs.add(utilisateur);

        try {
            // Serialize the object to a JSON file
            objectMapper.writeValue(new File("fournisseurs.json"), utilisateurs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Utilisateur> LireUtilisateurs() {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

        try {
            // Deserialize the JSON file to a list of Utilisateur objects
            utilisateurs = (ArrayList<Utilisateur>) objectMapper.readValue(new File("utilisateurs.json"), new TypeReference<List<Utilisateur>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return utilisateurs;
    }
    public static HashMap<String, Utilisateur> listeVersMap(ArrayList<Utilisateur> utilisateurs) {
        HashMap<String, Utilisateur> utilisateurMap = new HashMap<>();

        for (Utilisateur utilisateur : utilisateurs) {
            utilisateurMap.put(utilisateur.getIdentifiant(), utilisateur);
        }

        return utilisateurMap;
    }
    public static HashMap<String, Fournisseur> listeVersMap2(ArrayList<Fournisseur> utilisateurs) {
        HashMap<String, Fournisseur> utilisateurMap = new HashMap<>();

        for (Fournisseur utilisateur : utilisateurs) {
            utilisateurMap.put(utilisateur.getNomCompagnie(), utilisateur);
        }

        return utilisateurMap;
    }

    public static void ecrireUserJson(Utilisateur utilisateur){

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


