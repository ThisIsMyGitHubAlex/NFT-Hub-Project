package start;

import javafx.application.Application;
import javafx.stage.Stage;
import viewManagement.ViewDispatcher;
import viewManagement.ViewException;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ViewException {
        ViewDispatcher.getInstance().loginView(stage);


    }

    public static void main(String[] args) throws IOException {

        launch();

    }
}