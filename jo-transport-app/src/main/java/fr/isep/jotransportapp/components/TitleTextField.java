package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.TitleTextFieldVM;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class TitleTextField extends Pane {
    @FXML
    private Label label;

    @FXML
    private TextField textField;

    public TitleTextField() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TitleTextField.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(TitleTextField.this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void bind(TitleTextFieldVM viewModel) {
        label.setText(viewModel.title.get());
        textField.setPromptText(viewModel.placeholder.get());
        viewModel.search.bind(textField.textProperty());
    }
}
