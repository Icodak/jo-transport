package fr.isep.jotransportapp.models.responses;

import java.util.List;

public class SearchResponse {
    public List<StationDescription> stations;

    public SearchResponse(List<StationDescription> lines) {
        this.stations = lines;
    }
}
