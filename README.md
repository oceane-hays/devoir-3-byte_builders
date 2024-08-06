# Robotix

## Description du projet
Robotix est une application de gestion de robots, de composants, de fournisseurs et d'activités dans divers secteurs tels que l'industrie, la santé et l'agriculture. L'application offre une interface en ligne de commande permettant aux utilisateurs d'effectuer diverses opérations de gestion de manière efficace.

## Fonctionnalités implémentées
- **Créer un compte** : Inscription des nouveaux utilisateurs avec vérification par email.
- **Se connecter** : Authentification des utilisateurs existants.
- **Modifier son profil** : Mise à jour des informations personnelles de l'utilisateur.
- **Enregistrer un robot** : Ajout de nouveaux robots dans le système.
- **Supprimer un robot** : Retrait des robots existants.
- **Afficher l'état de mes robots** :
  - Vue générale : Affichage du nom, type et niveau de batterie des robots.
  - Vue complète : Affichage du numéro de série, position, vitesse, consommation CPU et mémoire.
- **Trouver une composante** :
  - Liste/Rechercher : Affichage du nom et type des composants.
  - Fiche : Affichage de toutes les informations sur les composants.
- **Acheter une composante** : Achat de composants pour les robots.
- **Trouver un fournisseur** :
  - Liste/Rechercher : Affichage du nom et des types de composants des fournisseurs.
  - Fiche : Affichage de toutes les informations publiques des fournisseurs.
- **S'inscrire ou se désinscrire à une activité** : Gestion des inscriptions aux activités.
- **Voir ses notifications** : Affichage des notifications reçues par l'utilisateur.
- **Voir ses composantes** : Affichage des composants possédés par l'utilisateur.
- **Enregistrer une composante** : Ajout de nouveaux composants.
- **Modifier une composante** : Mise à jour des informations sur les composants.
- **Supprimer une composante** : Retrait des composants existants.

## Organisation des fichiers
/ -- Racine du projet
├── exigences/ -- Dossier contenant les artefacts de l'exigence (diagramme de cas d'utilisation)
├── analyse/ -- Dossier contenant les artefacts de l'analyse (diagramme d'activités)
├── conception/ -- Dossier contenant les artefacts de la conception (diagramme de classes et diagramme de séquence)
├── application/ -- Dossier contenant tous les artefacts de l'implémentation
│ ├── doc/ -- Dossier contentant la documentation de l'application générée avec Javadoc
│ ├── src/ -- Dossier contentant le code source de l'application
│ ├── test/ -- Dossier contentant les tests unitaires JUnit
│ └── robotix.jar -- Fichier exécutable JAR de l'application
└── README.md
└── rapport.html

## Description des données de départ
- **10 utilisateurs**
- **5 fournisseurs**
- **2 robots pour chaque utilisateur**
- **5 composants pour chaque fournisseur** (dont au moins un par type)
- **5 activités par utilisateur** (une non débutée, une en cours, une terminée)

### Comptes utilisateurs de départ
- **Utilisateur 1** :
  - Nom d'utilisateur : user1
  - Mot de passe : password1
- **Utilisateur 2** :
  - Nom d'utilisateur : user2
  - Mot de passe : password2
- ...

## Instructions pour installer le projet
1. Assurez-vous d'avoir **Java** et **Maven** installés.
2. Clonez le dépôt GitHub : `git clone [lien-du-depot]`
3. Naviguez dans le répertoire du projet : `cd robotix`
4. Compilez le projet avec Maven : `mvn clean install`

## Instructions pour exécuter l'application
1. Exécutez le fichier JAR : `java -jar target/robotix.jar`
2. Suivez les instructions affichées pour utiliser l'application.

## Documentation
La documentation JavaDoc est disponible dans le répertoire `application/doc`.

### Exigences matérielles
- **Système d'exploitation** : Windows, macOS ou Linux
- **Java** : Version 8 ou supérieure
- **Maven** : Version 3.6 ou supérieure
- **RAM** : 2 Go minimum
- **Stockage** : 100 Mo d'espace libre

### Équipe de développement
- **Lea Hemidj** : lea.hemidj@umontreal.ca
- **Sophie Bernard** : sophie.bernard-doucet@umontreal.ca
- **Insafe Kibboua** : insafe.kibboua@umontreal.ca
- **Océane Hays** : hays.oceane@umontreal.ca

Pour toute question ou assistance, veuillez contacter un des membres de l'équipe de développement.
