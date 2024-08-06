package com.example.robotix;

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



        public String getIdentifiant() { return identifiant;}

        public String getNom() { return nom;}

        public String getPrenom() { return prenom;}

        public String getMotDePasse() {return mot_de_passe;}

        public String getCourriel() { return courriel;}

        public String getTelephone() { return telephone;}

        public ArrayList<Interet> getInteret() { return interet;}

        public ArrayList<Utilisateur> getFollowers() { return followers;}

        public ArrayList<Activite> getActivite() { return activite;}

        public ArrayList<Robot> getListeRobot() {return liste_robot;}

        public ArrayList<Notification> getNotifications() { return notifications;}

        public void setNom(String nom) { this.nom = nom;}

        public void setPrenom(String prenom) {this.prenom = prenom;}

        public void setMotDePasse(String mot_de_passe) { this.mot_de_passe = mot_de_passe;}

        public void setCourriel(String courriel) {this.courriel = courriel;}

        public void setTelephone(String telephone) {this.telephone = telephone;}

        public void setInteret(ArrayList<Interet> interet) {this.interet = interet;}


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



    public boolean isEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

    public void setEmailNotificationsEnabled(boolean emailNotificationsEnabled) {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
    }



}
