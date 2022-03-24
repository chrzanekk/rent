package pl.chrzanowskikonrad.rent.domain;

public class ReservationsFilter {

    private Long id;
    private String landlordName;
    private Long rentObjectId;

    public ReservationsFilter() {
    }

    public ReservationsFilter(Long id, String landlordName) {
        this.id = id;
        this.landlordName = landlordName;
    }

    public ReservationsFilter(String landlordName) {
        this.landlordName = landlordName;
    }

    public ReservationsFilter(Long rentObjectId) {
        this.rentObjectId = rentObjectId;
    }

    public ReservationsFilter(String landlordName, Long rentObjectId) {
        this.landlordName = landlordName;
        this.rentObjectId = rentObjectId;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public Long getRentObjectId() {
        return rentObjectId;
    }
}
