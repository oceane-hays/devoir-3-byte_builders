package com.example.robotix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RobotixMain {
    public static void run(String[] args) {

        HashMap<String, Utilisateur> liste_utilisateur = new HashMap<String, Utilisateur>(); // < identifiant , utilisateur >
        HashMap<String, Fournisseur> liste_fournisseur = new HashMap<String, Fournisseur>(); // < nom_compagnie , fournisseur >
        HashMap<Integer, Activite> liste_activites = new HashMap<Integer, Activite>();
        HashMap<Integer, Interet> liste_interet = new HashMap<Integer, Interet>();

        // --------------------------------------------------------------------------------------------------- PROTOTYPE
        // -- INTERET --
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

        // -- ACTIVITE
        liste_activites.put(1, new Activite("Course à pied", "Non débutée", "01-07-2024", "", 50));
        liste_activites.put(2, new Activite("Lecture", "Terminé", "30-06-2024", "02-07-2024", 30));
        liste_activites.put(3, new Activite("Photographie", "En cours", "15-07-2024", "", 40));
        liste_activites.put(4, new Activite("Cuisine", "Terminé", "01-06-2024", "10-06-2024", 20));
        liste_activites.put(5, new Activite("Voyage", "En cours", "20-07-2024", "", 60));


        // -- COMPOSANTES
        Composante cpu = new Composante("CPU", "interne", "obligatoire", 4999);
        Composante camera = new Composante("camera", "externe", "optionel", 399);
        Composante haut_parleurs = new Composante("haut-parleurs", "externe", "optionel", 299);

        Utilisateur john = new Utilisateur("johndoe", "Doe", "John", "securepassword",
                "johndoe@example.com", "+1234567890", "Robotix Inc.", true,
                Commande.creerListeInterets(liste_interet, 1,3,4),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 1,2,3));
        // -- UTILISATEURS --

        Utilisateur jane = new Utilisateur("jane_smith", "Smith", "Jane", "password2",
                "jane.smith@example.com", "+1987654321", "non renseigné", true,
                Commande.creerListeInterets(liste_interet, 4, 5, 6),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 2,4));

        Utilisateur mike = new Utilisateur("mike_jones", "Jones", "Mike", "password3",
                "mike.jones@example.com", "+1765432109", "Food Delights", true,
                Commande.creerListeInterets(liste_interet, 7, 8, 9),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 1,5));

        Utilisateur emma = new Utilisateur("emma_brown", "Brown", "Emma", "password4",
                "emma.brown@example.com", "+1654321876", "non renseigné", true,
                Commande.creerListeInterets(liste_interet, 10, 1, 2),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 1,2));

        Utilisateur chris = new Utilisateur("chris_green", "Green", "Chris", "password5",
                "chris.green@example.com", "+1432187654", "Music Groove", true,
                Commande.creerListeInterets(liste_interet, 3, 4, 5),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 1));

        Utilisateur lisa = new Utilisateur("lisa_white", "White", "Lisa", "password6",
                "lisa.white@example.com", "+1987654321", "non renseigné", true,
                Commande.creerListeInterets(liste_interet, 6, 7, 8),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 1,2,3,4));

        Utilisateur kevin = new Utilisateur("kevin_black", "Black", "Kevin", "password7",
                "kevin.black@example.com", "+1543219876", "Movie Magic", true,
                Commande.creerListeInterets(liste_interet, 9, 10, 1),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 2,5));

        Utilisateur sarah = new Utilisateur("sarah_grey", "Grey", "Sarah", "password8",
                "sarah.grey@example.com", "+1321897654", "non renseigné", false,
                Commande.creerListeInterets(liste_interet, 2, 3, 4),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 3,1));

        Utilisateur alex = new Utilisateur("alex_baker", "Baker", "Alex", "password9",
                "alex.baker@example.com", "+1123456789", "Bookworms", false,
                Commande.creerListeInterets(liste_interet,5, 6, 7),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 3));

        Utilisateur emily = new Utilisateur("emily_king", "King", "Emily", "password10",
                "emily.king@example.com", "+1987654321", "non renseigné", false,
                Commande.creerListeInterets(liste_interet, 8, 9, 10),
                Commande.creerListeFollowers(liste_utilisateur, ""),
                Commande.creerListeActivite(liste_activites, 4,5));


        // --FOURNISSEUR --
        Fournisseur fournisseur1 = new Fournisseur("Hello World", "password1", "2035 rue de la Cornemuse",
                "email1@example.com", "+1234567890", 100);
        fournisseur1.composantes.put(cpu,70); // TODO a voir si on veut la composante ou le nom de la composante en clé

        Fournisseur fournisseur2 = new Fournisseur("Pimpimpi", "password2", "4520 avenue Champetre",
                "email2@example.com", "+2345678901", 150);
        fournisseur2.composantes.put(cpu, 50);

        Fournisseur fournisseur3 = new Fournisseur("JavaYop", "password3", "6220 boulevard de Birmanie",
                "email3@example.com", "+3456789012", 200);
        fournisseur3.composantes.put(haut_parleurs, 122);

        Fournisseur fournisseur4 = new Fournisseur("Fease", "password4", "1000 rue du Baccalauréat",
                "email4@example.com", "+4567890123", 120);
        fournisseur4.composantes.put(cpu, 38);

        Fournisseur fournisseur5 = new Fournisseur("Denno", "password5", "4960 rue du Script Python",
                "email5@example.com", "+5678901234", 180);
        fournisseur5.composantes.put(cpu, 89);

        Fournisseur fournisseur6 = new Fournisseur("Samuel Inc", "password6", "5235 chemin du Code Java",
                "email6@example.com", "+6789012345", 90);
        fournisseur6.composantes.put(haut_parleurs, 30);


        // Liste Composante
        ArrayList<Composante> liste_composante = new ArrayList<Composante>();
        liste_composante.add(cpu); liste_composante.add(camera); liste_composante.add(haut_parleurs);

        // -- IMPLÉMENTATION DU SYSTÈME --
        Systeme systeme = new Systeme (liste_utilisateur, liste_fournisseur, liste_activites,
                liste_interet, liste_composante);

        systeme.ajouterUtilisateur(john.getIdentifiant(), john);
        systeme.ajouterUtilisateur(jane.getIdentifiant(), jane);
        systeme.ajouterUtilisateur(mike.getIdentifiant(), mike);
        systeme.ajouterUtilisateur(emma.getIdentifiant(), emma);
        systeme.ajouterUtilisateur(chris.getIdentifiant(), chris);
        systeme.ajouterUtilisateur(lisa.getIdentifiant(), lisa);
        systeme.ajouterUtilisateur(kevin.getIdentifiant(), kevin);
        systeme.ajouterUtilisateur(sarah.getIdentifiant(), sarah);
        systeme.ajouterUtilisateur(alex.getIdentifiant(), alex);
        systeme.ajouterUtilisateur(emily.getIdentifiant(), emily);

        systeme.ajouterFournisseur(fournisseur1.getNomCompagnie(), fournisseur1);
        systeme.ajouterFournisseur(fournisseur2.getNomCompagnie(), fournisseur2);
        systeme.ajouterFournisseur(fournisseur3.getNomCompagnie(), fournisseur3);
        systeme.ajouterFournisseur(fournisseur4.getNomCompagnie(), fournisseur4);
        systeme.ajouterFournisseur(fournisseur5.getNomCompagnie(), fournisseur5);
        systeme.ajouterFournisseur(fournisseur6.getNomCompagnie(), fournisseur6);

        // Tous les utilisateurs
        ArrayList<Utilisateur> utilisateurs = Commande.LireUtilisateurs();
        systeme.liste_utilisateur = Commande.listeVersMap(utilisateurs);

        // -------------------------------------------------------------------------------------------------------------

        System.out.println("-- BIENVENUE SUR ROBOTIX --");

        while (true) {
            Scanner scanner = new Scanner(System.in);


            System.out.println("Menu principal:");
            System.out.println("1. Inscription en tant qu'utilisateur");
            System.out.println("2. Inscription en tant que fournisseur");
            System.out.println("3. Connexion sur Robotix");
            System.out.println("0. Quitter");

            System.out.print("Choisissez une option: ");


            int entrer = Validation.validerChoix(3);

            switch (entrer) {
                // ------------------------------------------------------------------- S'INSCRIRE EN TANT QU'UTILISATEUR
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

                    ArrayList<Utilisateur> followers = new ArrayList<Utilisateur>();
                    ArrayList<Activite> activites = new ArrayList<Activite>();

                    System.out.println("Souhaitez-vous acceptez les notification par email ? ");
                    System.out.println("0. Non");
                    System.out.println("1. Oui");

                    boolean notification = false;
                    int choixNotification = Validation.validerChoix(1);
                    switch (choixNotification) {
                        case 0:
                            notification = false;
                            break;

                        case 1 :
                            notification = true;
                            break;
                    }

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
                            System.out.println("Votre inscription a été pris en compte. Vous recevrez un mail de confirmation sous 24h !");
                            Commande.ecrireUserJson(user);
                            break;

                        case 1:
                            System.out.println("Entrez le nom de la compagnie : ");
                            scanner.nextLine();
                            String nom_compagnie = scanner.nextLine();

                            Utilisateur user_compagnie = new Utilisateur(pseudo, nom, prenom, mot_de_passe, email,
                                    telephone, nom_compagnie,notification,interet_utilisateur, followers, activites);
                            Commande.ecrireUserJson(user_compagnie);
                            System.out.println("enregistrement...");
                            systeme.ajouterUtilisateur(pseudo, user_compagnie);
                            System.out.println("Votre inscription a été pris en compte. Vous recevrez un mail de confirmation sous 24h !");

                            break;
                    }

                }


                // ------------------------------------------------------------------ S'INSCRIRE EN TANT QUE FOURNISSEUR
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

                    System.out.println("Votre inscription a été pris en compte. Vous recevrez un mail de confirmation sous 24h !");
                }

                case 3 -> {
                    System.out.println("-- CONNEXION --");

                    System.out.println("identifiant : ");
                    String identifiant = scanner.nextLine();

                    System.out.println("mot de passe : ");
                    String passe_connexion = scanner.nextLine();

                    if (!systeme.estCorrect(identifiant, passe_connexion, scanner)) {
                        System.out.println("Connexion échoué...");
                    }
                }
                case 0 -> {
                    System.out.println("Merci de votre visite sur Robotix.");
                    return;
                }
            }
        }
    }
}