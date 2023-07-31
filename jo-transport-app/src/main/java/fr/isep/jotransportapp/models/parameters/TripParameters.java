package fr.isep.jotransportapp.models.parameters;

import java.util.List;
import java.util.UUID;

public class TripParameters {
    String departureUuid;
    String arrivalUuid;
    List<String> stepsUuids;

    public TripParameters(String departureUuid, String arrivalUuid, List<String> stepsUuids) {
        this.departureUuid = departureUuid;
        this.arrivalUuid = arrivalUuid;
        this.stepsUuids = stepsUuids;
    }
}
