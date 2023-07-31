package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.TitleTextFieldVM;
import fr.isep.jotransportapp.viewModels.TripProposalVM;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class TripProposalCell extends ListCell<TripProposalVM> {

    @Override
    protected void updateItem(TripProposalVM item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            Node visualElement = createVisualElement(item);
            setGraphic(visualElement);
        }
    }

    private Node createVisualElement(TripProposalVM viewModel) {
        TripProposal tripProposal = new TripProposal();
        tripProposal.bind(viewModel);
        return tripProposal;
    }
}
