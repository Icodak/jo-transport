package fr.isep.jotransportapp.models.parameters;

import java.util.List;

public class TripParameters {
    public String departureUuid;
    public String arrivalUuid;
    public List<String> stepsUuids;

    public TripParameters(String departureUuid, String arrivalUuid, List<String> stepsUuids) {
        this.departureUuid = departureUuid;
        this.arrivalUuid = arrivalUuid;
        this.stepsUuids = stepsUuids;
    }
}
