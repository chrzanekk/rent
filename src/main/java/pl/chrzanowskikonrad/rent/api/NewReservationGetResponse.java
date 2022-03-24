package pl.chrzanowskikonrad.rent.api;

public class NewReservationGetResponse {
    private Long reservationId;

    public NewReservationGetResponse(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getReservationId() {
        return reservationId;
    }
}
