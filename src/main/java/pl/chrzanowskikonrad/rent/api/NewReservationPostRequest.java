package pl.chrzanowskikonrad.rent.api;

import java.time.LocalDate;

public class NewReservationPostRequest {

    private String tenantName;
    private String landlordName;
    private LocalDate rentStart;
    private LocalDate rentEnd;
    private Long rentObjectId;
    private String rentObjectName;

    public NewReservationPostRequest(String tenantName,
                                     String landlordName,
                                     LocalDate rentStart,
                                     LocalDate rentEnd,
                                     Long rentObjectId,
                                     String rentObjectName) {
        this.tenantName = tenantName;
        this.landlordName = landlordName;
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
        this.rentObjectId = rentObjectId;
        this.rentObjectName = rentObjectName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public LocalDate getRentStart() {
        return rentStart;
    }

    public LocalDate getRentEnd() {
        return rentEnd;
    }

    public Long getRentObjectId() {
        return rentObjectId;
    }

    public String getRentObjectName() {
        return rentObjectName;
    }
}
