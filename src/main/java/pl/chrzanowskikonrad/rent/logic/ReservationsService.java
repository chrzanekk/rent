package pl.chrzanowskikonrad.rent.logic;

import org.springframework.stereotype.Service;
import pl.chrzanowskikonrad.rent.domain.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;
import static pl.chrzanowskikonrad.rent.logic.JdbcUtil.*;

@Service
public class ReservationsService {

    private ReservationsJdbcRepository reservationsJdbcRepository;
    private TenantsService tenantsService;
    private LandlordsService landlordsService;
    private RentObjectService rentObjectService;

    public ReservationsService(ReservationsJdbcRepository reservationsJdbcRepository, TenantsService tenantsService, LandlordsService landlordsService, RentObjectService rentObjectService) {
        this.reservationsJdbcRepository = reservationsJdbcRepository;
        this.tenantsService = tenantsService;
        this.landlordsService = landlordsService;
        this.rentObjectService = rentObjectService;
    }

    public Long create(ReservationsData data) {
        Long landlordId = findLandlordId(data.getLandlordName());
        Long rentObjectId = findRentObjectId(data.getRentObjectName(), landlordId);
        validateDates(data.getStartDate(), data.getEndDate(), rentObjectId);
        validateEntryData(data);
        Long tenantId = findTenantId(data.getTenantName());
        if (tenantId == null) {
            tenantId = tenantsService.create(new TenantData(data.getTenantName()));
        }
        BigDecimal rentalCost = calculateRenCost(data.getStartDate(), data.getEndDate(), rentObjectId);
        return reservationsJdbcRepository.create(
                new ReservationsData(
                        data.getStartDate(),
                        data.getEndDate(),
                        tenantId,
                        rentObjectId,
                        rentalCost));
    }

    public void update(ReservationsData data){
        validateDates(data.getStartDate(),data.getEndDate(), data.getRentObjectId());
        validateEntryData(data);
        reservationsJdbcRepository.update(data);
    }


    public List<ReservationsData> find(ReservationsFilter filter) {
        return getReservations(reservationsJdbcRepository.findReservationsByLandlordName(filter));
    }

    private List<ReservationsData> getReservations(List<Map<String, Object>> data) {
        List<ReservationsData> list = new ArrayList<>();
        for (Map<String, Object> row : data) {
            list.add(new ReservationsData(
                    getLong(row, "reservation_id"),
                    getDate(row, "rental_start"),
                    getDate(row, "rental_end"),
                    getBigDecimal(row, "rental_cost"),
                    getString(row, "tenant_name"),
                    getString(row, "landlord_name"),
                    getString(row, "rent_object_name")));
        }
        return list;
    }

    private Long findTenantId(String name) {
        return tenantsService.find(new TenantFilter(name)).get(0).getId();
    }

    private Long findLandlordId(String name) {
        return landlordsService.find(new LandlordFilter(name)).get(0).getId();
    }

    private Long findRentObjectId(String name, Long id) {
        return rentObjectService.find(new RentObjectFilter(null, name, id)).get(0).getId();
    }

    private BigDecimal calculateRenCost(LocalDate startDate, LocalDate endDate, Long rentObjectId) {
        RentObjectData object = rentObjectService.find(new RentObjectFilter(rentObjectId)).get(0);
        BigDecimal pricePerObject = calculatePricePerObject(object.getUnitPrice(), object.getArea());
        BigDecimal pricePerObjectPerDay = calculatePricePerObjectPerDay(pricePerObject, startDate);
        long rentDays = DAYS.between(endDate, startDate);
        return pricePerObjectPerDay.multiply(BigDecimal.valueOf(rentDays));
    }

    private BigDecimal calculatePricePerObject(BigDecimal unitPrice, Float area) {
        return unitPrice.multiply(BigDecimal.valueOf(area)).setScale(2, RoundingMode.HALF_EVEN);
    }

    private BigDecimal calculatePricePerObjectPerDay(BigDecimal price, LocalDate date) {
        BigDecimal result = (price.multiply(BigDecimal.valueOf(12))).divide(BigDecimal.valueOf(calculateDaysInYear(date)));
        return result;
    }

    private Integer calculateDaysInYear(LocalDate date) {
        if (date.isLeapYear()) {
            return 366;
        }
        return 365;
    }


    private void validateEntryData(ReservationsData data) {
        DataValidationUtil.validateTextField(data.getTenantName(), "tenant name");
        DataValidationUtil.validateTextField(data.getLandlordName(), "landlord name");
        DataValidationUtil.validateTextField(data.getRentObjectName(), "rent object name");
        DataValidationUtil.validateDate(data.getStartDate(), "data początkowa");
        DataValidationUtil.validateDate(data.getEndDate(), "data końcowa");
    }

    private void validateDates(LocalDate startDate, LocalDate endDate, Long id) {
        List<ReservationsData> reservations = find(new ReservationsFilter(id));
        for (ReservationsData data : reservations) {
            if (startDate.isBefore(data.getEndDate())) {
                throw new IllegalArgumentException("Data rozpoczęcia najmu niedostępna. Obiekt dostępny od " + data.getEndDate().plusDays(1));
            }
            if (endDate.isAfter(data.getStartDate())) {
                throw new IllegalArgumentException("Data zakończenia najmu niedostępna. Obiekt dostępny jest do " + data.getStartDate().minusDays(1));
            }
        }
    }

}
