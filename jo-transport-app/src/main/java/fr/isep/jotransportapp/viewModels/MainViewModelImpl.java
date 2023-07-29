package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.model.parameters.SearchParameters;
import fr.isep.jotransportapp.services.SearchService;
import fr.isep.jotransportapp.services.SearchServiceImpl;

public class MainViewModelImpl implements MainViewModel {

    SearchService searchService = new SearchServiceImpl();

    public MainViewModelImpl() {
        setupStrings();
        setupBindings();
    }

    void setupBindings() {
        departureSearch.addListener((e, oldValue, newValue) -> {
            searchService.getResults(new SearchParameters(newValue));
        });

        arrivalSearch.addListener((e, oldValue, newValue) -> {
            searchService.getResults(new SearchParameters(newValue));
        });
    }

    void setupStrings() {
        departureTitle.set("Départ");
        stepTitle.set("Étape");
        stepButtonTitle.set("+ Ajouter une étape");
        arrivalTitle.set("Arrivée");
        placeholder.set("Gare, station, arrêt ...");
        hint.set("Saisissez au moins un départ et une arrivée");
    }

    @Override
    public void onAddStep() {
        System.out.println("tapped");
//        TitleTextField newTextField = new TitleTextField();
//        newTextField.setTitle("Étape " + stepCountProperty.get());
//        stepCountProperty.set(stepCountProperty.get() + 1);
//        newTextField.getTextProperty().addListener(System.out::println);
//        stepBox.getChildren().add(newTextField);

    }

}
