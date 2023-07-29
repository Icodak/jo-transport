package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.MainVM;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class MainController {
    // Components
    @FXML
    public Button addStep;
    @FXML
    public Label hint;
    @FXML
    public VBox stepBox;
    @FXML
    public Pane buttonContainer;
    @FXML
    private TitleTextField departure;
    @FXML
    private TitleTextField arrival;

    public void bind(MainVM viewModel) {
        departure.bind(viewModel.departureVM);
        arrival.bind(viewModel.arrivalVM);

        hint.setText(viewModel.hint.get());

        addStep.setText(viewModel.stepTitle.get());
        addStep.setOnAction(e -> viewModel.onAddStep());
    }


}