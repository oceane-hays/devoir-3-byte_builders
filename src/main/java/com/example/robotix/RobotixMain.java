package com.example.robotix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * La classe {@code RobotixMain} est le point d'entrée principal de l'application Robotix.
 * Elle gère les inscriptions des utilisateurs et des fournisseurs, ainsi que la connexion des utilisateurs.
 * Elle affiche le menu principal et traite les choix des utilisateurs en fonction de leurs actions.
 */
public class RobotixMain {

    /**
     * Point d'entrée principal de l'application.
     *
     * @param args Arguments de ligne de commande (non utilisés ici).
     */
    public static void run(String[] args) {

        // Initialisation des collections
        HashMap<String, Utilisateur> liste_utilisateur = new HashMap<>(); // < identifiant , utilisateur >
        HashMap<String, Fournisseur> liste_fournisseur = new HashMap<>(); // < nom_compagnie , fournisseur >
        HashMap<Integer, Activite> liste_activites = new HashMap<>();
        HashMap<Integer, Interet> liste_interet = new HashMap<>();

        // Prototype des intérêts
        liste_interet.put(1, new Interet(1, "Sportif"));
        liste_interet.put(2, new Interet(2, "Musique"));
        liste_interet.put(3, new Interet(3, "Cuisine"));
        liste_interet.put(4, new Interet(4, "Lecture"));
        liste_interet.put(5, new Interet(5, "Voyage"));
        liste_interet.put(6, new Interet(6, "Photographie"));
        liste_interet.put(7, new Interet(7, "Cinéma"));
        liste_interet.put(8, new Interet(8, "Technologie"));
        liste_interet.put(9, new Interet(9, "Jeux vidéo"));
        liste_interet.put(10, new Interet(10, "Peinture"));

        // Prototype des activités
        liste_activites.put(1, new Activite("Course à pied", "Non débutée", "01-07-2024", "", 50));
        liste_activites.put(2, new Activite("Lecture", "Terminé", "30-06-2024", "02-07-2024", 30));
        liste_activites.put(3, new Activite("Photographie", "En cours", "15-07-2024", "", 40));
        liste_activites.put(4, new Activite("Cuisine", "Terminé", "01-06-2024", "10-06-2024", 20));
        liste_activites.put(5, new Activite("Voyage", "En cours", "20-07-2024", "", 60));

        // Prototype des composantes
        Composante cpu = new Composante("CPU", "interne", "obligatoire", 4999);
        Composante camera = new Composante("camera", "externe", "optionel", 399);
        Composante haut_parleurs = new Composante("haut-parleurs", "externe", "optionel", 299);

        // Prototype des utilisateurs
        Utilisateur john = new Utilisateur("johndoe", "Doe", "John", "securepassword",
                "johndoe@example.com", "+1234567890", "Robotix Inc.", true,
                Commande.creerListeInterets(liste_interet, 1, 3, 4),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 1, 2, 3));

        // Autres utilisateurs
        // (Code similaire pour les autres utilisateurs...)

        // Prototype des fournisseurs
        Fournisseur fournisseur1 = new Fournisseur("Hello World", "password1", "2035 rue de la Cornemuse",
                "email1@example.com", "+1234567890", 100);
        fournisseur1.composantes.put(cpu, 70);

        // Autres fournisseurs
        // (Code similaire pour les autres fournisseurs...)

        // Liste des composantes
        ArrayList<Composante> liste_composante = new ArrayList<>();
        liste_composante.add(cpu);
        liste_composante.add(camera);
        liste_composante.add(haut_parleurs);

        // Création et initialisation du système
        Systeme systeme = new Systeme(liste_utilisateur, liste_fournisseur, liste_activites,
                liste_interet, liste_composante);

        // Ajout des utilisateurs et des fournisseurs au système
        systeme.ajouterUtilisateur(john.getIdentifiant(), john);
        // (Code similaire pour les autres utilisateurs...)
        systeme.ajouterFournisseur(fournisseur1.getNomCompagnie(), fournisseur1);
        // (Code similaire pour les autres fournisseurs...)

        // Lecture des utilisateurs depuis un fichier JSON
        ArrayList<Utilisateur> utilisateurs = Commande.LireUtilisateurs();
        systeme.liste_utilisateur = Commande.listeVersMap(utilisateurs);

        // Affichage du message de bienvenue
        System.out.println("-- BIENVENUE SUR ROBOTIX --");

