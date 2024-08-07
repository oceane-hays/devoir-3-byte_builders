package com.example.robotix;

import java.util.*;

public class Systeme {
    public HashMap<String, Utilisateur> liste_utilisateur; // < identifiant , utilisateur >
    public HashMap<String, Fournisseur> liste_fournisseur; // < nom_compagnie , fournisseur >
    public HashMap<Integer, Activite> liste_activites;
    public HashMap<Integer, Interet> liste_interet;
    public ArrayList<Composante> liste_composante;


    public Systeme(HashMap<String, Utilisateur> liste_utilisateur, HashMap<String, Fournisseur> liste_fournisseur,
                   HashMap<Integer, Activite> liste_activites, HashMap<Integer, Interet> liste_interet,
                   ArrayList<Composante> liste_composante) {

        this.liste_utilisateur = liste_utilisateur;
        this.liste_fournisseur = liste_fournisseur;
        this.liste_activites   = liste_activites;
        this.liste_interet     = liste_interet;
        this.liste_composante  = liste_composante;
    }



    public HashMap<String, Utilisateur> getListeUtilisateur() {
        return liste_utilisateur;
    }
    public HashMap<String, Fournisseur> getListeFournisseur() {
        return liste_fournisseur;
    }
    public HashMap<Integer, Activite> getListeActivites() {
        return liste_activites;
    }
    public HashMap<Integer, Interet> getListeInteret() {
        return liste_interet;
    }
    public ArrayList<Composante> getListeComposante() {
        return liste_composante;
    }


    public void ajouterUtilisateur(String identifiant, Utilisateur utilisateur) {
        if (!liste_utilisateur.containsKey(identifiant)) {
            liste_utilisateur.put(identifiant, utilisateur);
        }
    }

    public void ajouterFournisseur(String nomCompagnie, Fournisseur fournisseur) {
        if (!liste_fournisseur.containsKey(nomCompagnie)) {
            liste_fournisseur.put(nomCompagnie, fournisseur);
        }
    }

    public void afficherUtilisateurs() {
        for (Map.Entry<String, Utilisateur> entry : liste_utilisateur.entrySet()) {
                System.out.println(entry.getValue().toStringUtilisateur());
        }

    }


    public void afficherFournisseurs() {
        for (Map.Entry<String, Fournisseur> entry : liste_fournisseur.entrySet()) {
            System.out.println(entry.getValue().fournisseur());
        }
    }

