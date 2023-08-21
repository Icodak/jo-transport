package fr.isep.jotransportapp.services;

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

        List<LineDetails> lineDetails = new ArrayList<>();
        List<String> currentStations = new ArrayList<>();
        Line currentLine = null;

        for (int i = 0; i < shortestTrip.size() - 1; i++) {
            Station sourceStation = shortestTrip.get(i);
            Station destinationStation = shortestTrip.get(i + 1);

            Line stationLine = Station.getLineBetweenStations(sourceStation, destinationStation);

            if (currentLine == null || !currentLine.equals(stationLine)) {
                if (!currentStations.isEmpty()) {
                    lineDetails.add(new LineDetails(currentLine, new ArrayList<>(currentStations)));
                    currentStations.clear();
                }

                currentLine = stationLine;
            }

            currentStations.add(sourceStation.getName());
        }

        // Add the last LineDetails
        if (!currentStations.isEmpty()) {
            lineDetails.add(new LineDetails(currentLine, new ArrayList<>(currentStations)));
        }

        TripSummary tripSummary = new TripSummary(
                lineDetails,
                currentStations.get(0),
                AffluenceLevel.MEDIUM, // TODO: Replace with actual affluence level
                1.20, // TODO: Replace with actual cost
                26, // TODO: Replace with actual duration
                List.of(TransportTypes.METRO) // TODO: Replace with actual transport types
        );
        tripSummaries.add(tripSummary);
        return new TripResponse(tripSummaries);
    }
}
