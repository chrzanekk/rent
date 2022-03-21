package pl.chrzanowskikonrad.rent.api;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservationGetResponse {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String tenantFirstName;
    private String tenantLastName;
    private String landlordFirstName;
    private String landlordLastName;
    private BigDecimal rentalCost;

    public ReservationGetResponse(Long id,
                                  LocalDate startDate,
                                  LocalDate endDate,
                                  String tenantFirstName,
                                  String tenantLastName,
                                  String landlordFirstName,
                                  String landlordLastName,
                                  BigDecimal rentalCost) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tenantFirstName = tenantFirstName;
        this.tenantLastName = tenantLastName;
        this.landlordFirstName = landlordFirstName;
        this.landlordLastName = landlordLastName;
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

    public String getTenantFirstName() {
        return tenantFirstName;
    }

    public String getTenantLastName() {
        return tenantLastName;
    }

    public String getLandlordFirstName() {
        return landlordFirstName;
    }

    public String getLandlordLastName() {
        return landlordLastName;
    }

    public BigDecimal getRentalCost() {
        return rentalCost;
    }
}
