package fr.isep.jotransportapp;

import fr.isep.jotransportapp.Domain.MainViewModel;
import fr.isep.jotransportapp.Domain.MainViewModelImpl;
import fr.isep.jotransportapp.Presentation.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {
    public static final int WIDTH = 320;
    public static final int HEIGHT = 240;
    public static final String APP_NAME = "Simulateur de transports en commun";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Application.class.getResource("Views/MainWindow.fxml"));
        Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);

        setupBindings(loader);
        setupStyles(scene);
        stage.setTitle(APP_NAME);
        stage.setScene(scene);
        stage.show();
    }

    private void setupBindings(FXMLLoader loader) {
        MainViewModel viewModel = new MainViewModelImpl();
        MainController controller = loader.getController();
        controller.bind(viewModel);
    }

    private void setupStyles(Scene scene) {
        // Locate files
        URL styleUrl = Application.class.getResource("Styles/Main.css");

        if (styleUrl != null) {
            scene.getStylesheets().add(styleUrl.toExternalForm());
        }
    }
}