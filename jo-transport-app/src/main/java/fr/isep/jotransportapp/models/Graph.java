package fr.isep.jotransportapp.models;

import java.util.*;

import static fr.isep.jotransportapp.util.DistanceCalculator.calculateDistance;

public class Graph {
    private final Map<String, Station> stations;
    private final Map<String, Line> lines;

    public Graph() {
        stations = new HashMap<>();
        lines = new HashMap<>();
    }

    public void addStation(Station station) {
        stations.put(station.getStationId(), station);
    }

    public void addLine(Line line) {
        lines.put(line.getLineId(), line);

        // Associate stations IDs to line ID
        for (Station station : line.getStations()) {
            if (station != null) {
                station.setLineId(line.getLineId());
            }
        }
    }

    public Station getStationById(String stationId) {
        return stations.get(stationId);
    }

    public Line getLineById(String lineId) {
        return lines.get(lineId);
    }

    public List<Line> getAllLines() {
        return new ArrayList<>(lines.values());
    }

    public Set<String> getAllLineIds() {
        return lines.keySet();
    }

    public List<Station> getAllStations() {
        return new ArrayList<>(stations.values());
    }

    public String getLineId(String stationId) {
        Station station = stations.get(stationId);
        return (station != null) ? station.getLineId() : null;
    }

    public void parseAndSetupTerminusDistances() {
        List<Line> lines = getAllLines();

        for (Line line : lines) {
            System.out.println(line);
            List<Station> terminusStations = line.getStations().stream()
                    .filter(station -> station.isTerminus(line)) // Station::isTerminus
                    .toList();
            System.out.println("Terminus stations for line " + line.getLineId() + ": " + terminusStations);

            Station referenceTerminus = terminusStations.get(new Random().nextInt(terminusStations.size()));
            System.out.println("Reference Terminus for line " + line.getLineId() + ": " + referenceTerminus);

            for (Station station : line.getStations()) {
                double distanceToReferenceTerminus = calculateDistance(
                        station.getLatitude(),
                        station.getLongitude(),
                        referenceTerminus.getLatitude(),
                        referenceTerminus.getLongitude());
                System.out.println("Distance to Reference Terminus for station " + station.getName() + ": " + distanceToReferenceTerminus);
                station.setDistanceToTerminus(distanceToReferenceTerminus);
            }
        }
    }

    public List<Station> findShortestPath(String startStationId, String endStationId) {
        Station startStation = getStationById(startStationId);
        Station endStation = getStationById(endStationId);

        if (startStation == null || endStation == null) {
            System.out.println("Start or end station not found.");
            return null;
        }

        Map<Station, Double> distances = new HashMap<>();
        Map<Station, Station> predecessors = new HashMap<>();
        PriorityQueue<Station> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        distances.put(startStation, 0.0);
        priorityQueue.add(startStation);

        while (!priorityQueue.isEmpty()) {
            Station currentStation = priorityQueue.poll();
            System.out.println(currentStation);
            System.out.println(endStation);

            if (currentStation.equals(endStation)) {
                break; // Reached the destination station, exit the loop
            }

            for (Station neighborStation : currentStation.getNeighbors()) {
                double edgeWeight = currentStation.getDistanceToNeighbor(neighborStation);
                double newDistance = distances.get(currentStation) + edgeWeight;

                if (newDistance < distances.getOrDefault(neighborStation, Double.POSITIVE_INFINITY)) {
                    distances.put(neighborStation, newDistance);
                    predecessors.put(neighborStation, currentStation);
                    priorityQueue.add(neighborStation);
                }
            }
            // Print the current selected station and its distance
            System.out.println("Selected Station: " + currentStation.getName() + ", Distance: " + distances.get(currentStation));
        }


        List<Station> shortestPath = new ArrayList<>();
        Station current = endStation;
        while (current != null) {
            shortestPath.add(current);
            current = predecessors.get(current);
        }
        Collections.reverse(shortestPath);

        return shortestPath;
    }

    public void printGraph() {
        for (Station station : stations.values()) {
            System.out.print("Station: " + station.getName() + " (ID: " + station.getStationId() + ")");

            List<Station> neighbors = station.getNeighbors();
            if (neighbors.isEmpty()) {
                System.out.println(" has no neighbors.");
            } else {
                System.out.println(" has neighbors:");
                for (Station neighbor : neighbors) {
                    System.out.println("  - " + neighbor.getName());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "stations=" + stations +
                ", lines=" + lines +
                '}';
    }
}
