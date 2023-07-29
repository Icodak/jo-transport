package fr.isep.jotransportapp;

import fr.isep.jotransportapp.components.MainController;
import fr.isep.jotransportapp.viewModels.MainVM;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final String APP_NAME = "Simulateur de transports en commun";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/isep/jotransportapp/components/MainWindow.fxml"));
        Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);

        MainVM viewModel = new MainVM();
        MainController mainController = loader.getController();
        mainController.bind(viewModel);
        stage.setTitle(APP_NAME);
        stage.setScene(scene);
        stage.show();
    }

}