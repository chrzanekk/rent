package pl.chrzanowskikonrad.rent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.chrzanowskikonrad.rent.domain.LandlordFilter;
import pl.chrzanowskikonrad.rent.logic.LandlordsService;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LandlordServiceTests {

    @Autowired
    private LandlordsService landlordsService;

    @Test
    public void checkIfAnyDataExists() {
//        given
        LandlordFilter filter = new LandlordFilter();
//        when
        Integer size = landlordsService.find(filter).size();
//        then

        assertThat(size).isNotZero();

    }
}
