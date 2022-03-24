package pl.chrzanowskikonrad.rent.logic;

import org.springframework.stereotype.Service;
import pl.chrzanowskikonrad.rent.domain.ReservationsData;
import pl.chrzanowskikonrad.rent.domain.ReservationsFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static pl.chrzanowskikonrad.rent.logic.JdbcUtil.*;

@Service
public class ReservationsService {

    private ReservationsJdbcRepository repository;

    public ReservationsService(ReservationsJdbcRepository repository) {
        this.repository = repository;
    }




    public List<ReservationsData> find(ReservationsFilter filter) {
        return getReservations(repository.findReservationsByLandlordName(filter));
    }

    private List<ReservationsData> getReservations(List<Map<String, Object>> data) {
        List<ReservationsData> list = new ArrayList<>();
        for (Map<String, Object> row : data) {
            list.add(new ReservationsData(
                    getLong(row, "reservation_id"),
                    getDate(row, "rental_start"),
                    getDate(row,"rental_end"),
                    getBigDecimal(row,"rental_cost"),
                    getString(row, "tenant_name"),
                    getString(row, "landlord_name"),
                    getString(row, "rent_object_name")));
        }
        return list;
    }
}
