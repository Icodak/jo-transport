package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.SearchResultVM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SearchResult extends Pane {

    @FXML
    private ImageView image;
    @FXML
    private Label name;

    @FXML
    private HBox container;

    public SearchResult() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchResult.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(SearchResult.this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void bind(SearchResultVM viewModel) {
        name.setText(viewModel.title);
        image.setImage(viewModel.image);
        viewModel.stations.forEach(stationCardVM -> {
            StationCard stationCard = new StationCard();
            stationCard.bind(stationCardVM);
            container.getChildren().add(stationCard);
        });
        setOnMousePressed(e -> viewModel.onClick());
        container.setAlignment(Pos.CENTER_LEFT);
    }
}
