package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.components.StepCell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class StepFactory implements Callback<ListView<TitleTextFieldVM>, ListCell<TitleTextFieldVM>> {
    @Override
    public ListCell<TitleTextFieldVM> call(ListView<TitleTextFieldVM> listView) {
        return new StepCell();
    }
}