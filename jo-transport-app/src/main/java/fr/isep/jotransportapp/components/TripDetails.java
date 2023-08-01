package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.helpers.ColorHelpers;
import fr.isep.jotransportapp.viewModels.TripDetailsVM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TripDetails extends Pane {

    @FXML
    private LineCard firstLine;
    @FXML
    private Label firstStation;

    @FXML
    private Pane verticalPane;

    @FXML
    private VBox listList;

    public TripDetails() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TripDetails.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(TripDetails.this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void bind(TripDetailsVM viewModel) {
        firstStation.setText(viewModel.firstStation);
        firstLine.bind(viewModel.lineCardVM);
        verticalPane.setStyle("-fx-background-color: " + ColorHelpers.toRGBCode(viewModel.lineCardVM.color ));
        viewModel.stations.subList(1,viewModel.stations.size()).forEach(station -> {
            Label stationLabel = new Label();
            stationLabel.setText(station);
            stationLabel.getStyleClass().add("station");
            listList.getChildren().add(stationLabel);
        });

    }
}
