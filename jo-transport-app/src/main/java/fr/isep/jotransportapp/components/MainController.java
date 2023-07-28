package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.domain.MainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label label;

    @FXML
    private Button btn;

    @FXML
    private TitleTextField titleTextField;

    public void bind(MainViewModel viewModel) {
        label.textProperty().bind(viewModel.labelTitle);
        btn.setOnAction(viewModel::onTap);
        btn.textProperty().setValue(viewModel.btnTitle);
        titleTextField.setTitle("Voila mon super titre");
        titleTextField.getTextProperty().addListener(System.out::println);
    }
}