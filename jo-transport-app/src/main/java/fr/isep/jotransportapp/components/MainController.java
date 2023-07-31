package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.*;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;


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
    public Label departureStation;
    @FXML
    public Label affluence;
    @FXML
    public Label price;
    @FXML
    public Label duration;
    @FXML
    public ListView<TripProposalVM> tripProposalList;
    @FXML
    private TitleTextField departure;

    @FXML
    private ListView<TitleTextFieldVM> stepContainer;
    @FXML
    private TitleTextField arrival;

    @FXML
    private ListView<SearchResultVM> searchResults;

    public void bind(MainVM viewModel) {
        departure.bind(viewModel.departureVM);

        stepContainer.setItems(viewModel.observableStepVms);
        stepContainer.setCellFactory(new StepFactory());
        stepContainer.setPrefHeight(computeListViewHeight(stepContainer, 130.0, 32.0));

        viewModel.observableStepVms.addListener((ListChangeListener<TitleTextFieldVM>) c -> {
            while (c.next()) {
                stepContainer.setPrefHeight(computeListViewHeight(stepContainer, 130.0, 32.0));
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

        departureStation.setText(viewModel.departureTitle);
        affluence.setText(viewModel.affluenceTitle);
        price.setText(viewModel.priceTitle);
        duration.setText(viewModel.durationTitle);

        tripProposalList.setItems(viewModel.observableTripProposalVms);
        tripProposalList.setCellFactory(new TripProposalFactory());
        tripProposalList.setPrefHeight(computeListViewHeight(tripProposalList, 50.0, 100.0));

        viewModel.observableTripProposalVms.addListener((ListChangeListener<TripProposalVM>) c -> {
            while (c.next()) {
                tripProposalList.setPrefHeight(computeListViewHeight(tripProposalList, 50.0, 100.0));
            }
        });
    }

    private double computeListViewHeight(ListView<?> listView, Double cellHeight, Double padding) {
        int cellCount = listView.getItems().size();
        return cellCount * cellHeight + padding;
    }
}