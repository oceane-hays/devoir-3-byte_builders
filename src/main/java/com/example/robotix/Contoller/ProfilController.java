package com.example.robotix.Contoller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ProfilController {
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


    // -------------------------------------------------------------------------------------------------------- MENU BAR

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

    @FXML
    private void quitButtonAction(ActionEvent event) {
        Platform.exit();
    }


    // ---------------------------------------------------------------------------------------------------------- PROFIL
    @FXML
    private Label nomUser;
    @FXML
    private Label phoneUser;
    @FXML
    private Label emailUser;
    @FXML
    private Label mdpUser;
    @FXML
    private Label compagnieUser;
    @FXML
    private Button modifierProfil;


    private void modifierProfilAction(ActionEvent event) throws Exception {
        handleButtonAction(event,"modifierProfil.fxml");
    }

    private void handleButtonAction(ActionEvent event, String pathNam) throws Exception {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(pathNam));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
