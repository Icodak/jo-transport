package fr.isep.jotransportapp.models;

import fr.isep.jotransportapp.util.DistanceCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Station {
    private String stationId;
    private String name;
    private final Map<Station, Double> neighbors = new HashMap<>(); // Nearby stations and their distances
    private boolean isTerminus;
    private double distanceToTerminus;
    private String lineId;
    private double latitude;
    private double longitude;

    public Station(String stationId, String name, double latitude, double longitude) {
        this.stationId = stationId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void addNeighbor(Station neighbor, double distanceToNeighbor) {
        neighbors.put(neighbor, distanceToNeighbor);
    }
    public List<Station> getNeighbors() {
        return new ArrayList<>(neighbors.keySet());
    }
    public List<Double> getDistances() {
        return new ArrayList<>(neighbors.values());
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
    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public boolean isTerminus() {
        return isTerminus;
    }

    public void setTerminus(boolean terminus) {
        isTerminus = terminus;
    }

    public void setDistanceToTerminus(double distance) {
        this.distanceToTerminus = distance;
    }

    public double getDistanceToTerminus() {
        return distanceToTerminus;
    }
    public double getDistanceToNeighbor(Station neighborStation) {
        return DistanceCalculator.calculateDistance(this.getLatitude(), this.getLongitude(), neighborStation.getLatitude(), neighborStation.getLongitude());
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId='" + stationId + '\'' +
                ", name='" + name + '\'' +
                ", isTerminus=" + isTerminus +
                ", distanceToTerminus=" + distanceToTerminus +
                ", lineId='" + lineId + '\'' +
                '}';
    }
}