package com.example.robotix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 400);
        stage.setTitle("ROBOTIX!");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
        executeCommandLineSystem(args);
    }

    private static void executeCommandLineSystem(String[] args) {
        // Ajoutez votre code de système en ligne de commande ici
        // Par exemple, si vous avez une classe CommandLineSystem avec une méthode statique run :
        RobotixMain.run(args);

        if (args.length == 0) {
            Notification.showErrorNotification("Error", "No command line arguments provided!");
        } else {
            // Process the arguments and potentially show a success notification
            RobotixMain.run(args);
            Notification.showNotification("Success", "Command executed successfully!");
        }
    }


}