package pl.chrzanowskikonrad.rent.domain;

public class TenantFilter {
    private Long id;
    private String name;

    public TenantFilter() {
    }

    public TenantFilter(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
