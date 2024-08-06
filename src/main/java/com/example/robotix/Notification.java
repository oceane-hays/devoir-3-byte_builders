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

    public String getRecipientId() {
        return recipientId;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "message='" + message + '\'' +
                ", recipientId='" + recipientId + '\'' +
                '}';
    }

    public static void showNotification(String title, String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }

    public static void showErrorNotification(String title, String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }
}
