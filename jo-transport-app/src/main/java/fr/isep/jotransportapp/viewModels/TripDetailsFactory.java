package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.components.TripDetailsCell;
import fr.isep.jotransportapp.components.TripProposalCell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class TripDetailsFactory implements Callback<ListView<TripDetailsVM>, ListCell<TripDetailsVM>> {
    @Override
    public ListCell<TripDetailsVM> call(ListView<TripDetailsVM> listView) {
        return new TripDetailsCell();
    }
}