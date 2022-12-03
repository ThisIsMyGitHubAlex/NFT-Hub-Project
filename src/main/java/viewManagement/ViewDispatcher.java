package viewManagement;

import domain.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import start.DataInitializable;

import java.io.IOException;

public class ViewDispatcher {
    private static final String FXML_SUFFIX = ".fxml";
    private static final String RESOURCE_BASE = "/views/";
    private static ViewDispatcher instance = new ViewDispatcher();


    private Stage stage;
    private BorderPane layout;

    private ViewDispatcher() {
    }

    public static ViewDispatcher getInstance() {
        return instance;
    }


    public void loginView(Stage stage) throws ViewException {
        this.stage = stage;
        Parent loginView = loadView("login-view").getView();
        Scene scene = new Scene(loginView);
        stage.setScene(scene);
        stage.show();
    }

    public void loggedIn(User user) {
        try {
            View<User> layoutView = loadView("layout");
            // Inizializza l'utente nel controllore.
            // Utilizzato per la visualizzazione dei menu a seconda se e' docente o studente
            DataInitializable<User> layoutController = layoutView.getController();
            layoutController.initializeData(user);

            layout = (BorderPane) layoutView.getView();
            //Anche in questo caso viene passato l'utente perche' nella vista di
            //benvenuto il testo varia a seconda se e' docente o user
            renderView("home-view", user);
            Scene scene = new Scene(layout);
            // qualcosa per lo stile che non funziona per motivi strani
            // scene.getStylesheets().add(getClass().getResource(RESOURCE_BASE+"views/styles.css").toExternalForm());

            stage.setScene(scene);
        } catch (ViewException e) {
            renderError(e);
        }
    }

    public void logout() {
        try {
            Parent loginView = loadView("login-view").getView();
            Scene scene = new Scene(loginView);
            stage.setScene(scene);
        } catch (ViewException e) {
            renderError(e);
        }
    }

    public <T> void renderView(String viewName, T data) {
        try {
            View<T> view = loadView(viewName);
            DataInitializable<T> controller = view.getController();
            controller.initializeData(data);
            layout.setCenter(view.getView());
        } catch (ViewException e) {
            renderError(e);
        }
    }

    public void renderError(Exception e) {
        e.printStackTrace();
        System.exit(1);
    }

    private <T> View<T> loadView(String viewName) throws ViewException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(RESOURCE_BASE + viewName + FXML_SUFFIX));
            Parent parent = (Parent) loader.load();
            return new View<>(parent, loader.getController());

        } catch (IOException ex) {
            throw new ViewException(ex);
        }
    }
}