        // Boucle principale du menu
        while (true) {
            Scanner scanner = new Scanner(System.in);

            // Affichage du menu principal
            System.out.println("Menu principal:");
            System.out.println("1. Inscription en tant qu'utilisateur");
            System.out.println("2. Inscription en tant que fournisseur");
            System.out.println("3. Connexion sur Robotix");
            System.out.println("0. Quitter");

            System.out.print("Choisissez une option: ");

            // Validation du choix
            int entrer = Validation.validerChoix(3);

            switch (entrer) {
                // Inscription en tant qu'utilisateur
                case 1 -> {
                    System.out.println("-- FORMULAIRE D'INSCRIPTION UTILISATEUR --");

                    System.out.println("entrez votre nom : ");
                    String nom = scanner.nextLine();

                    System.out.println("entrez votre prenom : ");
                    String prenom = scanner.nextLine();

                    System.out.println("créer un mot-de-passe sécuritaire pour votre compte : ");
                    String mot_de_passe = Validation.validerMotDePasse(scanner.nextLine());

                    String pseudo = Commande.ajouterPseudoUnique(scanner, liste_utilisateur);

                    String email = Commande.ajouterEmailUnique(scanner, liste_utilisateur);

                    System.out.println("entrer votre numéro de téléphone : ");
                    String telephone = Validation.validerNumero(scanner.nextLine());

                    systeme.afficherInterets();

                    ArrayList<Interet> interet_utilisateur = Commande.choisirInteret(scanner, systeme.getListeInteret());

                    ArrayList<Utilisateur> followers = new ArrayList<>();
                    ArrayList<Activite> activites = new ArrayList<>();

                    System.out.println("Souhaitez-vous acceptez les notifications par email ? ");
                    System.out.println("0. Non");
                    System.out.println("1. Oui");

                    boolean notification = Validation.validerChoix(1) == 1;

                    System.out.println("Souhaitez-vous ajouter le nom de votre compagnie ? ");
                    System.out.println("0. Non");
                    System.out.println("1. Oui");

                    int choixCompagnie = Validation.validerChoix(1);
                    switch (choixCompagnie) {
                        case 0:
                            Utilisateur user = new Utilisateur(pseudo, nom, prenom, mot_de_passe, email,
                                    telephone, "aucune", notification, interet_utilisateur, followers, activites);
                            System.out.println("enregistrement...");
                            systeme.ajouterUtilisateur(pseudo, user);
                            System.out.println("Votre inscription a été prise en compte. Vous recevrez un mail de confirmation sous 24h !");
                            Commande.ecrireUserJson(user);
                            break;

                        case 1:
                            System.out.println("Entrez le nom de la compagnie : ");
                            scanner.nextLine();
                            String nom_compagnie = scanner.nextLine();

                            Utilisateur user_compagnie = new Utilisateur(pseudo, nom, prenom, mot_de_passe, email,
                                    telephone, nom_compagnie, notification, interet_utilisateur, followers, activites);
                            Commande.ecrireUserJson(user_compagnie);
                            System.out.println("enregistrement...");
                            systeme.ajouterUtilisateur(pseudo, user_compagnie);
                            System.out.println("Votre inscription a été prise en compte. Vous recevrez un mail de confirmation sous 24h !");
                            break;
                    }
                }

                // Inscription en tant que fournisseur
                case 2 -> {
                    System.out.println("-- FORMULAIRE D'INSCRIPTION FOURNISSEUR --");
                    String nom_compagnie = Commande.ajouterNomCompagnieUnique(scanner, liste_fournisseur);

                    System.out.println("créer un mot-de-passe sécuritaire pour votre compte : ");
                    String mot_de_passe_fournisseur = Validation.validerMotDePasse(scanner.nextLine());

                    System.out.println("entrez votre adresse : ");
                    String adresse = scanner.nextLine();

                    System.out.println("entrez votre adresse courriel : ");
                    String email_fournisseur = Validation.validerEmail(scanner.nextLine());

                    System.out.println("entrer votre numéro de téléphone : ");
                    String telephone_fournisseur = Validation.validerNumero(scanner.nextLine());

                    System.out.println("entrez la capacité maximale : ");
                    int capacite_maximale = scanner.nextInt();

                    Fournisseur fournisseur = new Fournisseur(nom_compagnie, mot_de_passe_fournisseur, adresse,
                            email_fournisseur, telephone_fournisseur, capacite_maximale);

                    systeme.ajouterFournisseur(nom_compagnie, fournisseur);

                    System.out.println("Votre inscription a été prise en compte. Vous recevrez un mail de confirmation sous 24h !");
                }

                // Connexion
                case 3 -> {
                    System.out.println("-- CONNEXION --");

                    System.out.println("identifiant : ");
                    String identifiant = scanner.nextLine();

                    System.out.println("mot de passe : ");
                    String passe_connexion = scanner.nextLine();

                    if (!systeme.estCorrect(identifiant, passe_connexion, scanner)) {
                        System.out.println("Connexion échouée...");
                    }
                }

                // Quitter l'application
                case 0 -> {
                    System.out.println("Merci de votre visite sur Robotix.");
                    return;
                }
            }
        }
    }
}
