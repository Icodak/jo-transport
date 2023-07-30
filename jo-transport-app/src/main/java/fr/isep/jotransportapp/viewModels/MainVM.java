package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.models.responses.SearchResponse;
import fr.isep.jotransportapp.services.SearchService;
import fr.isep.jotransportapp.services.SearchServiceImpl;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;

public class MainVM {
    public final SimpleStringProperty stepButtonTitle = new SimpleStringProperty("+ Ajouter une étape");
    public final SimpleStringProperty sendButtonTitle = new SimpleStringProperty("Rechercher un trajet");
    public final SimpleStringProperty hint = new SimpleStringProperty("Saisissez au moins un départ et une arrivée");
    public TitleTextFieldVM departureVM = new TitleTextFieldVM("Départ", "Gare, station, arrêt ...");
    public TitleTextFieldVM arrivalVM = new TitleTextFieldVM("Arrivée", "Gare, station, arrêt ...");
    public ObservableList<TitleTextFieldVM> observableStepVms = FXCollections.observableArrayList();
    public ObservableList<SearchResultVM> observableResultsVms = FXCollections.observableArrayList();
    SearchService searchService = new SearchServiceImpl();

    public SimpleDoubleProperty searchPosX = new SimpleDoubleProperty(0.0);
    public SimpleDoubleProperty searchPosY = new SimpleDoubleProperty(0.0);

    public MainVM(Scene scene) {

        setupBindings();
        scene.setOnMouseClicked(event -> {
            searchPosX.set(event.getSceneX());
            searchPosY.set(event.getSceneY());
            double x = event.getSceneX();
            double y = event.getSceneY();
            System.out.println("Coordonnées du clic : x = " + x + ", y = " + y);
        });
    }

    void setupBindings() {
        linkToService(departureVM);
        linkToService(arrivalVM);
    }

    void linkToService(TitleTextFieldVM titleTextFieldVM) {
        titleTextFieldVM.search.addListener((e, oldValue, newValue) -> {
            SearchResponse searchResults = searchService.getResults(new SearchParameters(newValue));
            observableResultsVms.setAll(searchResults.stations.stream().map(desc ->
                    new SearchResultVM(desc.type, desc.title, desc.stations)).toList());
        });
    }

    public void onAddStep() {
        TitleTextFieldVM titleTextFieldVM = new TitleTextFieldVM("", "Gare, station, arrêt ...");
        titleTextFieldVM.hasCross.set(true);
        titleTextFieldVM.hasClicked.addListener((e, oldValue, newValue) -> observableStepVms.remove(titleTextFieldVM));
        linkToService(titleTextFieldVM);
        observableStepVms.add(titleTextFieldVM);
    }

    public void sendRequest() {
        System.out.println("Departure: " + departureVM.search.getValue());
        observableStepVms.forEach(vm -> System.out.println("Step: " + vm.search.getValue()));
        System.out.println("Arrivée: " + arrivalVM.search.getValue());
    }
}
