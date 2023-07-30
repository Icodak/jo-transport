package fr.isep.jotransportapp.components;

import fr.isep.jotransportapp.viewModels.SearchResultVM;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class SearchResultCell extends ListCell<SearchResultVM> {

    @Override
    protected void updateItem(SearchResultVM item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            Node visualElement = createVisualElement(item);
            setGraphic(visualElement);
        }
    }

    private Node createVisualElement(SearchResultVM viewModel) {
        SearchResult searchResult = new SearchResult();
        searchResult.bind(viewModel);
        return searchResult;
    }
}