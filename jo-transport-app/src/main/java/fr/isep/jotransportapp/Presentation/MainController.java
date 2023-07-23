package fr.isep.jotransportapp.Presentation;

import fr.isep.jotransportapp.Domain.MainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label label;

    @FXML
    private Button btn;

    public void bind(MainViewModel viewModel) {
    label.textProperty().bind(viewModel.labelTitle);
    btn.setOnAction(viewModel::onTap);
    btn.textProperty().setValue(viewModel.btnTitle);
    }
}