package controllers;

import business.NftHubFactory;
import business.UserService;
import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import start.DataInitializable;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileViewController implements Initializable, DataInitializable<User> {
    @FXML
    private Label titleLabel;
    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private ImageView imageField;
    @FXML
    private Label alertLabel;
    @FXML
    private Button resetUsernameButton;
    @FXML
    private Button resetPasswordButton;


    private UserService userService;

    private User thisUser;

    @Override
    public void initializeData(User user) {
        thisUser = user;
        usernameField.setPromptText(user.getUsername());
        // method for not showing the password but only the "*"
        StringBuffer passPrivacy = new StringBuffer();
        for (int i = 0; i < user.getPassword().length(); i++)
            passPrivacy.append("*");

        passwordField.setPromptText(passPrivacy.toString());

        // getting the image from path
        Image profileImage = new Image("data/profile-images/Grimm.jpg");
        imageField.setImage(profileImage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleLabel.setText("My Profile");
        usernameLabel.setText("Reset your Username");
        passwordLabel.setText("Rest your Password");

        NftHubFactory factory = NftHubFactory.getInstance();
        userService = factory.getUserService();

        resetUsernameButton.disableProperty().bind(
                usernameField.textProperty().isEmpty());
        resetPasswordButton.disableProperty().bind(passwordField.textProperty().isEmpty());
    }

    public void resetUsername() throws FileNotFoundException {

        if (userService.resetUsername(usernameField.getText(), thisUser.getUsername()))
            alertLabel.setText("successful operation");
        else alertLabel.setText("This username already Exist, try another");
    }

    public void resetPassword() throws FileNotFoundException {
        if (userService.resetPassword(passwordField.getText(), thisUser.getUsername()))
            alertLabel.setText("successful operation");
    }
}
