package controllers;

import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import start.DataInitializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LibraryViewController implements Initializable, DataInitializable<User> {



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void initializeData(User user) {

    }
}
