package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.*;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


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
    public Label detailsTitle;
    @FXML
    public VBox summary;
    @FXML
    public ListView<TripDetailsVM> detailsList;
    @FXML
    public AnchorPane root;
    @FXML
    private TitleTextField departure;

    @FXML
    private ListView<TitleTextFieldVM> stepContainer;
    @FXML
    private TitleTextField arrival;

    @FXML
    private ListView<SearchResultVM> searchResults;


    @FXML
    public ScrollPane test;

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

        detailsTitle.setText(viewModel.detailsTitle);

        detailsList.setItems(viewModel.observableTripDetailsVms);
        detailsList.setCellFactory(new TripDetailsFactory());

        //test.setOnScroll(this::onScroll);

    }


    private void onScroll(ScrollEvent event) {
        double deltaY = event.getDeltaY();
        System.out.println(deltaY);

        // Obtenez la position Y actuelle de la racine (AnchorPane)
        double currentY = root.getLayoutY();

        // Calculer la nouvelle position Y en fonction du défilement
        double newY = currentY + deltaY;

        // Limitez la nouvelle position Y entre 0 et la taille de la racine
        newY = Math.max(root.getHeight() - 1080, newY); // Assurez-vous que newY ne soit pas inférieur à 0
        newY = Math.min(0, newY); // Assurez-vous que newY ne dépasse pas la hauteur de la racine
        root.setLayoutY(newY);
    }

    private double computeListViewHeight(ListView<?> listView, Double cellHeight, Double padding) {
        int cellCount = listView.getItems().size();
        return cellCount * cellHeight + padding;
    }
}