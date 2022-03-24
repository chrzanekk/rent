package pl.chrzanowskikonrad.rent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.chrzanowskikonrad.rent.domain.ReservationsData;
import pl.chrzanowskikonrad.rent.domain.ReservationsFilter;
import pl.chrzanowskikonrad.rent.logic.ReservationsService;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ReservationServiceTests {

    @Autowired
    private ReservationsService reservationsService;

    @Test
    public void checkIfAnyDataExists() {
//        given
        ReservationsFilter filter = new ReservationsFilter();
//        when
        Integer size = reservationsService.find(filter).size();
//        then
        assertThat(size).isNotZero();
    }
    @Test
    public void checkIfCanCreateReservationWithCorrectData() {
//      given
        ReservationsData newReservation = new ReservationsData(
                LocalDate.of(2022, 6, 12),
                LocalDate.of(2022, 7, 12),
                "Jakub Zastawski",
                "Jan Kowalski",
                "Obiekt nr 1");
//      when
        long id = reservationsService.create(newReservation);
//      then
        assertEquals(id,7L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfCanCreateReservationWithInCorrectData() {
//      given
        ReservationsData newReservation = new ReservationsData(
                LocalDate.of(2022, 5, 12),
                LocalDate.of(2022, 7, 12),
                "Jakub Zastawski",
                "Jan Kowalski",
                "Obiekt nr 1");
//      when
        long id = reservationsService.create(newReservation);
    }
}
