package pl.chrzanowskikonrad.rent.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.chrzanowskikonrad.rent.domain.ReservationsData;
import pl.chrzanowskikonrad.rent.domain.ReservationsFilter;
import pl.chrzanowskikonrad.rent.logic.ReservationsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rent")
public class RentEndpoint {

    private ReservationsService reservationsService;

    public RentEndpoint(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping(path = "/reservations", produces = "application/json; charset=UTF-8")
    public ReservationsRequestGetResponse getReservationsByLandLord(
            @RequestParam(name = "landlordName", required = false) String landlordName,
            @RequestParam(name = "objectId", required = false) Long objectId) {
        List<ReservationsData> reservations = reservationsService.find(new ReservationsFilter(landlordName, objectId));
        return new ReservationsRequestGetResponse(reservationsToResponse(reservations));
    }


    private List<ReservationGetResponse> reservationsToResponse(List<ReservationsData> reservations) {
        List<ReservationGetResponse> list = new ArrayList<>();
        for (ReservationsData data : reservations) {
            list.add(new ReservationGetResponse(
                    data.getId(),
                    data.getStartDate(),
                    data.getEndDate(),
                    data.getTenantName(),
                    data.getLandlordName(),
                    data.getRentalCost()
            ));
        }
        return list;
    }
}
