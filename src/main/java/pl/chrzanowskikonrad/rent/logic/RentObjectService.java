package pl.chrzanowskikonrad.rent.logic;

import org.springframework.stereotype.Service;
import pl.chrzanowskikonrad.rent.domain.RentObjectData;
import pl.chrzanowskikonrad.rent.domain.RentObjectFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static pl.chrzanowskikonrad.rent.logic.JdbcUtil.*;

@Service
public class RentObjectService {

    private RentObjectJdbcRepository rentObjectJdbcRepository;

    public RentObjectService(RentObjectJdbcRepository rentObjectJdbcRepository) {
        this.rentObjectJdbcRepository = rentObjectJdbcRepository;
    }

    public Long create(RentObjectData data) {
        validateData(data);
        return rentObjectJdbcRepository.create(data);
    }

    public void update(RentObjectData data) {
        DataValidationUtil.validateValue(data.getId(), "id");
        validateData(data);
        rentObjectJdbcRepository.update(data);
    }

    public List<RentObjectData> find(RentObjectFilter filter) {
        return getRentObjects(rentObjectJdbcRepository.find(filter));
    }

    private List<RentObjectData> getRentObjects(List<Map<String, Object>> data) {
        List<RentObjectData> rentObjects = new ArrayList<>();

        for (Map<String, Object> row : data) {
            rentObjects.add(new RentObjectData(
                    getLong(row, "id"),
                    getString(row, "name"),
                    getBigDecimal(row, "unit_price"),
                    getFloat(row, "area"),
                    getString(row, "description"),
                    getLong(row, "landlord_id")
            ));
        }
        return rentObjects;
    }

    private void validateData(RentObjectData data) {
        DataValidationUtil.validateTextField(data.getName(), "name");
        DataValidationUtil.validateValue(data.getArea(), "area");
        DataValidationUtil.validateDescription(data.getDescription(), "description");
        DataValidationUtil.validateValue(data.getUnitPrice(), "unit price");
        DataValidationUtil.validateValue(data.getLandlordId(), "landlord_id");
    }


}
