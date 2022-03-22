package pl.chrzanowskikonrad.rent.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.chrzanowskikonrad.rent.domain.ReservationsFilter;
import pl.chrzanowskikonrad.rent.logic.CommonJdbcRepository;

import java.util.List;
import java.util.Map;

@Service
public class ReservationsJdbcRepository {

    private JdbcTemplate jdbcTemplate;
    private CommonJdbcRepository commonJdbcRepository;

    public ReservationsJdbcRepository(JdbcTemplate jdbcTemplate, CommonJdbcRepository commonJdbcRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.commonJdbcRepository = commonJdbcRepository;
    }

    public List<Map<String, Object>> findReservationsByLandlordName(ReservationsFilter filter) {

        String query = getMainFindQuery();

        query = prepareFilterQuery(filter, query);

        return jdbcTemplate.queryForList(query);
    }

    private String getMainFindQuery() {
        return "SELECT \n" +
                "reservations.id AS reservation_id,\n" +
                "reservations.rental_start AS rental_start,\n" +
                "reservations.rental_end AS rental_end,\n" +
                "reservations.rental_cost AS rental_cost,\n" +
                "tenants.id AS tenant_id,\n" +
                "tenants.name AS tenant_name,\n" +
                "landlords.id AS landlord_id,\n" +
                "landlords.name AS landlord_name,\n" +
                "rent_objects.id AS rent_object_id,\n" +
                "rent_objects.NAME AS rent_object_name,\n" +
                "rent_objects.unit_price AS unit_price,\n" +
                "rent_objects.AREA AS object_area,\n" +
                "rent_objects.description AS description\n" +
                "FROM reservations \n" +
                "JOIN tenants ON (reservations.tenant_id = tenants.id) \n" +
                "JOIN rent_objects ON (reservations.rent_object_id = rent_objects.id)\n" +
                "JOIN landlords ON (rent_objects.landlord_id = landlords.id) ";
    }

    private String prepareFilterQuery(ReservationsFilter filter, String query) {
        if (filter != null) {
            if (filter.getLandlordName() != null && filter.getRentObjectId() != null) {
                query += " WHERE landlords.name = '" + filter.getLandlordName() + "' AND rent_objects.id = '" + filter.getRentObjectId() + "'";
            }
            if (filter.getLandlordName() != null) {
                query += " WHERE landlords.name = '" + filter.getLandlordName() + "'";
            }
            if (filter.getRentObjectId() != null) {
                query += " WHERE rent_objects.id = '" + filter.getRentObjectId() + "'";
            }
        }
        return query;
    }
}
