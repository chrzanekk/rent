package pl.chrzanowskikonrad.rent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.chrzanowskikonrad.rent.domain.RentObjectFilter;
import pl.chrzanowskikonrad.rent.logic.RentObjectService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RentObjectServiceTests {

    @Autowired
    private RentObjectService rentObjectService;

    @Test
    public void checkIfAnyDataExists() {
//        given
        RentObjectFilter filter = new RentObjectFilter();
//        when
        Integer size = rentObjectService.find(filter).size();
//      then
        assertThat(size).isNotZero();
    }
}
