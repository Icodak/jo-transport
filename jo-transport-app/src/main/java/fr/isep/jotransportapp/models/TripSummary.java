package fr.isep.jotransportapp.models;

import fr.isep.jotransportapp.viewModels.AffluenceLevel;

import java.util.List;

public class TripSummary {
    /*
     * Contains all the details of a trip
     */
    List<LineDetails> lineDetails;
    String departureStationName;
    AffluenceLevel affluenceLevel;
    Double tripPrice;
    Integer tripMinutesDuration;

    public TripSummary(List<LineDetails> lineDetails, String departureStationName, AffluenceLevel affluenceLevel, Double tripPrice, Integer tripMinutesDuration) {
        this.lineDetails = lineDetails;
        this.departureStationName = departureStationName;
        this.affluenceLevel = affluenceLevel;
        this.tripPrice = tripPrice;
        this.tripMinutesDuration = tripMinutesDuration;
    }
}
