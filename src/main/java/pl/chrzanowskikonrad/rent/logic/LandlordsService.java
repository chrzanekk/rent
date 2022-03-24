package pl.chrzanowskikonrad.rent.logic;

import org.springframework.stereotype.Service;
import pl.chrzanowskikonrad.rent.domain.LandlordData;
import pl.chrzanowskikonrad.rent.domain.LandlordFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static pl.chrzanowskikonrad.rent.logic.JdbcUtil.getLong;
import static pl.chrzanowskikonrad.rent.logic.JdbcUtil.getString;

@Service
public class LandlordsService {

    private LandlordsJdbcRepository landlordsJdbcRepository;

    public LandlordsService(LandlordsJdbcRepository landlordsJdbcRepository) {
        this.landlordsJdbcRepository = landlordsJdbcRepository;
    }

    public Long create(LandlordData data) {
        DataValidationUtil.validateTextField(data.getName(), "name");
        return landlordsJdbcRepository.create(data);
    }

    public void update(LandlordData data) {
        validateData(data);
        landlordsJdbcRepository.update(data);
    }

    public List<LandlordData> find(LandlordFilter filter) {
        return getLandlords(landlordsJdbcRepository.find(filter));
    }


    private List<LandlordData> getLandlords(List<Map<String, Object>> data) {
        List<LandlordData> landlords = new ArrayList<>();

        for (Map<String, Object> row : data) {
            landlords.add(new LandlordData(
                    getLong(row, "id"),
                    getString(row, "name")
            ));
        }
        return landlords;
    }

    private void validateData(LandlordData data) {
        DataValidationUtil.validateValue(data.getId(), "id");
        DataValidationUtil.validateTextField(data.getName(), "name");
    }

}
