package fr.isep.jotransportapp.services;

import fr.isep.jotransportapp.helpers.ColorHelpers;
import fr.isep.jotransportapp.models.*;
import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.models.parameters.TripParameters;
import fr.isep.jotransportapp.models.responses.SearchResponse;
import fr.isep.jotransportapp.models.responses.StationDescription;
import fr.isep.jotransportapp.models.responses.TripResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainServiceImpl implements MainService {

    private final Graph graph;

    public MainServiceImpl(Graph graph) {
        this.graph = graph;
    }

    @Override
    public SearchResponse getResults(SearchParameters parameters) {
        if (graph == null) {
            throw new IllegalStateException("Graph has not been set. Call setGraph() before calling getResults()");
        }

        List<StationDescription> stationDescriptions = new ArrayList<>();

        // Iterate through each station in the graph
        for (Station station : graph.getAllStations()) {
            if (parametersMatchesStation(parameters, station)) {
                String stationName = station.getName();
                Set<Line> associatedLines = station.getLines();

                StationDescription stationDescription = new StationDescription(stationName, new ArrayList<>(associatedLines), TransportTypes.METRO, station.getStationId());
                stationDescriptions.add(stationDescription);
            }
        }
        return new SearchResponse(stationDescriptions);
    }

    private boolean parametersMatchesStation(SearchParameters parameters, Station station) {
        return station.getName().toLowerCase().contains(parameters.locationName);
    }

    @Override
    public TripResponse getTrips(TripParameters parameters) {
        List<TripSummary> tripSummaries = new ArrayList<>();

        List<Station> shortestTrip = graph.findShortestPath(parameters.departureUuid, parameters.arrivalUuid);
        System.out.println("SHORTEST PATH: " + shortestTrip);
        for (int i = 0; i < shortestTrip.size() - 1; i++) {
            Station sourceStation = shortestTrip.get(i);
            Station destinationStation = shortestTrip.get(i + 1);

            // Create LineDetails for this segment (could involve multiple lines)
            List<LineDetails> lineDetails = new ArrayList<>();
            // Add line details based on the stations and lines involved in this segment

            TripSummary tripSummary = new TripSummary(
                    lineDetails,
                    sourceStation.getName(),
                    AffluenceLevel.MEDIUM, // TODO: Replace with actual affluence level
                    1.20, // TODO: Replace with actual cost
                    26, // TODO: Replace with actual duration
                    List.of(TransportTypes.METRO) // TODO: Replace with actual transport types
            );
            tripSummaries.add(tripSummary);
        }
        return new TripResponse(tripSummaries);
        /*return new TripResponse(List.of(
                new TripSummary(
                        List.of(
                                new LineDetails(
                                        new Line("U", ColorHelpers.fromRGBCode("#FF6677")),
                                        List.of("Raspail", "Montparnasse-Bienvenue", "Victor Hugo", "Glaciere")
                                )
                        ),
                        "Raspail",
                        AffluenceLevel.MEDIUM,
                        1.20,
                        26,
                        List.of(TransportTypes.TRAIN)
                ),
                new TripSummary(
                        List.of(
                                new LineDetails(
                                        new Line("N", ColorHelpers.fromRGBCode("#319794")),
                                        List.of("Versailles", "Vanves")
                                ),
                                new LineDetails(
                                        new Line("U", ColorHelpers.fromRGBCode("#FF6677")),
                                        List.of("Vanves-Malakoff", "St-Cyr", "Bennes", "Pluton")
                                ),
                                new LineDetails(
                                        new Line("135", ColorHelpers.fromRGBCode("#3ADEFF")),
                                        List.of("Albert Camus", "Jean Monnet")
                                )
                        ),
                        "Versailles",
                        AffluenceLevel.NONE,
                        2.9,
                        12,
                        List.of(TransportTypes.TRAIN, TransportTypes.BUS)
                ),
                new TripSummary(
                        List.of(
                                new LineDetails(
                                        new Line("8", ColorHelpers.fromRGBCode("#FFB41E")),
                                        List.of("Raspail", "Montparnasse-Bienvenue", "Victor Hugo", "Glaciere")
                                )
                        ),
                        "Raspail",
                        AffluenceLevel.LOW,
                        4.6,
                        8,
                        List.of(TransportTypes.METRO)
                )
        ));*/
    }
}
