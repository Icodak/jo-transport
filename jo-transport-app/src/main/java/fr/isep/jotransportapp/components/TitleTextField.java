package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.models.TextEvent;
import fr.isep.jotransportapp.viewModels.TitleTextFieldVM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Transform;

import java.io.IOException;

public class TitleTextField extends Pane {
    @FXML
    private Label label;
    @FXML
    private TextField textField;

    @FXML
    private Button cross;

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
        viewModel.textEventProperty.bind(textField.textProperty().map(str -> {
            Transform textFieldTransform = textField.getLocalToSceneTransform();
            double x = textFieldTransform.getTx();
            double y = textFieldTransform.getTy();
            return new TextEvent(str, x, y);
        }));

        textField.setOnMouseClicked(event -> {
            textField.clear();

        });

        cross.visibleProperty().bind(viewModel.hasCross);
        cross.setOnMouseClicked(event -> {
            viewModel.hasClicked.set(true);
        });
    }
}
