package pl.chrzanowskikonrad.rent.logic;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.chrzanowskikonrad.rent.domain.LandlordData;
import pl.chrzanowskikonrad.rent.domain.LandlordFilter;

import java.util.List;
import java.util.Map;

@Service
public class LandlordsJdbcRepository {
    private JdbcTemplate jdbcTemplate;
    private CommonJdbcRepository commonJdbcRepository;

    public LandlordsJdbcRepository(JdbcTemplate jdbcTemplate, CommonJdbcRepository commonJdbcRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.commonJdbcRepository = commonJdbcRepository;
    }

    public Long create(LandlordData data) {
        String query = "INSERT INTO landlords (name) VALUES (?)";
        jdbcTemplate.update(query);
        return commonJdbcRepository.getLastInsertedId();
    }

    public void update(LandlordData data) {
        String query = "UPDATE landlords SET name = ?, modify_date = ? WHERE id = ?;";
        jdbcTemplate.update(query, data.getName(), data.getModifyDate(), data.getId());
    }

    public List<Map<String, Object>> find(LandlordFilter filter) {
        String query = "SELECT * FROM landlords ";
        if (filter != null) {
            query += " WHERE 1=1 ";
            if (filter.getName() != null) {
                query += " AND landlords.id = '" + filter.getId() + "'";
            }
            if (filter.getName() != null) {
                query += " AND landlords.name = '" + filter.getName() + "'";
            }
        }
        return jdbcTemplate.queryForList(query);
    }
}
