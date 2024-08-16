package com.example.robotix;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * La classe {@code Notification} représente une notification contenant un message et un identifiant du destinataire.
 */
public class Notification {

    private String message;
    private String recipientId;

    /**
     * Constructeur paramétré de la classe {@code Notification}.
     *
     * @param message      Le message de la notification.
     * @param recipientId  L'identifiant du destinataire de la notification.
     */
    public Notification(String message, String recipientId) {
        this.message = message;
        this.recipientId = recipientId;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Notification : " + '\n' +
                "message : " + message + '\n' +
                "de : " + recipientId + '\n';
    }

}
