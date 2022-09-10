package controllers;

import domain.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import start.DataInitializable;

public class HomeViewController implements DataInitializable<User> {
    @FXML
    private Label homeLabel;

    private String username, password;
    @Override
    public void initializeData(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        homeLabel.setText("Benvenuto "+ username);
    }
}
