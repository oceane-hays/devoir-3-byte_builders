package com.example.robotix;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Validation {
    private static Scanner scanner = new Scanner(System.in);
    public static String validerEmail(String email) {
        if (email.matches("(?i)^[A-Z0-9+_.-]+@[A-Z0-9.-]+$")) {
            return email;
        }
        System.out.println("Invalide. Veuillez réésayer.");
        return validerEmail(scanner.nextLine());
    }

    public static String validerPseudo(String username) {
        if (username.matches("^[A-Za-z0-9_]+$")) {
            return username;
        }
        System.out.println("Invalide. Veuillez réésayer.");
        return validerPseudo(scanner.nextLine());
    }

    public static String validerNumero(String phoneNum) {
        if (phoneNum.matches("^[0-9]{10}$")) {
            return phoneNum;
        }
        System.out.println("Invalide. Veuillez réésayer.");
        return validerNumero(scanner.nextLine());
    }

    public static String validerMotDePasse(String motDePasse) {
        if (motDePasse.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$")) {
            return motDePasse;
        }
        System.out.println("Mot de passe non valide. Il doit contenir au moins 8 caractères, une lettre majuscule, une lettre minuscule et un chiffre.");
        return validerMotDePasse(scanner.nextLine());
    }

    // TODO A RÉÉCRIRE
    public static int validerChoix(int max) {
        int choice;

        try {
            choice = Integer.parseInt(scanner.nextLine());

            if (choice < 0 || choice > max) {
                System.out.println("Entré invalide, veuillez choisir un nombre entre 0 et " + max);
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
