package controllers;

import business.BusinessException;
import business.NftHubFactory;
import business.UserService;
import business.fileImplementation.FileNftHubBusinessFactory;
import domain.Guest;
import domain.User;
import javafx.fxml.Initializable;
import start.DataInitializable;
import viewManagement.ViewDispatcher;

import java.net.URL;
import java.util.ResourceBundle;



public class LoginViewController implements DataInitializable<User>, Initializable {

    private UserService userService;

    private ViewDispatcher dispatcher;

    public LoginViewController() {
        NftHubFactory factory = NftHubFactory.getInstance();
        userService = factory.getUserService();

        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    public void goToScene2(){

        Guest g = new Guest("a","a");
        ViewDispatcher.getInstance().loggedIn(g);
        ViewDispatcher.getInstance().renderView("2",g);
    }

    public void loginAction() throws BusinessException {
        User user = userService.authenticate("a","a");
        dispatcher.loggedIn(user);
    }


}
