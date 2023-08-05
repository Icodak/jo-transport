package fr.isep.jotransportapp.models;

public class Station {
    private String stationId;
    private String name;

    public Station(String stationId, String name) {
        this.stationId = stationId;
        this.name = name;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
