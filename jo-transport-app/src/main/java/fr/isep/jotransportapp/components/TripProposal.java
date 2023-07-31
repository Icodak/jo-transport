package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.SearchResultVM;
import fr.isep.jotransportapp.viewModels.TripProposalVM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class TripProposal extends Pane {

    @FXML
private HBox lineContainer;
    @FXML
private Label tripName;
    @FXML
private ImageView affluence;
    @FXML
    private Label price;
    @FXML
    private Label duration;


    public TripProposal() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TripProposal.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(TripProposal.this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void bind(TripProposalVM viewModel) {
        tripName.setText(viewModel.name);
        affluence.setImage(viewModel.affluencePicto);
        price.setText(viewModel.formattedPrice);
        duration.setText(viewModel.formattedDuration);
        viewModel.lines.forEach(lineCardVM -> {
            LineCard lineCard = new LineCard();
            lineCard.bind(lineCardVM);
            lineContainer.getChildren().add(lineCard);
        });
        setOnMousePressed(e -> viewModel.onClick());
    }
}
