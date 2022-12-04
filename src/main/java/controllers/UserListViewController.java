package controllers;

import business.BusinessException;
import business.NftHubFactory;
import business.UserService;
import domain.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import start.DataInitializable;
import viewManagement.ViewDispatcher;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class UserListViewController implements Initializable, DataInitializable<User> {

    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, String> usernameColumn;
    @FXML
    private TableColumn<User, String> roleColumn;
    @FXML
    private TableColumn<User, Button> manageColumn;

    private UserService userService;
    private ViewDispatcher dispatcher;
    private User user;

    public UserListViewController() {

        dispatcher = ViewDispatcher.getInstance();
        NftHubFactory factory = NftHubFactory.getInstance();
        userService = factory.getUserService();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));
        usernameColumn.setStyle("-fx-alignment: CENTER;");
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("Role"));
        roleColumn.setStyle("-fx-alignment: CENTER;");
        // button column
        manageColumn.setStyle("-fx-alignment: CENTER;");
        manageColumn.setCellValueFactory((TableColumn.CellDataFeatures<User, Button> param) -> {
            final Button manageButton = new Button("Manage");
            manageButton.setOnAction((ActionEvent event) -> {
                dispatcher.renderView("manage-user-view", param.getValue());
            });

            return new SimpleObjectProperty<Button>(manageButton);
        });


    }


    @Override
    public void initializeData(User user) {

        this.user = user;
        try {
            List<User> userList = userService.getUserList();
            // This is necessary because setItems require an ObservableList as a parameter
            // This is how to conver a list into a ObservableList
            ObservableList<User> observableUserList = FXCollections.observableArrayList(userList);
            userTable.setItems(observableUserList);
        } catch (BusinessException e) {
            dispatcher.renderError(e);
        }
    }


}
