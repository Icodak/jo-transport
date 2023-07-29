package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.services.SearchService;
import fr.isep.jotransportapp.services.SearchServiceImpl;
import javafx.beans.property.SimpleStringProperty;

public class MainVM {
    public TitleTextFieldVM departureVM = new TitleTextFieldVM("Départ","Gare, station, arrêt ...");
    public TitleTextFieldVM arrivalVM = new TitleTextFieldVM("Arrivée","Gare, station, arrêt ...");
    public final SimpleStringProperty stepTitle = new SimpleStringProperty("");
    public final SimpleStringProperty stepButtonTitle = new SimpleStringProperty("");
    public final SimpleStringProperty hint = new SimpleStringProperty("");

    SearchService searchService = new SearchServiceImpl();

    public MainVM() {
        setupStrings();
        setupBindings();
    }

    void setupStrings() {
        stepTitle.set("Étape");
        stepButtonTitle.set("+ Ajouter une étape");
        hint.set("Saisissez au moins un départ et une arrivée");
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
        System.out.println("tapped");
//        TitleTextField newTextField = new TitleTextField();
//        newTextField.setTitle("Étape " + stepCountProperty.get());
//        stepCountProperty.set(stepCountProperty.get() + 1);
//        newTextField.getTextProperty().addListener(System.out::println);
//        stepBox.getChildren().add(newTextField);

    }
}
