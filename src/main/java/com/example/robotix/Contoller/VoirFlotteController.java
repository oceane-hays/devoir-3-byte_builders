package com.example.robotix.Contoller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;

public class VoirFlotteController {
    // -------------------------------------------------------------------------------------------------------- MENU BAR
    @FXML
    private Button quitButton;
    @FXML
    private Button rechercheButton;
    @FXML
    private SplitMenuButton menuBar;
    @FXML
    private MenuItem gestionSuiveurs;
    @FXML
    private MenuItem voirProfil;
    @FXML
    private MenuItem voirActivite;
    @FXML
    private MenuItem achatComposante;
    @FXML
    private MenuItem voirActiviteDisponible;
    @FXML
    private MenuItem gestionFlotte;
    @FXML
    private MenuItem gestionInteret;


    @FXML
    private void quitButtonAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void rechercheAction(ActionEvent event) throws Exception {
        handleButtonAction(event,"recherche.fxml");
    }

    @FXML
    private void gestionSuiveursAction(ActionEvent event) throws Exception {
        handleButtonAction(event,"voirSuiveur.fxml");
    }

    @FXML
    private void voirProfilAction(ActionEvent event) throws Exception {
        handleButtonAction(event,"profil.fxml");
    }

    @FXML
    private void voirActiviteAction(ActionEvent event) throws Exception {
        handleButtonAction(event,"voirActivite.fxml");
    }

    @FXML
    private void achatConposanteAction(ActionEvent event) throws Exception {
        handleButtonAction(event,"achatComposante.fxml");
    }

    @FXML
    private void voirActiviteDisposAction(ActionEvent event) throws Exception {
        handleButtonAction(event,"voirActiviteDisponible.fxml");
    }

    @FXML
    private void gestionFlotteAction(ActionEvent event) throws Exception {
        handleButtonAction(event,"voirFlotte.fxml");
    }

    @FXML
    private void gestionInteretAction(ActionEvent event) throws Exception {
        handleButtonAction(event,"voirInteret.fxml");
    }


    // --------


    private void handleButtonAction(ActionEvent event, String pathNam) throws Exception {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(pathNam));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
