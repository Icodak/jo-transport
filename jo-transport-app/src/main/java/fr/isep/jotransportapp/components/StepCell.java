package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.TitleTextFieldVM;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class StepCell extends ListCell<TitleTextFieldVM> {

    @Override
    protected void updateItem(TitleTextFieldVM item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            Node visualElement = createVisualElement(item);
            setGraphic(visualElement);
        }
    }

    private Node createVisualElement(TitleTextFieldVM viewModel) {
        TitleTextField titleTextField = new TitleTextField();
        viewModel.title.set("Étape " + (getIndex() + 1));

        titleTextField.bind(viewModel);
        return titleTextField;
    }
}
