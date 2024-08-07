package com.example.robotix;

import java.util.ArrayList;

/**
 * Représente un utilisateur dans le système avec ses informations personnelles, intérêts, et activités.
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
    ArrayList<Utilisateur> followers;
    public ArrayList<Activite> activite;
    public ArrayList<Robot> liste_robot = new ArrayList<Robot>();
    public ArrayList<Notification> notifications = new ArrayList<Notification>();

    /**
     * Constructeur de la classe Utilisateur.
     *
     * @param identifiant L'identifiant unique de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     * @param prenom Le prénom de l'utilisateur.
     * @param mot_de_passe Le mot de passe de l'utilisateur.
     * @param courriel L'adresse e-mail de l'utilisateur.
     * @param telephone Le numéro de téléphone de l'utilisateur.
     * @param compagnie Le nom de la compagnie de l'utilisateur.
     * @param emailNotificationsEnabled Indique si les notifications par e-mail sont activées.
     * @param interet La liste des intérêts de l'utilisateur.
     * @param followers La liste des abonnés de l'utilisateur.
     * @param activite La liste des activités de l'utilisateur.
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

    public String getIdentifiant() { return identifiant; }

    public String getNom() { return nom; }

    public String getPrenom() { return prenom; }

    public String getMotDePasse() { return mot_de_passe; }

    public String getCourriel() { return courriel; }

    public String getTelephone() { return telephone; }

    public ArrayList<Interet> getInteret() { return interet; }

    public ArrayList<Utilisateur> getFollowers() { return followers; }

    public ArrayList<Activite> getActivite() { return activite; }

    public ArrayList<Robot> getListeRobot() { return liste_robot; }

    public ArrayList<Notification> getNotifications() { return notifications; }

    public void setNom(String nom) { this.nom = nom; }

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public void setMotDePasse(String mot_de_passe) { this.mot_de_passe = mot_de_passe; }

    public void setCourriel(String courriel) { this.courriel = courriel; }

    public void setTelephone(String telephone) { this.telephone = telephone; }

    public void setInteret(ArrayList<Interet> interet) { this.interet = interet; }

    /**
     * Supprime un utilisateur de la liste des abonnés en fonction de son pseudo.
     *
     * @param pseudo Le pseudo de l'utilisateur à supprimer.
     */
    public void removeFollowers(String pseudo) {
        for (Utilisateur user : followers) {
            if (user.getIdentifiant().equals(pseudo)) {
                followers.remove(user);
                break;
            }
        }
    }

    /**
     * Ajoute un utilisateur à la liste des abonnés si ce n'est pas déjà le cas.
     *
     * @param pseudo Le pseudo de l'utilisateur à suivre.
     */
    public void suivreUtilisateur(String pseudo) {
        for (Utilisateur user : followers) {
            if (user.getIdentifiant().equals(pseudo)) {
                System.out.println("Vous suivez déjà cet utilisateur.");
                return;
            }
        }
        // On suppose que 'pseudo' correspond à un utilisateur existant
        // Le code pour ajouter l'utilisateur à la liste des abonnés devrait être ajouté ici
    }

    /**
     * Ajoute un robot à la liste des robots de l'utilisateur.
     *
     * @param robot Le robot à ajouter.
     */
    public void ajouterRobot(Robot robot) { liste_robot.add(robot); }

    /**
     * Supprime un robot de la liste des robots de l'utilisateur.
     *
     * @param robot Le robot à supprimer.
     */
    public void supprimerRobot(Robot robot) { liste_robot.remove(robot); }

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

    /**
     * Retourne une chaîne de caractères contenant les informations de l'utilisateur sans les activités et abonnés.
     *
     * @return Une chaîne de caractères avec les informations de base de l'utilisateur.
     */
    public String toStringUtilisateur() {
        return "identifiant : " + identifiant + '\n' +
                "nom : " + nom + '\n' +
                "prenom : " + prenom + '\n';
    }

    /**
     * Retourne une chaîne de caractères contenant les intérêts de l'utilisateur.
     *
     * @return Une chaîne de caractères avec les intérêts de l'utilisateur.
     */
    public String toStringInteret() {
        return "interets : " + interet;
    }

    /**
     * Retourne une chaîne de caractères contenant les activités de l'utilisateur.
     *
     * @return Une chaîne de caractères avec les activités de l'utilisateur.
     */
    public String toStringActivite() {
        return "activites : " + activite + '\n';
    }

    /**
     * Retourne une chaîne de caractères contenant les abonnés de l'utilisateur.
     *
     * @return Une chaîne de caractères avec les abonnés de l'utilisateur.
     */
    public String toStringFollowers() {
        return "followers : " + followers + '\n';
    }

    public boolean isEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

    public void setEmailNotificationsEnabled(boolean emailNotificationsEnabled) {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
    }

    /**
     * Indique si l'objet est un utilisateur.
     *
     * @return true si l'objet est un utilisateur, sinon false.
     */
    public boolean utilisateur() {
        return true;
    }
}
