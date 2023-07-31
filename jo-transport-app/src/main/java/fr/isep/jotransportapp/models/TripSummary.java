package fr.isep.jotransportapp.models;

import java.util.List;

public class TripSummary {
    /*
     * Contains all the details of a trip
     */
    public List<LineDetails> lineDetails;
    public String departureStationName;
    public AffluenceLevel affluenceLevel;
    public Double tripPrice;
    public Integer tripMinutesDuration;

    public List<TransportTypes> usedTransportTypes;

    public TripSummary(List<LineDetails> lineDetails, String departureStationName, AffluenceLevel affluenceLevel, Double tripPrice, Integer tripMinutesDuration, List<TransportTypes> usedTransportTypes) {
        this.lineDetails = lineDetails;
        this.departureStationName = departureStationName;
        this.affluenceLevel = affluenceLevel;
        this.tripPrice = tripPrice;
        this.tripMinutesDuration = tripMinutesDuration;
        this.usedTransportTypes = usedTransportTypes;
    }
}
