package fr.isep.jotransportapp.models.responses;

import fr.isep.jotransportapp.models.TripSummary;

import java.util.List;

public class TripResponse {
    /*
     * List of TripSummary
     * */
    public List<TripSummary> tripSummaries;

    public TripResponse(List<TripSummary> tripSummaries) {
        this.tripSummaries = tripSummaries;
    }
}
