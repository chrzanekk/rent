package pl.chrzanowskikonrad.rent.logic;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.chrzanowskikonrad.rent.domain.RentObjectData;
import pl.chrzanowskikonrad.rent.domain.RentObjectFilter;

import java.util.List;
import java.util.Map;

@Service
public class RentObjectJdbcRepository {
    private JdbcTemplate jdbcTemplate;
    private CommonJdbcRepository commonJdbcRepository;

    public RentObjectJdbcRepository(JdbcTemplate jdbcTemplate, CommonJdbcRepository commonJdbcRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.commonJdbcRepository = commonJdbcRepository;
    }

    public Long create(RentObjectData data) {
        String query = "INSERT INTO rent_objects (" +
                "name, " +
                "unit_price, " +
                "area, " +
                "description, " +
                "landlord_id) VALUES (" +
                "?," +
                "?," +
                "?," +
                "?," +
                "? )";
        jdbcTemplate.update(query,
                data.getName(),
                data.getUnitPrice(),
                data.getArea(),
                data.getDescription(),
                data.getLandlordId());
        return commonJdbcRepository.getLastInsertedId();
    }

    public void update(RentObjectData data) {
        String query = "UPDATE rent_objects SET " +
                "name = ?," +
                "unit_price = ?," +
                "area = ?," +
                "description = ?," +
                "landlord_id = ?," +
                "modify_date = ? WHERE " +
                "id = ? ";
        jdbcTemplate.update(query,
                data.getName(),
                data.getUnitPrice(),
                data.getArea(),
                data.getDescription(),
                data.getLandlordId(),
                data.getModifyDate(),
                data.getId());
    }

    public List<Map<String,Object>> find(RentObjectFilter filter) {
        String query = "SELECT * FROM rent_objects ";
        if(filter != null) {
            query += " WHERE 1=1 ";
            if(filter.getId() != null){
                query += " AND rent_objects.id = '" + filter.getId() + "'";
            }
            if(filter.getName() != null){
                query += " AND rent_objects.name = '" + filter.getName() + "'";
            }
            if(filter.getLandlordId() != null){
                query += " AND rent_objects.landlord_id = '" + filter.getLandlordId() + "'";
            }
        }
        return jdbcTemplate.queryForList(query);
    }
}
