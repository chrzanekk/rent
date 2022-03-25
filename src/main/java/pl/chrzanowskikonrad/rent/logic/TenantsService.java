package pl.chrzanowskikonrad.rent.logic;

import org.springframework.stereotype.Service;
import pl.chrzanowskikonrad.rent.domain.TenantData;
import pl.chrzanowskikonrad.rent.domain.TenantFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static pl.chrzanowskikonrad.rent.logic.JdbcUtil.getLong;
import static pl.chrzanowskikonrad.rent.logic.JdbcUtil.getString;

@Service
public class TenantsService {

    private TenantsJdbcRepository tenantsJdbcRepository;

    public TenantsService(TenantsJdbcRepository tenantsJdbcRepository) {
        this.tenantsJdbcRepository = tenantsJdbcRepository;
    }

    public Long create(TenantData data) {
        DataValidationUtil.validateTextField(data.getName(), "name");
        tenantsJdbcRepository.create(data);
        int size = find(new TenantFilter()).size();
        return find(new TenantFilter()).get(size-1).getId();
    }

    public void update(TenantData data) {
        validateData(data);
        tenantsJdbcRepository.update(data);
    }

    public List<TenantData> find(TenantFilter filter) {
        return getTenants(tenantsJdbcRepository.find(filter));
    }

    private List<TenantData> getTenants(List<Map<String, Object>> data) {
        List<TenantData> tenants = new ArrayList<>();

        for (Map<String, Object> row : data) {
            tenants.add(new TenantData(
                    getLong(row, "id"),
                    getString(row, "name")
            ));
        }
        return tenants;
    }

    private void validateData(TenantData data) {
        DataValidationUtil.validateValue(data.getId(), "id");
        DataValidationUtil.validateTextField(data.getName(), "name");
    }


}
