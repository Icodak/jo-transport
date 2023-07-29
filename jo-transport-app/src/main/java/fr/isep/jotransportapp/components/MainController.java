package fr.isep.jotransportapp.components;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    public Button addStep;
    @FXML
    public Label hint;
    @FXML
    private TitleTextField departure;

    @FXML
    private TitleTextField arrival;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        departure.setTitle("Départ");
        departure.getTextProperty().addListener(System.out::println);

        addStep.setText("+ Ajouter une étape");
        addStep.setOnAction(e -> System.out.println("PAF!"));

        arrival.setTitle("Arrivée");
        arrival.getTextProperty().addListener(System.out::println);

        hint.setText("Saisissez au moins un départ et une arrivée");
    }
}