package fr.isep.jotransportapp.models.responses;

import fr.isep.jotransportapp.models.Station;
import fr.isep.jotransportapp.viewModels.TransportTypes;

import java.util.List;
import java.util.UUID;

public class StationDescription {
    public List<Station> stations;
    public String title;
    public TransportTypes type;
    public UUID uuid;

    public StationDescription(List<Station> stations, String title, TransportTypes type, UUID uuid) {
        this.stations = stations;
        this.title = title;
        this.type = type;
        this.uuid = uuid;
    }
}
