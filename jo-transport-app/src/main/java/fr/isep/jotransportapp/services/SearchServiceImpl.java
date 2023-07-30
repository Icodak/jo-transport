package fr.isep.jotransportapp.services;

import fr.isep.jotransportapp.models.Station;
import fr.isep.jotransportapp.models.parameters.SearchParameters;
import fr.isep.jotransportapp.models.responses.SearchResponse;
import fr.isep.jotransportapp.models.responses.StationDescription;
import fr.isep.jotransportapp.viewModels.TransportTypes;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.UUID;

public class SearchServiceImpl implements SearchService {

    @Override
    public SearchResponse getResults(SearchParameters parameters) {
        System.out.println(parameters.locationName);

        // TODO change this to call the real service
        return new SearchResponse(
                List.of(
                        new StationDescription(
                                List.of(
                                        new Station("N", Color.ALICEBLUE)),
                                "Gare montparnasse",
                                TransportTypes.TRAIN,
                                UUID.randomUUID().toString()
                        ),
                        new StationDescription(
                                List.of(
                                        new Station("132", Color.RED),
                                        new Station("513", Color.DARKBLUE),
                                        new Station("868", Color.GAINSBORO)
                                ),
                                "Gare routière d’Asnières",
                                TransportTypes.BUS,
                                UUID.randomUUID().toString()
                        ),
                        new StationDescription(
                                List.of(
                                        new Station("6", Color.ORANGE)),
                                "Garnier",
                                TransportTypes.METRO,
                                UUID.randomUUID().toString()
                        )
                )

        );
    }
}
