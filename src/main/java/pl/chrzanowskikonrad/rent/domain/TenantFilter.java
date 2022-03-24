package pl.chrzanowskikonrad.rent.domain;

public class TenantFilter {
    private Long id;
    private String name;

    public TenantFilter(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TenantFilter() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
