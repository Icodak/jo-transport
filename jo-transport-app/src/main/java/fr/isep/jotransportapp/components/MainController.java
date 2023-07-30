package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.MainVM;
import fr.isep.jotransportapp.viewModels.StepFactory;
import fr.isep.jotransportapp.viewModels.TitleTextFieldVM;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
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
    private TitleTextField departure;

    @FXML
    private ListView<TitleTextFieldVM> stepContainer;
    @FXML
    private TitleTextField arrival;

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
    }

    private double computeListViewHeight(ListView<?> listView) {
        int cellCount = listView.getItems().size();
        double cellHeight = 130.0;
        return cellCount * cellHeight + 32;
    }
}