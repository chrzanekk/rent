package pl.chrzanowskikonrad.rent.api;

import java.time.LocalDate;

public class ReservationPutRequest {
    private Long id;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private Long tenantId;
    private Long rentObjectId;

    public ReservationPutRequest(Long id,
                                 LocalDate rentStartDate,
                                 LocalDate rentEndDate,
                                 Long tenantId,
                                 Long rentObjectId) {
        this.id = id;
        this.rentStartDate = rentStartDate;
        this.rentEndDate = rentEndDate;
        this.tenantId = tenantId;
        this.rentObjectId = rentObjectId;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getRentStartDate() {
        return rentStartDate;
    }

    public LocalDate getRentEndDate() {
        return rentEndDate;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public Long getRentObjectId() {
        return rentObjectId;
    }
}
