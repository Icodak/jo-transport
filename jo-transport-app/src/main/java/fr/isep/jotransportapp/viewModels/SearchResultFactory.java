package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.components.SearchResultCell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class SearchResultFactory implements Callback<ListView<SearchResultVM>, ListCell<SearchResultVM>> {
    @Override
    public ListCell<SearchResultVM> call(ListView<SearchResultVM> listView) {
        return new SearchResultCell();
    }
}