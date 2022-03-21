package pl.chrzanowskikonrad.rent.api;

import java.util.List;

public class ReservationsRequestGetResponse {

    private List<ReservationGetResponse> reservations;

    public ReservationsRequestGetResponse(List<ReservationGetResponse> reservations) {
        this.reservations = reservations;
    }

    public List<ReservationGetResponse> getReservations() {
        return reservations;
    }
}
