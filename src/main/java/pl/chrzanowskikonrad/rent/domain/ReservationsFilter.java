package pl.chrzanowskikonrad.rent.domain;

public class ReservationsFilter {

    private Long landlordId;
    private Long rentObjectId;

    public ReservationsFilter(Long landlordId, Long rentObjectId) {
        this.landlordId = landlordId;
        this.rentObjectId = rentObjectId;
    }

    public ReservationsFilter() {
    }

    public Long getLandlordId() {
        return landlordId;
    }

    public Long getRentObjectId() {
        return rentObjectId;
    }
}
