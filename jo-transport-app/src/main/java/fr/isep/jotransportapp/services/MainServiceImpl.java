package fr.isep.jotransportapp.services;

import fr.isep.jotransportapp.helpers.ColorHelpers;
import fr.isep.jotransportapp.models.Line;
import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.models.responses.SearchResponse;
import fr.isep.jotransportapp.models.responses.LineDescription;
import fr.isep.jotransportapp.viewModels.TransportTypes;

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
}
