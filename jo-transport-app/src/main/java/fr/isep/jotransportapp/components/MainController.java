package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.helpers.ColorHelpers;
import fr.isep.jotransportapp.viewModels.*;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.util.List;


public class MainController {
    // Components
    @FXML
    public Button addStep;
    @FXML
    public Label hint;
    @FXML
    public Button sendRequest;
    @FXML
    public AnchorPane searchAnchor;
    @FXML
    private TitleTextField departure;

    @FXML
    private ListView<TitleTextFieldVM> stepContainer;
    @FXML
    private TitleTextField arrival;

    @FXML
    private ListView<SearchResultVM> searchResults;

    @FXML
    public TripProposal temp;

    public void bind(MainVM viewModel) {
        departure.bind(viewModel.departureVM);

        stepContainer.setItems(viewModel.observableStepVms);
        stepContainer.setCellFactory(new StepFactory());
        stepContainer.setPrefHeight(computeListViewHeight(stepContainer));

        viewModel.observableStepVms.addListener((ListChangeListener<TitleTextFieldVM>) c -> {
            while (c.next()) {
                stepContainer.setPrefHeight(computeListViewHeight(stepContainer));
            }
        });

        arrival.bind(viewModel.arrivalVM);

        hint.setText(viewModel.hint.get());

        addStep.setText(viewModel.stepButtonTitle.get());
        addStep.setOnAction(e -> viewModel.onAddStep());

        sendRequest.setText(viewModel.sendButtonTitle.get());
        sendRequest.setOnAction(e -> viewModel.sendRequest());

        searchResults.setItems(viewModel.observableResultsVms);
        searchResults.setCellFactory(new SearchResultFactory());

        searchAnchor.visibleProperty().bindBidirectional(viewModel.isSearchResultVisible);
        searchAnchor.layoutXProperty().bindBidirectional(viewModel.searchPosX);
        searchAnchor.layoutYProperty().bindBidirectional(viewModel.searchPosY);

        temp.bind(new TripProposalVM(
                "Gare montparnasse",
                AffluenceLevel.MEDIUM,
                List.of(new LineCardVM("354", ColorHelpers.fromRGBCode("#FF2467")),
                        new LineCardVM("R", ColorHelpers.fromRGBCode("#25FF67"))),
                1.25,
                12
                ));
    }

    private double computeListViewHeight(ListView<?> listView) {
        int cellCount = listView.getItems().size();
        double cellHeight = 130.0;
        return cellCount * cellHeight + 32;
    }
}