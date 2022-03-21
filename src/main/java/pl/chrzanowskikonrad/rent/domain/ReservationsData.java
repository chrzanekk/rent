package pl.chrzanowskikonrad.rent.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservationsData {
        private Long id;
        private LocalDate startDate;
        private LocalDate endDate;
        private Long tenantId;
        private Long rentObjectId;
        private BigDecimal rentalCost;

        private String tenantFirstName;
        private String tenantLastName;

        private Long landlordId;
        private String landlordFirstName;
        private String landlordLastName;

        private String rentObjectName;
        private BigDecimal unitPrice;
        private Float area;
        private String description;

    public ReservationsData() {
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

    public Long getTenantId() {
        return tenantId;
    }

    public Long getRentObjectId() {
        return rentObjectId;
    }

    public BigDecimal getRentalCost() {
        return rentalCost;
    }

    public String getTenantFirstName() {
        return tenantFirstName;
    }

    public String getTenantLastName() {
        return tenantLastName;
    }

    public Long getLandlordId() {
        return landlordId;
    }

    public String getLandlordFirstName() {
        return landlordFirstName;
    }

    public String getLandlordLastName() {
        return landlordLastName;
    }

    public String getRentObjectName() {
        return rentObjectName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Float getArea() {
        return area;
    }

    public String getDescription() {
        return description;
    }
}
