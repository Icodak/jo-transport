package fr.isep.jotransportapp.models;

import fr.isep.jotransportapp.util.DistanceCalculator;

import java.util.*;

public class Station {
    private final String stationId;
    private final String name;
    private final Map<Station, Double> neighbors = new HashMap<>(); // Nearby stations and their distances
    private boolean isTerminus;
    private double distanceToTerminus;
    private String lineId;
    private final double latitude;
    private final double longitude;
    private final Map<Line, Boolean> lines; // Map of lines and their terminus status

    public Station(String stationId, String name, double latitude, double longitude) {
        this.stationId = stationId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lines = new HashMap<>();
    }

    public void addNeighbor(Station neighbor, double distanceToNeighbor) {
        neighbors.put(neighbor, distanceToNeighbor);
    }

    public List<Station> getNeighborStations() {
        return new ArrayList<>(neighbors.keySet());
    }

    public boolean isTerminusForLine(Line line) {
        return lines.getOrDefault(line, false);
    }

    public static Line getLineBetweenStations(Station sourceStation, Station destinationStation) {
        Set<Line> sourceLines = sourceStation.getLines();
        Set<Line> destinationLines = destinationStation.getLines();

        // Find the common lines between the source and destination stations
        for (Line line : sourceLines) {
            if (destinationLines.contains(line)) {
                return line;
            }
        }

        // If no common line is found, return null
        return null;
    }

    public String getLineId() {
        return lineId;
    }
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }
    public double getLongitude() {
        return longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public String getStationId() {
        return stationId;
    }
    public String getName() {
        return name;
    }
    public void addLine(Line line, boolean isTerminus) {
        lines.put(line, isTerminus);
    }
    public Set<Line> getLines() {
        return lines.keySet();
    }

    public void setLineTerminus(Line line, boolean isTerminus) {
        lines.put(line, isTerminus);
    }

    public void setDistanceToTerminus(double distance) {
        this.distanceToTerminus = distance;
    }

    public double getDistanceToNeighbor(Station neighborStation) {
        return DistanceCalculator.calculateDistance(this.getLatitude(), this.getLongitude(), neighborStation.getLatitude(), neighborStation.getLongitude());
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId='" + stationId + '\'' +
                ", name='" + name + '\'' +
                ", distanceToTerminus=" + distanceToTerminus +
                '}';
    }
}