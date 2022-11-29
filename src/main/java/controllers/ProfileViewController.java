package controllers;

import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import start.DataInitializable;

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

    @Override
    public void initializeData(User user){
        usernameField.setPromptText(user.getUsername());
        // method for not showing the password but only the "*"
        StringBuffer passPrivacy=new StringBuffer();
        for(int i=0; i< user.getPassword().length();i++)
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
    }

    public void resetUsername(){
        //TODO change username
    }
    public void resetPassword(){
        //TODO change password
    }
}
