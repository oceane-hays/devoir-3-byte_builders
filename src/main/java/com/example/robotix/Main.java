package com.example.robotix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Point d'entrée de l'application Robotix.
 * Cette classe configure et lance l'application JavaFX pour l'interface graphique
 * et permet également l'exécution du système en ligne de commande.
 */
public class Main extends Application {

    /**
     * Méthode principale de démarrage de l'application JavaFX.
     * Charge l'interface utilisateur à partir du fichier FXML et configure la scène.
     *
     * @param stage Le stage principal de l'application.
     * @throws IOException Si un problème survient lors du chargement du fichier FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 400);
        stage.setTitle("ROBOTIX!");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Méthode principale de l'application.
     * Elle démarre soit l'interface graphique JavaFX, soit le système en ligne de commande
     * en fonction des arguments fournis.
     *
     * @param args Arguments de ligne de commande.
     */
    public static void main(String[] args) {
        //launch();
        executeCommandLineSystem(args);
    }

    /**
     * Exécute le système en ligne de commande.
     * Cette méthode peut être utilisée pour lancer des opérations en ligne de commande
     * comme spécifié dans la classe `RobotixMain`.
     *
     * @param args Arguments de ligne de commande.
     */
    private static void executeCommandLineSystem(String[] args) {
        // Ajoutez votre code de système en ligne de commande ici
        // Par exemple, si vous avez une classe CommandLineSystem avec une méthode statique run :
        RobotixMain.run(args);
    }

}
