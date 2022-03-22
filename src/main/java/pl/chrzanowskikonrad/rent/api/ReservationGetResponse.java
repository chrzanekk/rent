package pl.chrzanowskikonrad.rent.api;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservationGetResponse {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String tenantName;
    private String landlordName;
    private BigDecimal rentalCost;

    public ReservationGetResponse(Long id,
                                  LocalDate startDate,
                                  LocalDate endDate,
                                  String tenantName,
                                  String landlordName,
                                  BigDecimal rentalCost) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tenantName = tenantName;
        this.landlordName = landlordName;
        this.rentalCost = rentalCost;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public BigDecimal getRentalCost() {
        return rentalCost;
    }
}
