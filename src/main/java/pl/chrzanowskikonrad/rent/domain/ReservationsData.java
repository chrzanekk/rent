package pl.chrzanowskikonrad.rent.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationsData {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long tenantId;
    private Long rentObjectId;
    private BigDecimal rentalCost;

    private String tenantName;

    private Long landlordId;
    private String landlordName;

    private String rentObjectName;
    private BigDecimal unitPrice;
    private Float area;
    private String description;

    private LocalDateTime modifyDate;
    private LocalDateTime removeDate;

    public ReservationsData(Long id,
                            LocalDate startDate,
                            LocalDate endDate,
                            BigDecimal rentalCost,
                            String tenantName,
                            String landlordName,
                            String rentObjectName) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentalCost = rentalCost;
        this.tenantName = tenantName;
        this.landlordName = landlordName;
        this.rentObjectName = rentObjectName;
    }

    public ReservationsData(LocalDate startDate,
                            LocalDate endDate,
                            String tenantName,
                            String landlordName,
                            String rentObjectName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.tenantName = tenantName;
        this.landlordName = landlordName;
        this.rentObjectName = rentObjectName;
    }

    public ReservationsData(LocalDate startDate,
                            LocalDate endDate,
                            Long tenantId,
                            Long rentObjectId,
                            BigDecimal rentalCost) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.tenantId = tenantId;
        this.rentObjectId = rentObjectId;
        this.rentalCost = rentalCost;
    }

    public ReservationsData(Long id,
                            LocalDate startDate,
                            LocalDate endDate,
                            Long tenantId,
                            Long rentObjectId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tenantId = tenantId;
        this.rentObjectId = rentObjectId;
        this.modifyDate = LocalDateTime.now();
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

    public Long getLandlordId() {
        return landlordId;
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

    public String getTenantName() {
        return tenantName;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public LocalDateTime getRemoveDate() {
        return removeDate;
    }
}
