package fr.isep.jotransportapp.models.responses;

import fr.isep.jotransportapp.models.Station;
import fr.isep.jotransportapp.viewModels.TransportTypes;

import java.util.List;

public class StationDescription {
    public List<Station> stations;
    public String title;
    public TransportTypes type;
    public String uuid;

    public StationDescription(List<Station> stations, String title, TransportTypes type, String uuid) {
        this.stations = stations;
        this.title = title;
        this.type = type;
        this.uuid = uuid;
    }
}
