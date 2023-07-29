package fr.isep.jotransportapp.model.parameters;

import java.util.List;
import java.util.UUID;

public class TripParameters {
    UUID departure;
    UUID arrival;
    List<UUID> steps;
}
