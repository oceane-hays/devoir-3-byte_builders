package com.example.robotix.Contoller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;
public class LoginController implements Initializable {
    @FXML
    private Label connectMessageError;
    @FXML
    private ImageView logoImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField enterPseudo;
    @FXML
    private PasswordField enterMotDePasse;
    @FXML
    private Button inscriptionUtilisateur;



    @Override
    public void initialize(URL url, ResourceBundle ressource) {
        File logoFile = new File("/robotix/image/logo.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);

        File lockFile = new File("/robotix/image/cadena.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void inscriptionUtilisateurAction(ActionEvent event) throws Exception {
        handleButtonAction(event,"formUser.fxml");
    }


    public void connectionBoutonAction(ActionEvent event) throws Exception {
        if (!enterPseudo.getText().isBlank() && !enterMotDePasse.getText().isBlank()){
            validateConnection();
            handleButtonAction(event,"profil.fxml");
        } else {
            connectMessageError.setText("Veuillez entrez le pseudo et le mot de passe.");
        }
    }

    public void validateConnection() {}

    private void handleButtonAction(ActionEvent event, String pathNam) throws Exception {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(pathNam));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}