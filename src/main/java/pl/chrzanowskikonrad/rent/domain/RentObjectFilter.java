package pl.chrzanowskikonrad.rent.domain;

import java.math.BigDecimal;

public class RentObjectFilter {
    private Long id;
    private String name;
    private Long landlordId;

    public RentObjectFilter(Long id, String name, Long landlordId) {
        this.id = id;
        this.name = name;
        this.landlordId = landlordId;
    }

    public RentObjectFilter() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getLandlordId() {
        return landlordId;
    }
}
