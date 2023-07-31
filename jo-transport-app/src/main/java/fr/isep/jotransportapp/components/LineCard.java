package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.helpers.ColorHelpers;
import fr.isep.jotransportapp.viewModels.LineCardVM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LineCard extends Pane {
    @FXML
    Label label;


    public LineCard() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LineCard.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(LineCard.this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    void bind(LineCardVM viewModel) {
        label.setText(viewModel.name);
        label.setStyle("-fx-background-color: " + ColorHelpers.toRGBCode(viewModel.color) + ";");
    }
}
