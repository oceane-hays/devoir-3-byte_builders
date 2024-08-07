package com.example.robotix;

import java.util.*;

/**
 * La classe {@code Systeme} gère les différentes entités du système Robotix, y compris les utilisateurs, les fournisseurs, les activités, les intérêts et les composants.
 * Elle permet d'ajouter, rechercher et afficher ces entités.
 */
public class Systeme {
    private HashMap<String, Utilisateur> liste_utilisateur; // < identifiant , utilisateur >
    private HashMap<String, Fournisseur> liste_fournisseur; // < nom_compagnie , fournisseur >
    private HashMap<Integer, Activite> liste_activites;
    private HashMap<Integer, Interet> liste_interet;
    private ArrayList<Composante> liste_composante;

    /**
     * Constructeur de la classe {@code Systeme}.
     *
     * @param liste_utilisateur La liste des utilisateurs avec leurs identifiants comme clé.
     * @param liste_fournisseur La liste des fournisseurs avec le nom de la compagnie comme clé.
     * @param liste_activites La liste des activités avec un identifiant unique comme clé.
     * @param liste_interet La liste des intérêts avec un identifiant unique comme clé.
     * @param liste_composante La liste des composants.
     */
    public Systeme(HashMap<String, Utilisateur> liste_utilisateur, HashMap<String, Fournisseur> liste_fournisseur,
                   HashMap<Integer, Activite> liste_activites, HashMap<Integer, Interet> liste_interet,
                   ArrayList<Composante> liste_composante) {

        this.liste_utilisateur = liste_utilisateur;
        this.liste_fournisseur = liste_fournisseur;
        this.liste_activites   = liste_activites;
        this.liste_interet     = liste_interet;
        this.liste_composante  = liste_composante;
    }

    /**
     * Retourne la liste des utilisateurs.
     *
     * @return La liste des utilisateurs.
     */
    public HashMap<String, Utilisateur> getListeUtilisateur() {
        return liste_utilisateur;
    }

    /**
     * Retourne la liste des fournisseurs.
     *
     * @return La liste des fournisseurs.
     */
    public HashMap<String, Fournisseur> getListeFournisseur() {
        return liste_fournisseur;
    }

    /**
     * Retourne la liste des activités.
     *
     * @return La liste des activités.
     */
    public HashMap<Integer, Activite> getListeActivites() {
        return liste_activites;
    }

    /**
     * Retourne la liste des intérêts.
     *
     * @return La liste des intérêts.
     */
    public HashMap<Integer, Interet> getListeInteret() {
        return liste_interet;
    }

    /**
     * Retourne la liste des composants.
     *
     * @return La liste des composants.
     */
    public ArrayList<Composante> getListeComposante() {
        return liste_composante;
    }

    /**
     * Ajoute un utilisateur à la liste des utilisateurs si l'identifiant n'existe pas déjà.
     *
     * @param identifiant L'identifiant de l'utilisateur.
     * @param utilisateur L'objet utilisateur à ajouter.
     */
    public void ajouterUtilisateur(String identifiant, Utilisateur utilisateur) {
        if (!liste_utilisateur.containsKey(identifiant)) {
            liste_utilisateur.put(identifiant, utilisateur);
        }
    }

    /**
     * Ajoute un fournisseur à la liste des fournisseurs si le nom de la compagnie n'existe pas déjà.
     *
     * @param nomCompagnie Le nom de la compagnie du fournisseur.
     * @param fournisseur L'objet fournisseur à ajouter.
     */
    public void ajouterFournisseur(String nomCompagnie, Fournisseur fournisseur) {
        if (!liste_fournisseur.containsKey(nomCompagnie)) {
            liste_fournisseur.put(nomCompagnie, fournisseur);
        }
    }

    /**
     * Affiche tous les utilisateurs dans la console.
     */
    public void afficherUtilisateurs() {
        for (Map.Entry<String, Utilisateur> entry : liste_utilisateur.entrySet()) {
            System.out.println(entry.getValue().toStringUtilisateur());
        }
    }

