package pl.chrzanowskikonrad.rent.domain;

public class LandlordFilter {
    private Long id;
    private String name;

    public LandlordFilter(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public LandlordFilter() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
