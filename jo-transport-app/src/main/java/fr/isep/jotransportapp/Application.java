package fr.isep.jotransportapp;

import fr.isep.jotransportapp.domain.MainViewModel;
import fr.isep.jotransportapp.domain.MainViewModelImpl;
import fr.isep.jotransportapp.components.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    public static final int WIDTH = 320;
    public static final int HEIGHT = 240;
    public static final String APP_NAME = "Simulateur de transports en commun";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/isep/jotransportapp/components/MainWindow.fxml"));
        Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);

        MainViewModel viewModel = new MainViewModelImpl();
        MainController controller = loader.getController();
        controller.bind(viewModel);

        stage.setTitle(APP_NAME);
        stage.setScene(scene);
        stage.show();
    }

}