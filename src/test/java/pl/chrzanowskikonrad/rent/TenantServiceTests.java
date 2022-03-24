package pl.chrzanowskikonrad.rent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.chrzanowskikonrad.rent.domain.TenantFilter;
import pl.chrzanowskikonrad.rent.logic.TenantsService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TenantServiceTests {

    @Autowired
    private TenantsService tenantsService;

    @Test
    public void checkIfAnyDataExists(){
//        given
        TenantFilter filter = new TenantFilter();
//        when
        Integer size = tenantsService.find(filter).size();
//        then
        assertThat(size).isNotZero();
    }
}
