package fr.isep.jotransportapp.services;

import fr.isep.jotransportapp.helpers.ColorHelpers;
import fr.isep.jotransportapp.models.Station;
import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.models.responses.SearchResponse;
import fr.isep.jotransportapp.models.responses.StationDescription;
import fr.isep.jotransportapp.viewModels.TransportTypes;

import java.util.List;
import java.util.UUID;

public class SearchServiceImpl implements SearchService {

    @Override
    public SearchResponse getResults(SearchParameters parameters) {
        // TODO change this to call the real service
        return new SearchResponse(
                List.of(
                        new StationDescription(
                                List.of(
                                        new Station("N", ColorHelpers.fromRGBCode("#0FF9A4"))),
                                "Gare Montparnasse",
                                TransportTypes.TRAIN,
                                UUID.randomUUID().toString()
                        ),
                        new StationDescription(
                                List.of(
                                        new Station("132", ColorHelpers.fromRGBCode("#FF479F")),
                                        new Station("513", ColorHelpers.fromRGBCode("#FBFF47")),
                                        new Station("868", ColorHelpers.fromRGBCode("#47E9FF"))
                                ),
                                "Gare routière d’Asnières",
                                TransportTypes.BUS,
                                UUID.randomUUID().toString()
                        ),
                        new StationDescription(
                                List.of(
                                        new Station("6", ColorHelpers.fromRGBCode("#FF6847"))),
                                "Garnier",
                                TransportTypes.METRO,
                                UUID.randomUUID().toString()
                        )
                )

        );
    }
}
