package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.services.SearchService;
import fr.isep.jotransportapp.services.SearchServiceImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainVM {
    public final SimpleStringProperty stepButtonTitle = new SimpleStringProperty("+ Ajouter une étape");
    public final SimpleStringProperty hint = new SimpleStringProperty("Saisissez au moins un départ et une arrivée");
    public TitleTextFieldVM departureVM = new TitleTextFieldVM("Départ", "Gare, station, arrêt ...");
    public TitleTextFieldVM arrivalVM = new TitleTextFieldVM("Arrivée", "Gare, station, arrêt ...");
    public ObservableList<TitleTextFieldVM> observableStepVms = FXCollections.observableArrayList();
    SearchService searchService = new SearchServiceImpl();

    public MainVM() {
        setupBindings();
    }

    void setupBindings() {
        departureVM.search.addListener((e, oldValue, newValue) -> {
            searchService.getResults(new SearchParameters(newValue));
        });

        arrivalVM.search.addListener((e, oldValue, newValue) -> {
            searchService.getResults(new SearchParameters(newValue));
        });
    }

    public void onAddStep() {
        observableStepVms.add(new TitleTextFieldVM("", "Gare, station, arrêt ..."));
    }
}
