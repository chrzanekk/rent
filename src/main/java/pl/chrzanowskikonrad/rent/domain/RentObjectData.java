package pl.chrzanowskikonrad.rent.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentObjectData {
    private Long id;
    private String name;
    private BigDecimal unitPrice;
    private Float area;
    private String description;
    private Long landlordId;
    private LocalDateTime modifyDate;
    private LocalDateTime removeDate;

    public RentObjectData(Long id, String name, BigDecimal unitPrice, Float area, String description, Long landlordId) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.area = area;
        this.description = description;
        this.landlordId = landlordId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public Long getLandlordId() {
        return landlordId;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public LocalDateTime getRemoveDate() {
        return removeDate;
    }
}
