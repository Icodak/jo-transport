package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.components.SearchResultCell;
import fr.isep.jotransportapp.components.TripProposalCell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class TripProposalFactory implements Callback<ListView<TripProposalVM>, ListCell<TripProposalVM>> {
    @Override
    public ListCell<TripProposalVM> call(ListView<TripProposalVM> listView) {
        return new TripProposalCell();
    }
}