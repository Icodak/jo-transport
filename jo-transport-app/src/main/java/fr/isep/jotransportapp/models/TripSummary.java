package fr.isep.jotransportapp.models;

import fr.isep.jotransportapp.viewModels.AffluenceLevel;
import fr.isep.jotransportapp.viewModels.TransportTypes;

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

    List<TransportTypes> usedTransportTypes;

    public TripSummary(List<LineDetails> lineDetails, String departureStationName, AffluenceLevel affluenceLevel, Double tripPrice, Integer tripMinutesDuration, List<TransportTypes> usedTransportTypes) {
        this.lineDetails = lineDetails;
        this.departureStationName = departureStationName;
        this.affluenceLevel = affluenceLevel;
        this.tripPrice = tripPrice;
        this.tripMinutesDuration = tripMinutesDuration;
        this.usedTransportTypes = usedTransportTypes;
    }
}
