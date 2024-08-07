package com.example.robotix;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe utilitaire pour la validation des entrées utilisateur.
 */
public class Validation {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Valide l'adresse e-mail fournie.
     *
     * @param email L'adresse e-mail à valider.
     * @return L'adresse e-mail valide.
     */
    public static String validerEmail(String email) {
        if (email.matches("(?i)^[A-Z0-9+_.-]+@[A-Z0-9.-]+$")) {
            return email;
        }
        System.out.println("Invalide. Veuillez réessayer.");
        return validerEmail(scanner.nextLine());
    }

    /**
     * Valide le pseudo fourni.
     *
     * @param username Le pseudo à valider.
     * @return Le pseudo valide.
     */
    public static String validerPseudo(String username) {
        if (username.matches("^[A-Za-z0-9_]+$")) {
            return username;
        }
        System.out.println("Invalide. Veuillez réessayer.");
        return validerPseudo(scanner.nextLine());
    }

    /**
     * Valide le numéro de téléphone fourni.
     *
     * @param phoneNum Le numéro de téléphone à valider.
     * @return Le numéro de téléphone valide.
     */
    public static String validerNumero(String phoneNum) {
        if (phoneNum.matches("^[0-9]{10}$")) {
            return phoneNum;
        }
        System.out.println("Invalide. Veuillez réessayer.");
        return validerNumero(scanner.nextLine());
    }

    /**
     * Valide le mot de passe fourni.
     * Le mot de passe doit contenir au moins 8 caractères, une lettre majuscule, une lettre minuscule et un chiffre.
     *
     * @param motDePasse Le mot de passe à valider.
     * @return Le mot de passe valide.
     */
    public static String validerMotDePasse(String motDePasse) {
        if (motDePasse.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")) {
            return motDePasse;
        }
        System.out.println("Mot de passe non valide. Il doit contenir au moins 8 caractères, une lettre majuscule, une lettre minuscule et un chiffre.");
        return validerMotDePasse(scanner.nextLine());
    }

    /**
     * Valide un choix numérique en vérifiant qu'il est dans la plage spécifiée.
     *
     * @param max La valeur maximale valide pour le choix.
     * @return Le choix valide.
     */
    public static int validerChoix(int max) {
        int choice;

        try {
            choice = Integer.parseInt(scanner.nextLine());

            if (choice < 0 || choice > max) {
                System.out.println("Entrée invalide, veuillez choisir un nombre entre 0 et " + max);
                choice = validerChoix(max);
            }
        } catch (InputMismatchException e) {
            System.out.println("Veuillez entrer un nombre.");
            choice = validerChoix(max);
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
            choice = validerChoix(max);
        }

        return choice;
    }
}
