package controllers;

import business.NftHubFactory;
import business.NftService;
import business.UserService;
import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import start.DataInitializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ShopViewController implements Initializable, DataInitializable<User> {
    @FXML
    private TableView nftTable;

    private int imagesCounter;

    private NftHubFactory factory;
    private UserService userService;
    private NftService nftService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NftHubFactory factory = NftHubFactory.getInstance();
        userService = factory.getUserService();
        nftService = factory.getNftService();
    }

    @Override
    public void initializeData(User user) {
        imagesCounter = nftService.getImageCounter();
        // TODO aggiungere immagini alla tabella

        /* ImageView imageView=null;
        for(int i=0; i<imagesCounter;i++){
        nftTable.getChildrenUnmodifiable().add(imageView.setImage(););
        }
        */


    }
}
