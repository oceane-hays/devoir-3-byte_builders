package com.example.robotix;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


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

        @JsonCreator
        public Utilisateur(
                @JsonProperty("identifiant") String identifiant,
                @JsonProperty("nom") String nom,
                @JsonProperty("prenom") String prenom,
                @JsonProperty("mot_de_passe") String mot_de_passe,
                @JsonProperty("courriel") String courriel,
                @JsonProperty("telephone") String telephone,
                @JsonProperty("compagnie") String compagnie,
                @JsonProperty("emailNotificationsEnabled") boolean emailNotificationsEnabled,
                @JsonProperty("interet") ArrayList<Interet> interet,
                @JsonProperty("followers") ArrayList<Utilisateur> followers,
                @JsonProperty("activite") ArrayList<Activite> activite) {

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

        @Override
        public String toString() {
            return "Utilisateur{" +
                    "identifiant='" + identifiant + '\'' +
                    ", nom='" + nom + '\'' +
                    ", prenom='" + prenom + '\'' +
                    ", mot_de_passe='" + mot_de_passe + '\'' +
                    ", courriel='" + courriel + '\'' +
                    ", telephone='" + telephone + '\'' +
                    ", compagnie='" + compagnie + '\'' +
                    ", emailNotificationsEnabled=" + emailNotificationsEnabled +
                    ", interet=" + interet +
                    ", followers=" + followers +
                    ", activite=" + activite +
                    '}';
        }

        // Getters and Setters
        @JsonProperty("identifiant")
        public String getIdentifiant() { return identifiant; }

        @JsonProperty("nom")
        public String getNom() { return nom; }

        @JsonProperty("prenom")
        public String getPrenom() { return prenom; }

        @JsonProperty("mot_de_passe")
        public String getMotDePasse() { return mot_de_passe; }

        @JsonProperty("courriel")
        public String getCourriel() { return courriel; }

        @JsonProperty("telephone")
        public String getTelephone() { return telephone; }

        @JsonProperty("compagnie")
        public String getCompagnie() { return compagnie; }



        @JsonProperty("interet")
        public ArrayList<Interet> getInteret() { return interet; }

        @JsonProperty("followers")
        public ArrayList<Utilisateur> getFollowers() { return followers; }

        @JsonProperty("activite")
        public ArrayList<Activite> getActivite() { return activite; }

        @JsonProperty("liste_robot")
        public ArrayList<Robot> getListeRobot() { return liste_robot; }

        @JsonProperty("notifications")
        public ArrayList<Notification> getNotifications() { return notifications; }

        public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }

        public void setNom(String nom) { this.nom = nom; }

        public void setPrenom(String prenom) { this.prenom = prenom; }

        public void setMotDePasse(String mot_de_passe) { this.mot_de_passe = mot_de_passe; }

        public void setCourriel(String courriel) { this.courriel = courriel; }

        public void setTelephone(String telephone) { this.telephone = telephone; }

        public void setCompagnie(String compagnie) { this.compagnie = compagnie; }


        public void setEmailNotificationsEnabled(boolean emailNotificationsEnabled) { this.emailNotificationsEnabled = emailNotificationsEnabled; }

        public void setInteret(ArrayList<Interet> interet) { this.interet = interet; }

        public void setFollowers(ArrayList<Utilisateur> followers) { this.followers = followers; }

        public void setActivite(ArrayList<Activite> activite) { this.activite = activite; }

        public void setListeRobot(ArrayList<Robot> liste_robot) { this.liste_robot = liste_robot; }

        public void setNotifications(ArrayList<Notification> notifications) { this.notifications = notifications; }


        public void removeFollowers(String pseudo) {
            for (Utilisateur user : followers) {
                if (user.getFollowers().equals(pseudo)) {
                    followers.remove(user);
                    break;
                }
            }
        }

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

        public void ajouterRobot(Robot robot) {liste_robot.add(robot);}

        public void supprimerRobot(Robot robot) {liste_robot.remove(robot);}


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


    @JsonProperty("emailNotificationsEnabled")
    public boolean isEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }



}