    // Méthode pour afficher les activités en console
    public void afficherActivites() {
        for (Map.Entry<Integer, Activite> entry : liste_activites.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }


    // TODO implementer dans le code
    public void afficherInterets() {
        for (Map.Entry<Integer, Interet> entry : liste_interet.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


    // -------------------------------------------------------------------------------------------- SECTION DE RECHERCHE

    public Utilisateur rechercherUtilisateur(String identifiant) {
        if (liste_utilisateur.containsKey(identifiant)) {
            return liste_utilisateur.get(identifiant);
        } else {
            System.out.println("Identifiant non trouvé. ");
            return null;
        }
    }

    public Fournisseur rechercherFournisseur(String nomCompagnie) {
        if (liste_fournisseur.containsKey(nomCompagnie)) {
            return liste_fournisseur.get(nomCompagnie);
        } else {
            System.out.println("Fournisseur non trouvé. ");
            return null;
        }
    }

    private Fournisseur rechercherFournisseurParAdresse(String adresseFournisseur) {
        for (Map.Entry<String, Fournisseur> entry : liste_fournisseur.entrySet()) {
            Fournisseur fournisseur = entry.getValue();
            if (fournisseur.getAdresse().equals(adresseFournisseur)) {
                return fournisseur;
            }
        }
        return null;
    }

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

    public Composante rechercherComposante(String nomComposante) {
        for (Composante composante : liste_composante) {
            if (composante.getNom().equalsIgnoreCase(nomComposante)) {
                return composante;
            }
        }
        return null; // Renvoie null si aucune composante avec ce nom n'est trouvée
    }


    public void autresFonctionnalites (Scanner scanner) {

        System.out.println("1. Rechercher un utilisateur par pseudo");
        System.out.println("2. Rechercher un fournisseur par nom");
        System.out.println("3. Rechercher un fournisseur par adresse");
        System.out.println("4. Rechercher un fournisseur par type de composante");
        System.out.println("5. Rechercher une composante par nom");
        System.out.println("0. QUITTER");


        int choix = Validation.validerChoix(5);
        switch (choix) {

            case 0 :
                break;

            case 1 : // Rechercher un utilisateur
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

        }
    }

    public void gestionSuiveurs(Scanner scanner, Utilisateur utilisateur) {
        // Check if the followers list is null or empty
        if (utilisateur.getFollowers() == null || utilisateur.getFollowers().isEmpty()) {
            System.out.println("Vous n'êtes suivi par personne.");
        } else {
            // Print the list of followers
            System.out.println("Voici la liste des utilisateurs qui vous suivent : ");
            System.out.println(utilisateur.toStringFollowers());

            // Present choices to the user
            System.out.println("Souhaitez-vous supprimer un utilisateur : ");
            System.out.println("1. Oui");
            System.out.println("2. Non");
            System.out.println("0. QUITTER");

            // Validate user choice
            int choix = Validation.validerChoix(2);

            switch (choix) {
                case 0:
                    // Exit the method
                    break;

                case 1: // Handle follower removal
                    System.out.println("Entrez le pseudo de l'utilisateur à supprimer : ");
                    String pseudoFollower = scanner.nextLine();

                    // Check if the follower exists before attempting to remove
                    Utilisateur followerToRemove = rechercherUtilisateur(pseudoFollower);
                    if (followerToRemove != null && utilisateur.getFollowers().contains(followerToRemove)) {
                        utilisateur.removeFollowers(pseudoFollower);
                        System.out.println("Suiveur supprimé avec succès !");
                    } else {
                        System.out.println("L'utilisateur avec le pseudo entré n'existe pas dans la liste des suiveurs.");
                    }
                    break;

                case 2:
                    break;

            }
        }
    }

    public void suivreUtilisateur(Scanner scanner) {
        afficherUtilisateurs();
        System.out.println("Entrez le pseudo de l'utilisateur que vous souhaitez suivre : ");
        String pseudo = scanner.nextLine();

        // Attempt to find the user
        Utilisateur user = rechercherUtilisateur(pseudo);

        // Check if user is null
        if (user == null) {
            System.out.println("Utilisateur non trouvé avec le pseudo : " + pseudo);
            return; // Exit the method if user is not found
        }

        try {
            // Call the suivreUtilisateur method on the found user
            user.suivreUtilisateur(pseudo);
            System.out.println("Vous suivez à présent cet utilisateur!");
        } catch (Exception e) {
            // Catch any exception that might occur
            System.err.println("Une erreur est survenue lors de l'ajout de l'utilisateur aux abonnés : " + e.getMessage());
        }
    }





    // -------------------------------------------------------------------------------------------- MODIFIER PROFIL USER
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

            case 6 :
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
        System.out.println("Vos informations ont été modifié avec succès !");
    }

    // ------------------------------------------------------------------------------------------------------- CONNEXION
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

    public boolean recherchePasswordUtilisateur(String mot_de_passe, Utilisateur utilisateur) {
        if (utilisateur.getMotDePasse().equals(mot_de_passe)) {
            return true;
        } else {
            System.out.println("Votre mot de passe est incorrect. Veuillez réessayer.");
            return false;
        }
    }

    public boolean recherchePasswordFournisseur(String mot_de_passe, Fournisseur fournisseur) {
        if (fournisseur.getMotDePasse().equals(mot_de_passe)) {
            return true;
        } else {
            System.out.println("Votre mot de passe est incorrect. Veuillez réessayer.");
            return false;
        }
    }

    // ------------------------------------------------------------------------------------------ VOIR MES NOTIFICATIONS
    public void ouvrirMessagerie(Utilisateur utilisateur) {
        // Vérifie si l'utilisateur a des notifications
        if (utilisateur.getNotifications().isEmpty()) {
            System.out.println("Aucune notification.");
            return;
        }

        // Parcourt la liste des notifications de l'utilisateur
        for (Notification notification : utilisateur.getNotifications()) {
            // Affiche les détails de chaque notification
            System.out.println(notification.toString() );
        }
    }


    // ------------------------------------------------------------------------------------------------ MENU UTILISATEUR
    public void menuUtilisateur(Utilisateur utilisateur, Scanner scanner) {
        boolean connected = true;
        while (connected) {
            System.out.println("Choisissez une option : ");

            System.out.println("1. Gérer mon profil"); //


            System.out.println("2. Afficher, Gerer mes interets"); // ->3

            System.out.println("3. Gerer mes suiveurs");
            System.out.println("4. Suivre des utilisateurs");

            System.out.println("5. Gérer ma flotte"); // 5
            //System.out.println("10. Voir les métriques (non implementé) ");

            System.out.println("6. Gérer, Afficher mes activités"); // 6


            System.out.println("7. Acheter des composantes");  // 7

            System.out.println("8. Voir mes notifications");

            System.out.println("9. Recherche dans le Système");  // 8
            System.out.println("0. Se déconnecter");

            int choix = Validation.validerChoix(9);
            switch (choix) {
                case 1:
                    System.out.println("1. Afficher les informations de mon profil");
                    System.out.println("2. Modifier mes informations");
                    switch (Validation.validerChoix(2)) {
                        case 1 -> System.out.println(utilisateur.utilisateur());
                        case 2 -> modifierProfil(scanner, utilisateur);
                    }
                    break;

                case 2:
                    System.out.println("1. Afficher intérets");  // 8
                    System.out.println("2. Modifier intérets");  // 8


                    switch (Validation.validerChoix(2)){
                        case 1:
                            System.out.println("Liste de vos intérêts actuels: ");
                            System.out.println(utilisateur.toStringInteret());
                            break;

                        case 2:
                            System.out.println("Liste de vos intérêts actuels: ");
                            System.out.println(utilisateur.toStringInteret());
                            System.out.println("Modifier vos Intérêts : ");
                            afficherInterets();
                            ArrayList<Interet> nouveau_interet = Commande.choisirInteret(scanner, getListeInteret());
                            utilisateur.setInteret(nouveau_interet);
                            break;
                    }
                    break;


                case 5 :
                    
                    System.out.println("-- GESTION DE LA FLOTTE --");
                    
                    GestionnaireFlotte gestionnaireFlotte = new GestionnaireFlotte(utilisateur);
                    // Utilisation des méthodes de gestionnaireFlotte
                    System.out.println("-- Etat de votre flotte --");
                    gestionnaireFlotte.afficherEtatFlotte();
                    
                    //Autres fonctionnalités pour utiliser le gestionnaire de la flotte

                    //menu
                    System.out.println("Choisissez une option : ");
                    System.out.println("1. Ajouter un robot");
                    System.out.println("2. Supprimer un robot");
                    System.out.println("0. Retour au menu principal");

                    int gestionChoix = scanner.nextInt();
                    scanner.nextLine();

                    switch (gestionChoix) {
                        case 1:
                            try {
                                System.out.println("Entrez le numéro de série du nouveau robot : ");
                                String numeroSerie = scanner.nextLine();
                                System.out.println("Entrez le nom du robot : ");
                                String nomRobot = scanner.nextLine();
                                System.out.println("Entrez le type du robot : ");
                                String typeRobot = scanner.nextLine();
                                System.out.println("Entrez le niveau de batterie : ");
                                int niveauBatterie = scanner.nextInt();
                                System.out.println("Entrez la consommation de CPU (num qui represente %): ");
                                int consommationCpu = scanner.nextInt();
                                System.out.println("Entrez la consommation de Memoire (num qui represente %): ");
                                int mem = scanner.nextInt();
                                System.out.println("Position ecrit comme suit: (x, y, z)");
                                String pos = scanner.nextLine();

                                gestionnaireFlotte.ajouterRobot(numeroSerie, nomRobot, typeRobot, 0, pos, niveauBatterie, consommationCpu, mem, new ArrayList<>());
                                System.out.println("Robot ajouté avec succès !");
                            }
                            catch (Exception e){
                                System.out.println("Recommencez, mauvais type d'entree");
                            }
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

                    }
                    break;


                case 6 :
                    System.out.println("1. Afficher Activités");  // 8
                    System.out.println("2. Modifier Activités");  // 8

                    switch (Validation.validerChoix(2)) {
                        case 1 -> {
                            System.out.println("-- CONSULTATION DE VOS ACTIVITES --");
                            System.out.println(utilisateur.toStringActivite());
                            if (utilisateur.activite.isEmpty()) {
                                System.out.println("Vous n'avez pas d'activité enregistré");
                            }
                        }
                        case 2 -> {
                            System.out.println("-- INSCRIS-TOI AUX ACTIVITÉS --");
                            afficherActivites();
                            System.out.println("Entrez le numero de l'activite auquel vous voulez vous inscrire : ");
                            int activite_inscription = scanner.nextInt();
                            utilisateur.activite.add(liste_activites.get(activite_inscription));
                        }
                    }
                    break;


                case 4:
                    System.out.println("-- TROUVE ET ABONNE-TOI A TES AMIS --");

                    if (liste_utilisateur.isEmpty()) {
                        System.out.println("Aucun utilisateur enregistré dans Robotix");
                    } else {
                        afficherUtilisateurs();

                        System.out.println("Entrez l'identifiant du profil auquel vous voulez souscrire : ");
                        String abonnement = scanner.nextLine();
                        Utilisateur utilisateurASuivre = liste_utilisateur.get(abonnement);

                        if (utilisateurASuivre == null) {
                            System.out.println(">Utilisateur introuvable>");
                        } else {
                            utilisateur.followers.add(utilisateurASuivre);
                            System.out.println("Vous êtes maintenant abonné à " + utilisateurASuivre.getNom() + "!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("-- GESTION DES SUIVEURS --");

                    if (utilisateur.followers.isEmpty()) {
                        System.out.println("Vous n'êtes suivi par personne");
                    } else {
                        gestionSuiveurs(scanner, utilisateur);
                    }
                    break;


                case 7 :
                    System.out.println("-- Centre d'achat des composantes --");
                    System.out.println("-- Choisissez un fournisseur --");

                    afficherFournisseurs();
                    System.out.println("-- Entrez le nom du fournisseur choisit --");
                    String nom = scanner.nextLine();
                    try {
                        Fournisseur four = rechercherFournisseur(nom);
                        four.composantes.forEach((composante, integer) -> {
                            System.out.println(integer.toString() + " " + composante.toString());
                        });
                        System.out.println("-- Entrez le nom de la composante a acheter (0 pour cancel) --");
                        String choix2 = scanner.nextLine();
                        if(choix2 == "0"){
                            System.out.println("Annulle");
                        }
                        else{
                            System.out.println("Composante achetee");
                            // TODO Ajouter au Robot
                        }

                    }
                    catch (Exception e){
                        System.out.println("Echec de la recherche, reeseye");
                    }

                    break;

                case 8 :
                    System.out.println("-- MESSAGERIE --");
                    ouvrirMessagerie(utilisateur);
                    break;

                case 9 :
                    System.out.println("-- BARRE DE RECHERCHE --");
                    autresFonctionnalites(scanner);
                    break;

                case 0 :
                    System.out.println("Déconnexion réussie.");
                    connected = false;
                    break;
            }
            Commande.updateUtilisateur(utilisateur);
        }
    }

    // ------------------------------------------------------------------------------------------------ MENU FOURNISSEUR
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
                    System.out.println("3. Modifier mon telephone");
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
                            System.out.println("Entrez votre nouvelle capacite de fabrication :");
                            int capaciteFabrication = scanner.nextInt();
                            fournisseur.setCapaciteFabrication(capaciteFabrication);
                            System.out.println("Courriel mis à jour.");
                            break;
                    }
                    System.out.println("Vos informations ont été modifié avec succès !");
                    break;

                case 3:
                    System.out.println("-- Gestionnaire des composantes --");
                    System.out.println(fournisseur.composantes); // TODO voir ce que s'a imprime
                    gestionnaireComposantes(scanner, fournisseur);
                    break;

                case 4:
                    System.out.println("-- Enregistrement d'une composante --");
                    System.out.println("nom de la composante : ");
                    String nomComposante = scanner.nextLine();

                    System.out.println("type de la composante : ");
                    String type = scanner.nextLine();

                    System.out.println("description de la composante : ");
                    String description = scanner.nextLine();

                    System.out.println("prix : ");
                    int prix = scanner.nextInt();

                    System.out.println("Combien voulez vous en produire ? : ");
                    int nombreCargaison = scanner.nextInt();

                    Composante composante = new Composante(nomComposante, type, description, prix);
                    fournisseur.composantes.put(composante, nombreCargaison);
                    System.out.println("Composante ajouté à vos composantes.");
                    break;

                case 5 :
                    System.out.println("-- BARRE DE RECHERCHE --");
                    autresFonctionnalites(scanner);
                    break;

                case 0:
                    System.out.println("Déconnexion réussie.");
                    connected = false;
                    break; // Sort de la boucle pour se déconnecter
            }
            Commande.updateFournisseur(fournisseur);
        }
    }

    // ----------------------------------------------------------------------------- GESTIONNAIRE COMPOSANTE FOURNISSEUR

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
            scanner.next(); // clear the invalid input
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite : " + e.getMessage());
        }
    }

}
