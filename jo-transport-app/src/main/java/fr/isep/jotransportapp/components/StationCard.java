package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.helpers.ColorHelpers;
import fr.isep.jotransportapp.viewModels.StationCardVM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class StationCard extends Pane {
    @FXML
    Label label;


    public StationCard() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StationCard.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(StationCard.this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    void bind(StationCardVM viewModel) {
        label.setText(viewModel.name);
        label.setStyle("-fx-background-color: " + ColorHelpers.toRGBCode(viewModel.color) + ";");
    }
}
