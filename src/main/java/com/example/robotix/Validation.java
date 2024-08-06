package com.example.robotix;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Validation {
    static Scanner scanner;
    public static String validerEmail(String email) {
        if (email.matches("(?i)^[A-Z0-9+_.-]+@[A-Z0-9.-]+$")) {
            return email;
        }
        System.out.println("not valid, please enter anew");
        return validerEmail(scanner.nextLine());
    }

    public static String validerPseudo(String username) {
        if (username.matches("^[A-Za-z0-9_]+$")) {
            return username;
        }
        System.out.println("not valid, please enter anew");
        return validerPseudo(scanner.nextLine());
    }

    public static String validerNumero(String phoneNum) {
        if (phoneNum.matches("^[0-9]{10}$")) {
            return phoneNum;
        }
        System.out.println("not valid, please enter anew");
        return validerNumero(scanner.nextLine());
    }

    public static int validerChoix(int max) {
        //for taking valid int inputs from 0-bar
        int choice;

        try{
            choice = parseInt(scanner.nextLine());

            if(choice < 0 || choice > max) {
                System.out.println("Entré invalide, veuillez choisir un nombre entre 0 et " + max);
                choice = validerChoix(max);
            }
        } catch (InputMismatchException e) {
            System.out.println("Veuillez entrer un nombre.");
            choice = validerChoix(max);
        }

        return choice;
    }
}
