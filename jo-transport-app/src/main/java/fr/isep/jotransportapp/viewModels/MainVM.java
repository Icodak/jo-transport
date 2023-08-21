package fr.isep.jotransportapp.viewModels;

import fr.isep.jotransportapp.models.Graph;
import fr.isep.jotransportapp.models.TransportTypes;
import fr.isep.jotransportapp.models.TripSummary;
import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.models.parameters.TripParameters;
import fr.isep.jotransportapp.models.responses.SearchResponse;
import fr.isep.jotransportapp.models.responses.TripResponse;
import fr.isep.jotransportapp.services.MainService;
import fr.isep.jotransportapp.services.MainServiceImpl;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class MainVM {
    public final SimpleStringProperty stepButtonTitle = new SimpleStringProperty("+ Ajouter une étape");
    public final SimpleStringProperty sendButtonTitle = new SimpleStringProperty("Rechercher un trajet");
    public final SimpleStringProperty hint = new SimpleStringProperty("Saisissez au moins un départ et une arrivée");
    public TitleTextFieldVM departureVM = new TitleTextFieldVM("Départ", "Gare, arrêt ...");
    public TitleTextFieldVM arrivalVM = new TitleTextFieldVM("Arrivée", "Gare, arrêt ...");
    public ObservableList<TitleTextFieldVM> observableStepVms = FXCollections.observableArrayList();
    public ObservableList<SearchResultVM> observableResultsVms = FXCollections.observableArrayList();
    public ObservableList<TripProposalVM> observableTripProposalVms = FXCollections.observableArrayList();
    public ObservableList<TripDetailsVM> observableTripDetailsVms = FXCollections.observableArrayList();
    public SimpleDoubleProperty searchPosX = new SimpleDoubleProperty(0.0);
    public SimpleDoubleProperty searchPosY = new SimpleDoubleProperty(0.0);
    public SimpleBooleanProperty isSearchResultVisible = new SimpleBooleanProperty(false);
    public SimpleStringProperty clickedUuid = new SimpleStringProperty("");
    public SimpleStringProperty clickedTitle = new SimpleStringProperty("");
    public SimpleStringProperty currentlyActiveTextField = new SimpleStringProperty("");
    public String departureTitle = "Station de départ";
    public String affluenceTitle = "Affluence";
    public String priceTitle = "Prix";
    public String durationTitle = "Durée";
    public String detailsTitle = "Détail du trajet";
    public String sortLabel = "Trier les résultats par";
    public String balancedSort = "Prix/Temps";
    public String priceSort = "Prix";
    public String timeSort = "Temps";
    public String filterText = "Filtrer";
    public String busText = "Bus";
    public String metroText = " |   Metro";
    public String trainText = " |   Train";
    public List<TransportTypes> bannedTransportTypes = new ArrayList<>();
    List<TripProposalVM> tripProposalVMList;
    private final MainService mainService;
    private SortType sortType = SortType.BALANCED;

    public MainVM(Scene scene, Graph graph) {
        this.mainService = new MainServiceImpl(graph);
        setupBindings(scene);
    }

    void setupBindings(Scene scene) {
        bindTitleTextField(departureVM);
        bindTitleTextField(arrivalVM);
        scene.onMouseClickedProperty().addListener((e, o, n) -> isSearchResultVisible.set(false));
    }

    void updateTripProposals() {
        // Sorts and filter the displayed trip proposals
        Predicate<TripProposalVM> predicate = vm ->
                vm.transportTypes.stream().noneMatch(type -> bannedTransportTypes.contains(type));

        List<TripProposalVM> sortedList = switch (sortType) {
            case TIME -> tripProposalVMList.stream()
                    .sorted(Comparator.comparingDouble(vm -> -vm.price))
                    .filter(predicate)
                    .toList();
            case PRICE -> tripProposalVMList.stream()
                    .sorted(Comparator.comparingInt(vm -> -vm.duration))
                    .filter(predicate)
                    .toList();
            case BALANCED -> tripProposalVMList.stream()
                    .sorted(Comparator.comparingDouble(vm -> (vm.price / vm.duration)))
                    .filter(predicate)
                    .toList();
        };
        observableTripProposalVms.setAll(sortedList);
    }


    void bindTitleTextField(TitleTextFieldVM titleTextFieldVM) {

        titleTextFieldVM.textEventProperty.addListener((event, oldValue, newValue) -> {
            // Search and set results
            SearchResponse searchResults = mainService.getResults(new SearchParameters(newValue.text));
            observableResultsVms.setAll(searchResults.stations.stream().map(desc -> {
                SearchResultVM searchResultVM = new SearchResultVM(
                        desc.type,
                        desc.stationName,
                        desc.getLines().stream().map(line -> new LineCardVM(line.getName(), line.getColor())).toList(),
                        desc.uuid
                );
                searchResultVM.uuidProperty.addListener((e, o, n) -> clickedUuid.set(n));
                searchResultVM.titleProperty.addListener((e, o, n) -> clickedTitle.set(n));
                return searchResultVM;
            }).toList());


            // Move the search results listview coordinates
            searchPosX.set(newValue.x);
            searchPosY.set(newValue.y + 60);
            if (newValue.x != 0 && newValue.y != 0) isSearchResultVisible.set(true);
        });


        // When we click on a textfield we store its id here
        titleTextFieldVM.hasClickedTextField.addListener((e, o, n) -> currentlyActiveTextField.set(titleTextFieldVM.id));
        // If when we click a field its id is the same we propagate the change
        clickedUuid.addListener((e, o, n) -> {
            if (Objects.equals(titleTextFieldVM.id, currentlyActiveTextField.getValue())) {
                titleTextFieldVM.tripUuid.set(clickedUuid.get());
            }
            isSearchResultVisible.set(false);
        });
        clickedTitle.addListener((e, o, n) -> {
            if (Objects.equals(titleTextFieldVM.id, currentlyActiveTextField.getValue())) {
                if (n != null) {
                    titleTextFieldVM.tripTitle.set(clickedTitle.get());
                    clickedTitle.set(null);
                }
            }
            isSearchResultVisible.set(false);
        });
    }

    public void onAddStep() {
        TitleTextFieldVM titleTextFieldVM = new TitleTextFieldVM("", "Gare, arrêt ...");
        titleTextFieldVM.hasCross.set(true);
        titleTextFieldVM.hasClicked.addListener((e, oldValue, newValue) -> {
            observableStepVms.remove(titleTextFieldVM);
            isSearchResultVisible.set(false);
        });
        bindTitleTextField(titleTextFieldVM);
        observableStepVms.add(titleTextFieldVM);
        isSearchResultVisible.set(false);
    }


    public void sendRequest() {
        TripResponse response = mainService.getTrips(new TripParameters(
                departureVM.tripUuid.get(),
                arrivalVM.tripUuid.get(),
                observableStepVms.stream().map(vm -> vm.tripUuid.get()).toList()
        ));
        System.out.println(response);
        tripProposalVMList = response.tripSummaries.stream().map(this::tripSummaryToTripProposalVM).toList();
        System.out.println(tripProposalVMList);
        updateTripProposals();

        isSearchResultVisible.set(false);
    }

    private TripProposalVM tripSummaryToTripProposalVM(TripSummary summary) {
        return new TripProposalVM(
                summary.departureStationName,
                summary.affluenceLevel,
                summary.lineDetails.stream().map(lineDetails -> new LineCardVM(lineDetails.line.getName(), lineDetails.line.getColor())).toList(),
                summary.tripPrice,
                summary.tripMinutesDuration,
                () -> {
                    observableTripDetailsVms.setAll(
                            summary.lineDetails.stream().map(lineDetails -> new TripDetailsVM(
                                    new LineCardVM(lineDetails.line.getName(), lineDetails.line.getColor()),
                                    lineDetails.stations
                            )).toList());
                },
                summary.usedTransportTypes
        );
    }

    public void onSort(SortType sortType) {
        this.sortType = sortType;
        updateTripProposals();
    }

    public void onFilter(TransportTypes transportType, Boolean doBan) {
        System.out.println(transportType);
        System.out.println(doBan);
        if (doBan) {
            bannedTransportTypes.add(transportType);
        } else {
            bannedTransportTypes.remove(transportType);
        }
        updateTripProposals();
    }
}
