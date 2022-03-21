package pl.chrzanowskikonrad.rent.logic;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommonJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    public CommonJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long getLastInsertedId() {
        String query;
        query = "select last_insert_id() ";
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
