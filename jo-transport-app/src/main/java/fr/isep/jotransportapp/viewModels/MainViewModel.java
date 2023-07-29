package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.services.SearchService;
import javafx.beans.property.SimpleStringProperty;

public interface MainViewModel {
    SearchService searchService = null;
    SimpleStringProperty departureTitle = new SimpleStringProperty("");
    SimpleStringProperty departureSearch = new SimpleStringProperty("");
    SimpleStringProperty stepTitle = new SimpleStringProperty("");

    SimpleStringProperty stepButtonTitle = new SimpleStringProperty("");
    SimpleStringProperty arrivalTitle = new SimpleStringProperty("");
    SimpleStringProperty arrivalSearch = new SimpleStringProperty("");
    SimpleStringProperty placeholder = new SimpleStringProperty("");
    SimpleStringProperty hint = new SimpleStringProperty("");

    void onAddStep();
}
