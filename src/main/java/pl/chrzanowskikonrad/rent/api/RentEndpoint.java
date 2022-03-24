package pl.chrzanowskikonrad.rent.api;

import org.springframework.web.bind.annotation.*;
import pl.chrzanowskikonrad.rent.domain.*;
import pl.chrzanowskikonrad.rent.logic.LandlordsService;
import pl.chrzanowskikonrad.rent.logic.RentObjectService;
import pl.chrzanowskikonrad.rent.logic.ReservationsService;
import pl.chrzanowskikonrad.rent.logic.TenantsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rent")
public class RentEndpoint {

    private ReservationsService reservationsService;
    private LandlordsService landlordsService;
    private TenantsService tenantsService;
    private RentObjectService rentObjectService;

    public RentEndpoint(ReservationsService reservationsService, LandlordsService landlordsService, TenantsService tenantsService, RentObjectService rentObjectService) {
        this.reservationsService = reservationsService;
        this.landlordsService = landlordsService;
        this.tenantsService = tenantsService;
        this.rentObjectService = rentObjectService;
    }

    @GetMapping(path = "/reservations", produces = "application/json; charset=UTF-8")
    public ReservationsRequestGetResponse getReservationsByLandLord(
            @RequestParam(name = "landlordName", required = false) String landlordName,
            @RequestParam(name = "objectId", required = false) Long objectId) {
        List<ReservationsData> reservations = reservationsService.find(new ReservationsFilter(landlordName, objectId));
        return new ReservationsRequestGetResponse(reservationsToResponse(reservations));
    }

    @PostMapping(path = "/reservation", consumes = "application/json")
    public NewReservationGetResponse createReservation(@RequestBody NewReservationPostRequest request) {
        Long newReservationId = null;
        return null;
    }



//    mappings for tests only

    @GetMapping(path = "/landlords", produces = "application/json; charset=UTF-8")
    public List<LandlordData> getLandlords(){
        return landlordsService.find(new LandlordFilter());
    }

    @GetMapping(path = "/tenants", produces = "application/json; charset=UTF-8")
    public List<TenantData> getTenants(){
        return tenantsService.find(new TenantFilter());
    }

    @GetMapping(path = "/rent-objects", produces = "application/json; charset=UTF-8")
    public List<RentObjectData> getRentObjects(){
        return rentObjectService.find(new RentObjectFilter());
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