    /**
     * Affiche tous les fournisseurs dans la console.
     */
    public void afficherFournisseurs() {
        for (Map.Entry<String, Fournisseur> entry : liste_fournisseur.entrySet()) {
            System.out.println(entry.getValue().fournisseur());
        }
    }

    /**
     * Affiche toutes les activités dans la console.
     */
    public void afficherActivites() {
        for (Map.Entry<Integer, Activite> entry : liste_activites.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    /**
     * Affiche tous les intérêts dans la console.
     * Cette méthode est à implémenter.
     */
    public void afficherInterets() {
        for (Map.Entry<Integer, Interet> entry : liste_interet.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // -------------------------------------------------------------------------------------------- SECTION DE RECHERCHE

    /**
     * Recherche un utilisateur par son identifiant.
     *
     * @param identifiant L'identifiant de l'utilisateur à rechercher.
     * @return L'utilisateur correspondant à l'identifiant, ou {@code null} si non trouvé.
     */
    public Utilisateur rechercherUtilisateur(String identifiant) {
        if (liste_utilisateur.containsKey(identifiant)) {
            return liste_utilisateur.get(identifiant);
        } else {
            System.out.println("Identifiant non trouvé. ");
            return null;
        }
    }

    /**
     * Recherche un fournisseur par le nom de la compagnie.
     *
     * @param nomCompagnie Le nom de la compagnie du fournisseur à rechercher.
     * @return Le fournisseur correspondant au nom, ou {@code null} si non trouvé.
     */
    public Fournisseur rechercherFournisseur(String nomCompagnie) {
        if (liste_fournisseur.containsKey(nomCompagnie)) {
            return liste_fournisseur.get(nomCompagnie);
        } else {
            System.out.println("Fournisseur non trouvé. ");
            return null;
        }
    }

    /**
     * Recherche un fournisseur par son adresse.
     *
     * @param adresseFournisseur L'adresse du fournisseur à rechercher.
     * @return Le fournisseur correspondant à l'adresse, ou {@code null} si non trouvé.
     */
    private Fournisseur rechercherFournisseurParAdresse(String adresseFournisseur) {
        for (Map.Entry<String, Fournisseur> entry : liste_fournisseur.entrySet()) {
            Fournisseur fournisseur = entry.getValue();
            if (fournisseur.getAdresse().equals(adresseFournisseur)) {
                return fournisseur;
            }
        }
        return null;
    }

    /**
     * Recherche des fournisseurs qui proposent un type spécifique de composant.
     *
     * @param type Le type de composant à rechercher.
     * @return Une liste de fournisseurs proposant le type de composant spécifié.
     */
    private ArrayList<Fournisseur> rechercherFournisseurParTypeComposante(String type) {
        ArrayList<Fournisseur> fournisseursTrouves = new ArrayList<Fournisseur>();
        for (Map.Entry<String, Fournisseur> entry : liste_fournisseur.entrySet()) {
            Fournisseur fournisseur = entry.getValue();
            for (Composante composante : fournisseur.getComposantes().keySet()) {
                if (composante.getType().equals(type)) {
                    fournisseursTrouves.add(fournisseur);
                    break; // Sortir de la boucle des composantes dès qu'un match est trouvé
                }
            }
        }
        return fournisseursTrouves;
    }

    /**
     * Recherche une composante par son nom.
     *
     * @param nomComposante Le nom de la composante à rechercher.
     * @return La composante correspondant au nom, ou {@code null} si non trouvée.
     */
    public Composante rechercherComposante(String nomComposante) {
        for (Composante composante : liste_composante) {
            if (composante.getNom().equalsIgnoreCase(nomComposante)) {
                return composante;
            }
        }
        return null; // Renvoie null si aucune composante avec ce nom n'est trouvée
    }

    /**
     * Affiche un menu de recherche et traite la sélection de l'utilisateur.
     *
     * @param scanner Le scanner pour lire les entrées utilisateur.
     */
    public void autresFonctionnalites(Scanner scanner) {
        System.out.println("1. Rechercher un utilisateur par pseudo");
        System.out.println("2. Rechercher un fournisseur par nom");
        System.out.println("3. Rechercher un fournisseur par adresse");
        System.out.println("4. Rechercher un fournisseur par type de composante");
        System.out.println("5. Rechercher une composante par nom");
        System.out.println("0. QUITTER");

        int choix = Validation.validerChoix(5);
        switch (choix) {
            case 0:
                break;

            case 1: // Rechercher un utilisateur
                afficherUtilisateurs();
                System.out.println("Entrez l'identifiant de l'utilisateur à rechercher : ");
                String id_utilisateur = scanner.nextLine();
                Utilisateur utilisateur = rechercherUtilisateur(id_utilisateur);
                if (utilisateur != null) {
                    System.out.println(utilisateur.utilisateur());
                } else {
                    System.out.println("Utilisateur non trouvé.");
                }
                break;

            case 2:
                afficherFournisseurs();
                System.out.println("Entrez le nom de la compagnie du fournisseur à rechercher : ");
                String nomFournisseur = scanner.nextLine();
                Fournisseur fournisseur = rechercherFournisseur(nomFournisseur);
                if (fournisseur != null) {
                    System.out.println(fournisseur.toStringFournisseur());
                } else {
                    System.out.println("Fournisseur non trouvé.");
                }
                break;

            case 3:
                afficherFournisseurs();
                System.out.println("Entrez l'adresse de la compagnie du fournisseur à rechercher : ");
                String adresseFournisseur = scanner.nextLine();
                Fournisseur fournisseurParAdresse = rechercherFournisseurParAdresse(adresseFournisseur);
                if (fournisseurParAdresse != null) {
                    System.out.println(fournisseurParAdresse.toStringFournisseur());
                } else {
                    System.out.println("Aucun fournisseur trouvé.");
                }
                break;

            case 4:
                afficherFournisseurs();
                System.out.println("Entrez le type de composante du fournisseur à rechercher : ");
                String type = scanner.nextLine();
                ArrayList<Fournisseur> fournisseurParType = rechercherFournisseurParTypeComposante(type);
                if (fournisseurParType != null) {
                    for (Fournisseur seller : fournisseurParType)
                        System.out.println(seller.toStringFournisseur());
                } else {
                    System.out.println("Fournisseur non trouvé.");
                }
                break;

            case 5:
                System.out.println("Entrez le nom de la composante à rechercher : ");
                String nomComposante = scanner.next();
                scanner.nextLine(); // Pour consommer le retour à la ligne après nextInt()
                Composante composante = rechercherComposante(nomComposante);
                if (composante != null) {
                    System.out.println(composante);
                } else {
                    System.out.println("Composante non trouvée.");
                }
                break;

            default:
                System.out.println("Choix invalide.");
        }
    }

/**
 * La classe {@code GestionUtilisateur} gère les opérations et les fonctionnalités liées aux utilisateurs dans le système Robotix.
 * Cela inclut la gestion des abonnés, la modification du profil utilisateur, la connexion, la messagerie, et l'affichage du menu utilisateur.
 */
public class GestionUtilisateur {

    /**
     * Gère les abonnés d'un utilisateur. Permet de visualiser les abonnés et de supprimer un abonné.
     *
     * @param scanner Le scanner pour lire les entrées utilisateur.
     * @param utilisateur L'utilisateur dont les abonnés doivent être gérés.
     */
    public void gestionSuiveurs(Scanner scanner, Utilisateur utilisateur) {
        // Vérifie si la liste des abonnés est nulle ou vide
        if (utilisateur.getFollowers() == null || utilisateur.getFollowers().isEmpty()) {
            System.out.println("Vous n'êtes suivi par personne.");
        } else {
            // Affiche la liste des abonnés
            System.out.println("Voici la liste des utilisateurs qui vous suivent : ");
            System.out.println(utilisateur.toStringFollowers());

            // Présente les choix à l'utilisateur
            System.out.println("Souhaitez-vous supprimer un utilisateur : ");
            System.out.println("1. Oui");
            System.out.println("2. Non");
            System.out.println("0. QUITTER");

            // Valide le choix de l'utilisateur
            int choix = Validation.validerChoix(2);

            switch (choix) {
                case 0:
                    // Quitte la méthode
                    break;

                case 1: // Gère la suppression d'un abonné
                    System.out.println("Entrez le pseudo de l'utilisateur à supprimer : ");
                    String pseudoFollower = scanner.nextLine();

                    // Vérifie si l'abonné existe avant de tenter de le supprimer
                    Utilisateur followerToRemove = rechercherUtilisateur(pseudoFollower);
                    if (followerToRemove != null && utilisateur.getFollowers().contains(followerToRemove)) {
                        utilisateur.removeFollowers(pseudoFollower);
                        System.out.println("Suiveur supprimé avec succès !");
                    } else {
                        System.out.println("L'utilisateur avec le pseudo entré n'existe pas dans la liste des suiveurs.");
                    }
                    break;

                case 2:
                    // Ne fait rien et quitte
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        }
    }

    /**
     * Permet à un utilisateur de suivre un autre utilisateur.
     *
     * @param scanner Le scanner pour lire les entrées utilisateur.
     */
    public void suivreUtilisateur(Scanner scanner) {
        afficherUtilisateurs();
        System.out.println("Entrez le pseudo de l'utilisateur que vous souhaitez suivre : ");
        String pseudo = scanner.nextLine();

        // Tente de trouver l'utilisateur
        Utilisateur user = rechercherUtilisateur(pseudo);

        // Vérifie si l'utilisateur est null
        if (user == null) {
            System.out.println("Utilisateur non trouvé avec le pseudo : " + pseudo);
            return; // Quitte la méthode si l'utilisateur n'est pas trouvé
        }

        try {
            // Appelle la méthode suivreUtilisateur sur l'utilisateur trouvé
            user.suivreUtilisateur(pseudo);
            System.out.println("Vous suivez à présent cet utilisateur!");
        } catch (Exception e) {
            // Capture toute exception qui pourrait survenir
            System.err.println("Une erreur est survenue lors de l'ajout de l'utilisateur aux abonnés : " + e.getMessage());
        }
    }

    /**
     * Permet à un utilisateur de modifier ses informations de profil.
     *
     * @param scanner Le scanner pour lire les entrées utilisateur.
     * @param utilisateur L'utilisateur dont le profil doit être modifié.
     */
    public void modifierProfil(Scanner scanner, Utilisateur utilisateur) {
        System.out.println("-- MODIFICATION DE PROFIL UTILISATEUR --");
        System.out.println("1. Modifier mon nom");
        System.out.println("2. Modifier mon prénom");
        System.out.println("3. Modifier mon mot de passe");
        System.out.println("4. Modifier mon courriel");
        System.out.println("5. Modifier mon telephone");
        System.out.println("6. Modifier mes intérêts");
        System.out.println("0. Retour à la sélection");

        int choix = Validation.validerChoix(6);
        switch (choix) {
            case 1:
                System.out.println("Entrez votre nouveau nom :");
                String nouveauNom = scanner.nextLine();
                utilisateur.setNom(nouveauNom);
                System.out.println("Nom mis à jour.");
                break;
            case 2:
                System.out.println("Entrez votre nouveau prénom :");
                String nouveauPrenom = scanner.nextLine();
                utilisateur.setPrenom(nouveauPrenom);
                System.out.println("Prénom mis à jour.");
                break;
            case 3:
                System.out.println("Entrez votre nouveau mot de passe :");
                String nouveauMotDePasse = Validation.validerMotDePasse(scanner.nextLine());
                utilisateur.setMotDePasse(nouveauMotDePasse);
                System.out.println("Mot de passe mis à jour.");
                break;
            case 4:
                System.out.println("Entrez votre nouveau courriel :");
                String nouveauCourriel = Validation.validerEmail(scanner.nextLine());
                utilisateur.setCourriel(nouveauCourriel);
                System.out.println("Courriel mis à jour.");
                break;
            case 5:
                System.out.println("Entrez votre nouveau téléphone :");
                String nouveauTelephone = Validation.validerNumero(scanner.nextLine());
                utilisateur.setTelephone(nouveauTelephone);
                System.out.println("Téléphone mis à jour.");
                break;

            case 6:
                System.out.println("Liste de vos intérêts actuels: ");
                System.out.println(utilisateur.toStringInteret());

                System.out.println("Modifier vos Intérêts : ");
                afficherInterets();
                ArrayList<Interet> nouveau_interet = Commande.choisirInteret(scanner, getListeInteret());
                utilisateur.setInteret(nouveau_interet);
                break;

            case 0:
                break;
        }
        System.out.println("Vos informations ont été modifiées avec succès !");
    }

    /**
     * Vérifie si les informations d'identification sont correctes pour se connecter.
     *
     * @param identifiant L'identifiant de l'utilisateur ou du fournisseur.
     * @param mot_de_passe Le mot de passe de l'utilisateur ou du fournisseur.
     * @param scanner Le scanner pour lire les entrées utilisateur.
     * @return {@code true} si la connexion est réussie, {@code false} sinon.
     */
    public boolean estCorrect(String identifiant, String mot_de_passe, Scanner scanner) {
        boolean connexion = false;

        if (liste_utilisateur.containsKey(identifiant)) {
            Utilisateur utilisateur = liste_utilisateur.get(identifiant);
            if (recherchePasswordUtilisateur(mot_de_passe, utilisateur)) {
                connexion = true;
                System.out.println("Connexion réussie. Bienvenue, " + utilisateur.getIdentifiant());
                menuUtilisateur(utilisateur, scanner);
            }
        } else if (liste_fournisseur.containsKey(identifiant)) {
            Fournisseur fournisseur = liste_fournisseur.get(identifiant);
            if (recherchePasswordFournisseur(mot_de_passe, fournisseur)) {
                connexion = true;
                System.out.println("Connexion réussie. Bienvenue, " + fournisseur.getNomCompagnie());
                menuFournisseur(fournisseur, scanner);
            }
        } else {
            System.out.println("Votre identifiant n'a pas été trouvé. Veuillez réessayer ou vous inscrire sur la plateforme.");
        }
        return connexion;
    }

    /**
     * Vérifie si le mot de passe correspond à celui de l'utilisateur.
     *
     * @param mot_de_passe Le mot de passe à vérifier.
     * @param utilisateur L'utilisateur dont le mot de passe doit être vérifié.
     * @return {@code true} si le mot de passe est correct, {@code false} sinon.
     */
    public boolean recherchePasswordUtilisateur(String mot_de_passe, Utilisateur utilisateur) {
        if (utilisateur.getMotDePasse().equals(mot_de_passe)) {
            return true;
        } else {
            System.out.println("Votre mot de passe est incorrect. Veuillez réessayer.");
            return false;
        }
    }

    /**
     * Vérifie si le mot de passe correspond à celui du fournisseur.
     *
     * @param mot_de_passe Le mot de passe à vérifier.
     * @param fournisseur Le fournisseur dont le mot de passe doit être vérifié.
     * @return {@code true} si le mot de passe est correct, {@code false} sinon.
     */
    public boolean recherchePasswordFournisseur(String mot_de_passe, Fournisseur fournisseur) {
        if (fournisseur.getMotDePasse().equals(mot_de_passe)) {
            return true;
        } else {
            System.out.println("Votre mot de passe est incorrect. Veuillez réessayer.");
            return false;
        }
    }

    /**
     * Ouvre la messagerie de l'utilisateur et affiche ses notifications.
     *
     * @param utilisateur L'utilisateur dont les notifications doivent être affichées.
     */
    public void ouvrirMessagerie(Utilisateur utilisateur) {
        // Vérifie si l'utilisateur a des notifications
        if (utilisateur.getNotifications().isEmpty()) {
            System.out.println("Aucune notification.");
            return;
        }

        // Parcourt la liste des notifications de l'utilisateur
        for (Notification notification : utilisateur.getNotifications()) {
            // Affiche les détails de chaque notification
            System.out.println(notification.toString());
        }
    }

    /**
     * Affiche le menu principal pour l'utilisateur connecté.
     *
     * @param utilisateur L'utilisateur connecté.
     * @param scanner Le scanner pour lire les entrées utilisateur.
     */
    public void menuUtilisateur(Utilisateur utilisateur, Scanner scanner) {
        boolean connected = true;
        while (connected) {
            System.out.println("Choisissez une option : ");

            System.out.println("1. Afficher les informations de mon profil");
            System.out.println("2. Modifier mes informations");
            System.out.println("3. Gérer ma flotte");
            System.out.println("4. Afficher mes activités");
            System.out.println("5. Trouver des utilisateurs");
            System.out.println("6. Voir le profil d'un utilisateur");
            System.out.println("7. Voir le profil d'un fournisseur");
            System.out.println("8. S'inscrire à une activité");
            System.out.println("9. Voir l'état de mes robots");
            System.out.println("10. Voir les métriques (non implémenté)");
            System.out.println("11. Afficher intérêts");
            System.out.println("12. Gérer mes intérêts");
            System.out.println("13. Gérer mes suiveurs");
            System.out.println("14. Suivre des utilisateurs");
            System.out.println("15. Acheter des composantes");
            System.out.println("16. Voir mes notifications");
            System.out.println("17. Autres fonctionnalités");
            System.out.println("0. Se déconnecter");

            int choix = Validation.validerChoix(17);
            switch (choix) {
                case 1:
                    System.out.println(utilisateur.utilisateur());
                    break;

                case 2:
                    modifierProfil(scanner, utilisateur);
                    break;

                case 3:
                    System.out.println("-- GESTION DE LA FLOTTE --");

                    GestionnaireFlotte gestionnaireFlotte = new GestionnaireFlotte(utilisateur);
                    // Utilisation des méthodes de gestionnaireFlotte
                    gestionnaireFlotte.afficherEtatFlotte();

                    // Autres fonctionnalités pour utiliser le gestionnaire de la flotte

                    // Menu
                    System.out.println("Choisissez une option : ");
                    System.out.println("1. Ajouter un robot");
                    System.out.println("2. Supprimer un robot");
                    System.out.println("0. Retour au menu principal");

                    int gestionChoix = scanner.nextInt();
                    scanner.nextLine();

                    switch (gestionChoix) {
                        case 1:
                            System.out.println("Entrez le numéro de série du nouveau robot : ");
                            String numeroSerie = scanner.nextLine();
                            System.out.println("Entrez le nom du robot : ");
                            String nomRobot = scanner.nextLine();
                            System.out.println("Entrez le type du robot : ");
                            String typeRobot = scanner.nextLine();
                            System.out.println("Entrez le niveau de batterie : ");
                            int niveauBatterie = scanner.nextInt();
                            System.out.println("Entrez la consommation de CPU : ");
                            int consommation = scanner.nextInt();

                            gestionnaireFlotte.ajouterRobot(numeroSerie, nomRobot, typeRobot, niveauBatterie, consommation);
                            System.out.println("Robot ajouté avec succès !");
                            break;

                        case 2:
                            System.out.println("Entrez le numéro de série du robot à supprimer : ");
                            String numeroSerieSupp = scanner.nextLine();

                            gestionnaireFlotte.supprimerRobot(numeroSerieSupp);
                            System.out.println("Robot supprimé avec succès !");
                            break;

                        case 0:
                            System.out.println("Retour au menu principal.");
                            break;

                        default:
                            System.out.println("Option invalide. Veuillez réessayer.");
                    }
                    break;

                case 4:
                    System.out.println("-- CONSULTATION DE VOS ACTIVITÉS --");
                    System.out.println(utilisateur.toStringActivite());

                    if (utilisateur.activite.isEmpty()) {
                        System.out.println("Vous n'avez pas d'activité enregistrée");
                    }
                    break;

                case 5:
                    System.out.println("-- TROUVER ET ABONNER VOUS À VOS AMIS --");
                    afficherUtilisateurs();
                    System.out.println("Entrez l'identifiant du profil auquel vous voulez vous abonner : ");
                    String abonnement = scanner.nextLine();
                    utilisateur.followers.add(liste_utilisateur.get(abonnement));
                    break;

                case 6:
                    System.out.println("-- CONSULTER PROFIL UTILISATEUR --");
                    afficherUtilisateurs();
                    System.out.println("Entrez l'identifiant du profil que vous souhaitez consulter : ");
                    String profil = scanner.nextLine();
                    System.out.println(rechercherUtilisateur(profil));
                    break;

                case 7:
                    System.out.println("-- CONSULTER PROFIL FOURNISSEUR --");
                    afficherFournisseurs();
                    System.out.println("Entrez la compagnie du fournisseur que vous souhaitez consulter : ");
                    String profilFournisseur = scanner.nextLine();
                    System.out.println(rechercherFournisseur(profilFournisseur));
                    break;

                case 8:
                    System.out.println("-- INSCRIVEZ-VOUS AUX ACTIVITÉS --");
                    afficherActivites();
                    System.out.println("Entrez le numéro de l'activité à laquelle vous voulez vous inscrire : ");
                    int activiteInscription = scanner.nextInt();
                    utilisateur.activite.add(liste_activites.get(activiteInscription));
                    break;

                case 9:
                    System.out.println("-- ÉTAT DE VOS ROBOTS --");
                    GestionnaireFlotte.afficherEtatFlotte();
                    break;

                case 10:
                    break;

                case 11:
                    System.out.println("Liste de vos intérêts actuels : ");
                    System.out.println(utilisateur.toStringInteret());
                    break;

                case 12:
                    System.out.println("Liste de vos intérêts actuels : ");
                    System.out.println(utilisateur.toStringInteret());
                    System.out.println("Modifier vos intérêts : ");
                    afficherInterets();
                    ArrayList<Interet> nouveauInteret = Commande.choisirInteret(scanner, getListeInteret());
                    utilisateur.setInteret(nouveauInteret);
                    break;

                case 13:
                    System.out.println("-- GESTION DES SUIVEURS --");
                    gestionSuiveurs(scanner, utilisateur);
                    break;

                case 14:
                    System.out.println("-- VOICI LA LISTE DES UTILISATEURS DE ROBOTIX --");
                    suivreUtilisateur(scanner);
                    break;

                case 15:
                    System.out.println("-- CENTRE D'ACHAT DES COMPOSANTES --");
                    break;

                case 16:
                    System.out.println("-- MESSAGERIE --");
                    ouvrirMessagerie(utilisateur);
                    break;

                case 17:
                    System.out.println("-- BARRE DE RECHERCHE --");
                    autresFonctionnalites(scanner);
                    break;

                case 0:
                    System.out.println("Déconnexion réussie.");
                    connected = false;
                    break;
            }
            Commande.updateUtilisateur(utilisateur);
        }
    }

    /**
     * Affiche le menu principal pour le fournisseur connecté et gère les interactions disponibles.
     *
     * @param fournisseur Le fournisseur connecté.
     * @param scanner Le scanner pour lire les entrées utilisateur.
     */
    public void menuFournisseur(Fournisseur fournisseur, Scanner scanner) {
        boolean connected = true;
        while (connected) {
            System.out.println("Choisissez une option : ");
            System.out.println("1. Afficher les informations de mon profil");
            System.out.println("2. Modifier mes informations");
            System.out.println("3. Gérer mes composantes");
            System.out.println("4. Enregistrer une composante");
            System.out.println("5. Autres fonctionnalités ");
            System.out.println("0. Se déconnecter");

            int choix = Validation.validerChoix(5);
            switch (choix) {
                case 1:
                    System.out.println(fournisseur);
                    break;
                case 2:
                    System.out.println("-- MODIFICATION DE PROFIL FOURNISSEUR --");
                    System.out.println("1. Modifier mon mot de passe");
                    System.out.println("2. Modifier mon courriel");
                    System.out.println("3. Modifier mon téléphone");
                    System.out.println("4. Modifier la capacité de fabrication");

                    int modChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (modChoice) {
                        case 1:
                            System.out.println("Entrez votre nouveau mot de passe :");
                            String nouveauMotDePasse = Validation.validerMotDePasse(scanner.nextLine());
                            fournisseur.setMotDePasse(nouveauMotDePasse);
                            System.out.println("Mot de passe mis à jour.");
                            break;
                        case 2:
                            System.out.println("Entrez votre nouveau courriel :");
                            String nouveauCourriel = Validation.validerEmail(scanner.nextLine());
                            fournisseur.setCourriel(nouveauCourriel);
                            System.out.println("Courriel mis à jour.");
                            break;
                        case 3:
                            System.out.println("Entrez votre nouveau téléphone :");
                            String nouveauTelephone = Validation.validerNumero(scanner.nextLine());
                            fournisseur.setTelephone(nouveauTelephone);
                            System.out.println("Téléphone mis à jour.");
                            break;
                        case 4:
                            System.out.println("Entrez votre nouvelle capacité de fabrication :");
                            int capaciteFabrication = scanner.nextInt();
                            fournisseur.setCapaciteFabrication(capaciteFabrication);
                            System.out.println("Capacité de fabrication mise à jour.");
                            break;
                    }
                    System.out.println("Vos informations ont été modifiées avec succès !");
                    break;

                case 3:
                    System.out.println("-- Gestionnaire des composantes --");
                    System.out.println(fournisseur.composantes); // TODO voir ce que cela imprime
                    gestionnaireComposantes(scanner, fournisseur);
                    break;

                case 4:
                    System.out.println("-- Enregistrement d'une composante --");
                    System.out.println("Nom de la composante : ");
                    String nomComposante = scanner.nextLine();

                    System.out.println("Type de la composante : ");
                    String type = scanner.nextLine();

                    System.out.println("Description de la composante : ");
                    String description = scanner.nextLine();

                    System.out.println("Prix : ");
                    int prix = scanner.nextInt();

                    System.out.println("Combien voulez-vous en produire ? : ");
                    int nombreCargaison = scanner.nextInt();

                    Composante composante = new Composante(nomComposante, type, description, prix);
                    fournisseur.composantes.put(composante, nombreCargaison);
                    System.out.println("Composante ajoutée à vos composantes.");
                    break;

                case 5:
                    System.out.println("-- BARRE DE RECHERCHE --");
                    autresFonctionnalites(scanner);
                    break;

                case 0:
                    System.out.println("Déconnexion réussie.");
                    connected = false;
                    break; // Sort de la boucle pour se déconnecter
            }
        }
    }

    /**
     * Permet de gérer les composantes du fournisseur, y compris la suppression des composantes existantes.
     *
     * @param scanner Le scanner pour lire les entrées utilisateur.
     * @param fournisseur Le fournisseur dont les composantes doivent être gérées.
     */
    public void gestionnaireComposantes(Scanner scanner, Fournisseur fournisseur) {
        try {
            System.out.println("(0) Supprimer une composante (1) Quitter");

            int supprimer_composante = scanner.nextInt();

            if (supprimer_composante == 0) {
                HashMap<Composante, Integer> list_composantes = fournisseur.getComposantes();
                int i = 0;
                ArrayList<Composante> keys = new ArrayList<>(list_composantes.keySet());
                for (Composante composante : keys) {
                    System.out.println(i + ": " + composante.getType());
                    i++;
                }

                int index = scanner.nextInt();

                if (index >= 0 && index < keys.size()) {
                    Composante composanteASupprimer = keys.get(index);
                    list_composantes.remove(composanteASupprimer);
                    System.out.println("Composante supprimée.");
                } else {
                    System.out.println("Index invalide.");
                }
            } else if (supprimer_composante == 1) {
                return;
            } else {
                System.out.println("Option invalide.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Veuillez entrer un nombre valide.");
            scanner.next(); // Clear the invalid input
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite : " + e.getMessage());
        }
    }
    }
}
