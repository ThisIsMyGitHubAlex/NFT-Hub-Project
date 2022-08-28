package controllers;

import domain.Guest;
import domain.User;
import start.DataInitializable;
import viewManagement.ViewDispatcher;

public class LoginViewController implements DataInitializable<User>{





    public void goToScene2(){

        Guest g = new Guest("a","a");
        ViewDispatcher.getInstance().loggedIn(g);
        ViewDispatcher.getInstance().renderView("2",g);
    }

}
