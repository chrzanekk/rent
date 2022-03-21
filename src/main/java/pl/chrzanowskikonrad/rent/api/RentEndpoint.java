package pl.chrzanowskikonrad.rent.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rent")
public class RentEndpoint {


    public RentEndpoint() {
    }

    @GetMapping(path = "/reservations/{id}", produces = "application/json; charset=UTF-8")
    public ReservationsRequestGetResponse getReservationsByLandLord(@PathVariable Long id){
        return null;
    }
}
