package pl.chrzanowskikonrad.rent.logic;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.chrzanowskikonrad.rent.domain.TenantData;
import pl.chrzanowskikonrad.rent.domain.TenantFilter;

import java.util.List;
import java.util.Map;

@Service
public class TenantsJdbcRepository {
    private JdbcTemplate jdbcTemplate;

    public TenantsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(TenantData data) {
        String query = "INSERT INTO landlords (name) VALUES (?)";
        jdbcTemplate.update(query);
    }

    public void update(TenantData data) {
        String query = "UPDATE tenants SET name = ?, modify_date = ? WHERE id = ?";
        jdbcTemplate.update(query, data.getName(), data.getModifyDate(), data.getId());
    }

    public List<Map<String, Object>> find(TenantFilter filter) {
        String query = "SELECT * FROM tenants ";
        if (filter != null) {
            query += " WHERE 1=1 ";
            if (filter.getId() != null) {
                query += " AND tenants.id = '" + filter.getId() + "'";
            }
            if (filter.getName() != null) {
                query += " AND tenants.name = '" + filter.getName() + "'";
            }
        }
        return jdbcTemplate.queryForList(query);
    }
}
