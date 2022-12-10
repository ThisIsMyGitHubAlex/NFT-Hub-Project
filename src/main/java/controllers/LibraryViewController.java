package controllers;

import business.BusinessException;
import business.NftHubFactory;
import business.NftService;
import business.UserService;
import domain.NFT;
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
import javafx.scene.image.ImageView;
import start.DataInitializable;
import viewManagement.ViewDispatcher;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LibraryViewController implements Initializable, DataInitializable<User> {

    @FXML
    private TableView<NFT> NftTable;
    @FXML
    private TableColumn<NFT, ImageView> imageColumn;
    @FXML
    private TableColumn<NFT, String> nameColumn;
    @FXML
    private TableColumn<NFT, Double> priceColumn;
    @FXML
    private TableColumn<NFT, String> onSaleColumn;
    @FXML
    private TableColumn<NFT, String> ownerColumn;
    @FXML
    private TableColumn<NFT, Button> manageColumn;

    private ViewDispatcher dispatcher;
    private User user;
    NftService nftService;


    public LibraryViewController() {
        dispatcher = ViewDispatcher.getInstance();
        NftHubFactory factory = NftHubFactory.getInstance();
         this.nftService = factory.getNftService();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        imageColumn.setCellValueFactory(new PropertyValueFactory<>("NFT"));
        imageColumn.setStyle("-fx-alignment: CENTER;");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        nameColumn.setStyle("-fx-alignment: CENTER;");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        priceColumn.setStyle("-fx-alignment: CENTER;");
        onSaleColumn.setCellValueFactory(new PropertyValueFactory<>("On Sale"));
        onSaleColumn.setStyle("-fx-alignment: CENTER;");
        ownerColumn.setCellValueFactory(new PropertyValueFactory<>("Owner"));
        ownerColumn.setStyle("-fx-alignment: CENTER;");
        // button column
        manageColumn.setStyle("-fx-alignment: CENTER;");
        manageColumn.setCellValueFactory((TableColumn.CellDataFeatures<NFT, Button> param) -> {
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
            int imagesCounter = nftService.getImageCounter();
            System.out.println("i got the counter: "+ imagesCounter);

            List<NFT> NftList = nftService.getNftList();
            // This is necessary because setItems require an ObservableList as a parameter
            // This is how to convert a list into a ObservableList

            // TODO try to solve this Sad Ending
            ObservableList<NFT> observableUserList = FXCollections.observableArrayList(NftList);
            NftTable.setItems(observableUserList);
        } catch (BusinessException e) {
            dispatcher.renderError(e);
        }
    }
}
