package fr.isep.jotransportapp.services;

import fr.isep.jotransportapp.helpers.ColorHelpers;
import fr.isep.jotransportapp.models.*;
import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.models.parameters.TripParameters;
import fr.isep.jotransportapp.models.responses.LineDescription;
import fr.isep.jotransportapp.models.responses.SearchResponse;
import fr.isep.jotransportapp.models.responses.TripResponse;

import java.util.List;
import java.util.UUID;

public class MainServiceImpl implements MainService {

    @Override
    public SearchResponse getResults(SearchParameters parameters) {
        // TODO change this to call the real implementation
        return new SearchResponse(
                List.of(
                        new LineDescription(
                                List.of(
                                        new Line("N", ColorHelpers.fromRGBCode("#0FF9A4"))),
                                "Gare Montparnasse",
                                TransportTypes.TRAIN,
                                UUID.randomUUID().toString()
                        ),
                        new LineDescription(
                                List.of(
                                        new Line("132", ColorHelpers.fromRGBCode("#FF479F")),
                                        new Line("513", ColorHelpers.fromRGBCode("#FBFF47")),
                                        new Line("868", ColorHelpers.fromRGBCode("#47E9FF"))
                                ),
                                "Gare routière d’Asnières",
                                TransportTypes.BUS,
                                UUID.randomUUID().toString()
                        ),
                        new LineDescription(
                                List.of(
                                        new Line("6", ColorHelpers.fromRGBCode("#FF6847"))),
                                "Garnier",
                                TransportTypes.METRO,
                                UUID.randomUUID().toString()
                        )
                )

        );
    }

    @Override
    public TripResponse getTrips(TripParameters parameters) {
        // TODO change this to call the real implementation
        return new TripResponse(List.of(
                new TripSummary(
                        List.of(
                                new LineDetails(
                                        new Line("U", ColorHelpers.fromRGBCode("#FF6677")),
                                        List.of("Raspail", "Montparnasse-Bienvenue", "Victor Hugo", "Glaciere")
                                )
                        ),
                        "Raspail",
                        AffluenceLevel.MEDIUM,
                        1.20,
                        26,
                        List.of(TransportTypes.TRAIN)
                ),
                new TripSummary(
                        List.of(
                                new LineDetails(
                                        new Line("N", ColorHelpers.fromRGBCode("#319794")),
                                        List.of("Versailles", "Vanves")
                                ),
                                new LineDetails(
                                        new Line("U", ColorHelpers.fromRGBCode("#FF6677")),
                                        List.of("Vanves-Malakoff", "St-Cyr", "Bennes", "Pluton")
                                ),
                                new LineDetails(
                                        new Line("135", ColorHelpers.fromRGBCode("#0034FF")),
                                        List.of("Albert Camus", "Jean Monnet")
                                )
                        ),
                        "Versailles",
                        AffluenceLevel.NONE,
                        2.9,
                        12,
                        List.of(TransportTypes.TRAIN, TransportTypes.BUS)
                ),
                new TripSummary(
                        List.of(
                                new LineDetails(
                                        new Line("8", ColorHelpers.fromRGBCode("#aa6622")),
                                        List.of("Raspail", "Montparnasse-Bienvenue", "Victor Hugo", "Glaciere")
                                )
                        ),
                        "Raspail",
                        AffluenceLevel.MEDIUM,
                        4.6,
                        8,
                        List.of(TransportTypes.METRO)
                )
        ));
    }
}
