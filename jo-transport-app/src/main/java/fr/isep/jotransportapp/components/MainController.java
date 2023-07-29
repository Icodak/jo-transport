package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.domain.MainViewModel;
import javafx.fxml.FXML;


public class MainController {
    @FXML
    private TitleTextField titleTextField;

    public void bind(MainViewModel viewModel) {
        titleTextField.setTitle("Voila mon super titre");
        titleTextField.getTextProperty().addListener(System.out::println);
    }
}