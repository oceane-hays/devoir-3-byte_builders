package com.example.robotix;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Représente une notification envoyée à un utilisateur.
 * La notification contient un message et un identifiant de destinataire.
 */
public class Notification {

    private String message;
    private String recipientId;

    /**
     * Crée une nouvelle notification avec un message et un identifiant de destinataire.
     *
     * @param message Le message de la notification.
     * @param recipientId L'identifiant du destinataire de la notification.
     */
    public Notification(String message, String recipientId) {
        this.message = message;
        this.recipientId = recipientId;
    }

    /**
     * Obtient le message de la notification.
     *
     * @return Le message de la notification.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la notification.
     *
     * @return Une chaîne de caractères décrivant la notification.
     */
    @Override
    public String toString() {
        return "Notification : " + '\n' +
                "message : " + message + '\n' +
                "de : " + recipientId + '\n';
    }

}
