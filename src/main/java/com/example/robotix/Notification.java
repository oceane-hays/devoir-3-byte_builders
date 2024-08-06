package com.example.robotix;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Notification {

    private String message;
    private String recipientId;

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
