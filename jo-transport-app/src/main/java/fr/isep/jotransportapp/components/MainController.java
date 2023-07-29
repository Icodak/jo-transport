package fr.isep.jotransportapp.components;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    private TitleTextField departure;

    @FXML
    private TitleTextField arrival;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        departure.setTitle("Départ");
        departure.getTextProperty().addListener(System.out::println);

        arrival.setTitle("Arrivée");
        arrival.getTextProperty().addListener(System.out::println);
    }
}