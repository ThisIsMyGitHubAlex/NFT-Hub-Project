package controllers;

import domain.Admin;
import domain.Guest;
import domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import start.DataInitializable;
import viewManagement.MenuElement;
import viewManagement.ViewDispatcher;

import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable, DataInitializable<User> {
    private static final MenuElement MENU_HOME = new MenuElement("Home", "home-view");

    private static final MenuElement[] MENU_ADMIN = {new MenuElement("Profile", "2")};

    private static final MenuElement[] MENU_GUEST = {
            new MenuElement("Profile", "2"),
            new MenuElement("Library","library-view")};

    @FXML
    private VBox menuBar;

    private ViewDispatcher dispatcher;

    private User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initializeData(User user) {
        this.user = user;
        menuBar.getChildren().addAll(createButton(MENU_HOME));
        menuBar.getChildren().add(new Separator());

        if (user instanceof Admin) {
            for (MenuElement menu : MENU_ADMIN) {
                menuBar.getChildren().add(createButton(menu));
            }
        }
        if (user instanceof Guest) {
            for (MenuElement menu : MENU_GUEST) {
                menuBar.getChildren().add(createButton(menu));
            }
        }
    }

    private Button createButton(MenuElement viewItem) {
        Button button = new Button(viewItem.getName());
        button.setStyle("-fx-background-color: transparent; -fx-font-size: 14;");
        button.setTextFill(Paint.valueOf("white"));
        button.setPrefHeight(10);
        button.setPrefWidth(180);
        button.setOnAction((ActionEvent event) -> {
            dispatcher.renderView(viewItem.getView(), user);
        });
        return button;
    }

    @FXML
    public void logoutAction(MouseEvent event) {
        dispatcher.logout();
    }


}
