package pl.chrzanowskikonrad.rent.domain;


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

    public RentObjectFilter(Long id) {
        this.id = id;
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
