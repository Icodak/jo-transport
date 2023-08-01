package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.TripDetailsVM;
import fr.isep.jotransportapp.viewModels.TripProposalVM;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class TripDetailsCell extends ListCell<TripDetailsVM> {

    @Override
    protected void updateItem(TripDetailsVM item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            Node visualElement = createVisualElement(item);
            setGraphic(visualElement);
        }
    }

    private Node createVisualElement(TripDetailsVM viewModel) {
        TripDetails tripDetails = new TripDetails();
        tripDetails.bind(viewModel);
        return tripDetails;
    }
}
