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
        linkToService(departureVM);
        linkToService(arrivalVM);
//        departureVM.search.addListener((e, oldSearchText, newSearchText) -> {
//            searchService.getResults(new SearchParameters(newSearchText));
//
//        });
//
//        arrivalVM.search.addListener((e, oldValue, newValue) -> {
//            searchService.getResults(new SearchParameters(newValue));
//        });
    }

    void linkToService(TitleTextFieldVM titleTextFieldVM) {
        titleTextFieldVM.search.addListener((e, oldValue, newValue) -> {
            searchService.getResults(new SearchParameters(newValue));
        });
    }

    public void onAddStep() {
        TitleTextFieldVM titleTextFieldVM = new TitleTextFieldVM("", "Gare, station, arrêt ...");
        titleTextFieldVM.hasCross.set(true);
        titleTextFieldVM.hasClicked.addListener((e, oldValue, newValue) -> observableStepVms.remove(titleTextFieldVM));
        linkToService(titleTextFieldVM);
        observableStepVms.add(titleTextFieldVM);
    }
}
