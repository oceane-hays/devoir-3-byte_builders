package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


/**
 * La classe Utilisateur représente un utilisateur avec ses informations personnelles,
 * ses intérêts, ses activités, ses robots et ses notifications.
 */
public class Utilisateur {

    private String identifiant;
    private String nom;
    private String prenom;
    private String mot_de_passe;
    private String courriel;
    private String telephone;
    private String compagnie;
    private boolean emailNotificationsEnabled;
    private ArrayList<Interet> interet;
    public ArrayList<Utilisateur> followers;
    public ArrayList<Activite> activite;
    public ArrayList<Robot> liste_robot = new ArrayList<Robot>();
    public ArrayList<Notification> notifications = new ArrayList<Notification>();

    /**
     * Constructeur par défaut.
     */
    public Utilisateur() {}

    /**
     * Constructeur avec tous les attributs.
     *
     * @param identifiant l'identifiant de l'utilisateur
     * @param nom le nom de l'utilisateur
     * @param prenom le prénom de l'utilisateur
     * @param mot_de_passe le mot de passe de l'utilisateur
     * @param courriel l'adresse e-mail de l'utilisateur
     * @param telephone le numéro de téléphone de l'utilisateur
     * @param compagnie la compagnie de l'utilisateur
     * @param emailNotificationsEnabled indicateur si les notifications par email sont activées
     * @param interet les intérêts de l'utilisateur
     * @param followers la liste des utilisateurs qui suivent cet utilisateur
     * @param activite la liste des activités de l'utilisateur
     */
    public Utilisateur(String identifiant, String nom, String prenom, String mot_de_passe,
                       String courriel, String telephone, String compagnie, boolean emailNotificationsEnabled,
                       ArrayList<Interet> interet, ArrayList<Utilisateur> followers,
                       ArrayList<Activite> activite) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.mot_de_passe = mot_de_passe;
        this.courriel = courriel;
        this.telephone = telephone;
        this.compagnie = compagnie;
        this.emailNotificationsEnabled = emailNotificationsEnabled;
        this.interet = interet;
        this.followers = followers;
        this.activite = activite;
    }

    /**
     * Retourne l'identifiant de l'utilisateur.
     *
     * @return l'identifiant de l'utilisateur
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * Retourne le nom de l'utilisateur.
     *
     * @return le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom de l'utilisateur.
     *
     * @return le prénom de l'utilisateur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Retourne le mot de passe de l'utilisateur.
     *
     * @return le mot de passe de l'utilisateur
     */
    @JsonProperty("mot_de_passe")
    public String getMotDePasse() {
        return mot_de_passe;
    }

    /**
     * Retourne la compagnie de l'utilisateur.
     *
     * @return la compagnie de l'utilisateur
     */
    @JsonProperty("compagnie")
    public String getCompagnie() {
        return this.compagnie;
    }

    /**
     * Retourne l'adresse e-mail de l'utilisateur.
     *
     * @return l'adresse e-mail de l'utilisateur
     */
    public String getCourriel() {
        return courriel;
    }

    /**
     * Retourne le numéro de téléphone de l'utilisateur.
     *
     * @return le numéro de téléphone de l'utilisateur
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Retourne la liste des intérêts de l'utilisateur.
     *
     * @return la liste des intérêts de l'utilisateur
     */
    public ArrayList<Interet> getInteret() {
        return interet;
    }

    /**
     * Retourne la liste des utilisateurs qui suivent cet utilisateur.
     *
     * @return la liste des utilisateurs qui suivent cet utilisateur
     */
    public ArrayList<Utilisateur> getFollowers() {
        return followers;
    }

    /**
     * Retourne la liste des activités de l'utilisateur.
     *
     * @return la liste des activités de l'utilisateur
     */
    public ArrayList<Activite> getActivite() {
        return activite;
    }

    /**
     * Retourne la liste des robots de l'utilisateur.
     *
     * @return la liste des robots de l'utilisateur
     */
    public ArrayList<Robot> getListeRobot() {
        return liste_robot;
    }

    /**
     * Retourne la liste des notifications de l'utilisateur.
     *
     * @return la liste des notifications de l'utilisateur
     */
    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    /**
     * Définit le nom de l'utilisateur.
     *
     * @param nom le nom de l'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le prénom de l'utilisateur.
     *
     * @param prenom le prénom de l'utilisateur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Définit le mot de passe de l'utilisateur.
     *
     * @param mot_de_passe le mot de passe de l'utilisateur
     */
    public void setMotDePasse(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    /**
     * Définit l'adresse e-mail de l'utilisateur.
     *
     * @param courriel l'adresse e-mail de l'utilisateur
     */
    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    /**
     * Définit le numéro de téléphone de l'utilisateur.
     *
     * @param telephone le numéro de téléphone de l'utilisateur
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Définit la liste des intérêts de l'utilisateur.
     *
     * @param interet la liste des intérêts de l'utilisateur
     */
    public void setInteret(ArrayList<Interet> interet) {
        this.interet = interet;
    }

    /**
     * Supprime un follower de la liste des followers de l'utilisateur.
     *
     * @param pseudo le pseudo du follower à supprimer
     */
    public void removeFollowers(String pseudo) {
        for (Utilisateur user : followers) {
            if (user.getFollowers().equals(pseudo)) {
                followers.remove(user);
                break;
            }
        }
    }

    /**
     * Ajoute un utilisateur à la liste des followers.
     *
     * @param pseudo le pseudo de l'utilisateur à suivre
     */
    public void suivreUtilisateur(String pseudo) {
        for (Utilisateur user : followers) {
            if (user.getFollowers().equals(pseudo)) {
                System.out.println("Vous suivez déjà cet utilisateur.");
                break;
            } else {
                followers.add(user);
            }
        }
    }

    /**
     * Ajoute un robot à la liste des robots de l'utilisateur.
     *
     * @param robot le robot à ajouter
     */
    public void ajouterRobot(Robot robot) {
        liste_robot.add(robot);
    }

    /**
     * Supprime un robot de la liste des robots de l'utilisateur.
     *
     * @param robot le robot à supprimer
     */
    public void supprimerRobot(Robot robot) {
        liste_robot.remove(robot);
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'utilisateur.
     *
     * @return une chaîne de caractères représentant l'utilisateur
     */
    @Override
    public String toString() {
        StringBuilder followersIds = new StringBuilder();
        if (followers != null) {
            for (Utilisateur follower : followers) {
                if (follower != null) {
                    followersIds.append(follower.getIdentifiant()).append(" ");
                }
            }
        }

        return "identifiant : " + identifiant + '\n' +
                "nom : " + nom + '\n' +
                "prenom : " + prenom + '\n' +
                "courriel : " + courriel + '\n' +
                "telephone : " + telephone + '\n' +
                "compagnie : " + compagnie + '\n' +
                "interets : " + interet + '\n' +
                "followers : " + followersIds.toString().trim() + '\n' +
                "activites : " + activite + '\n';
    }
    public String toStringUtilisateur() {
        StringBuilder followersIds = new StringBuilder();
        if (followers != null) {
            for (Utilisateur follower : followers) {
                if (follower != null) {
                    followersIds.append(follower.getIdentifiant()).append(" ");
                }
            }
        }

        return "identifiant : " + identifiant + '\n' +
                "nom : " + nom + '\n' +
                "prenom : " + prenom + '\n' ;

    }

    public String toStringInteret() {
        return  "interets : " + interet ;
    }

    public String toStringActivite() {
        return  "activite : " + activite + '\n' ;
    }

    public String toStringFollowers() {
        return  "utilisateur : " + followers + '\n' ;
    }



    public boolean isEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

    public void setEmailNotificationsEnabled(boolean emailNotificationsEnabled) {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
    }

    public String utilisateur() {
        StringBuilder followersIds = new StringBuilder();
        if (followers != null) {
            for (Utilisateur follower : followers) {
                if (follower != null) {
                    followersIds.append(follower.getIdentifiant()).append(" ");
                }
            }
        }

        return  "identifiant : " + identifiant + '\n' +
                "nom : " + nom + '\n' +
                "prenom : " + prenom + '\n' +
                "courriel : " + courriel + '\n' +
                "telephone : " + telephone + '\n' +
                "compagnie : " + compagnie + '\n' +
                "interets : " + interet + '\n' +
                "followers : " + followersIds.toString().trim() + '\n' +
                "activites : " + activite + '\n';
    }


}
