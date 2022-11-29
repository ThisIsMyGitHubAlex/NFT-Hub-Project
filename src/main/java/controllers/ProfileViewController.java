package controllers;

import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import start.DataInitializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileViewController implements Initializable, DataInitializable<User> {
    @FXML
    private Label titleLabel;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    titleLabel.setText("My Profile");
    /*TODO code
    * Change Username
    * Change Password
    * Add profile image
    *  */




    }
}
