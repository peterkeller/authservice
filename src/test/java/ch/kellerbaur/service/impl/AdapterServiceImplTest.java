package ch.kellerbaur.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ch.kellerbaur.model.AdapterUser;
import ch.kellerbaur.model.User;
import ch.kellerbaur.service.AdapterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdapterServiceImplTest {

    @Autowired
    private AdapterService adapterService;

    @Test
    public void testGetSystem1Method1WithC3() {
        final User user = new User();
        user.addRole("C3.C3");

        final Optional<AdapterUser> adapterUser = adapterService.getUser("system1", "getSystem1Method1", user);
        assertEquals("system1_1name", adapterUser.get().getName());
    }

    @Test
    public void testGetSystem1Method2WithC3AndClear() {
        final User user = new User();
        user.addRole("C3.C3");
        user.addRole("C3.CLEAR");

        final Optional<AdapterUser> adapterUser = adapterService.getUser("system1", "getSystem1Method2", user);
        assertEquals("system1_3name", adapterUser.get().getName());
    }

    @Test
    public void testGetRelaMethod1WithInfodienstAndClearAndTaxAndSondaAndSondm() {
        final User user = new User();
        user.addRole("C3.C3");
        user.addRole("C3.CLEAR");
        user.addRole("C3.TAX");
        user.addRole("C3.SONDA");
        user.addRole("C3.SONDM");

        final Optional<AdapterUser> adapterUser = adapterService.getUser("system2", "getSystem2Method1", user);
        assertEquals("system2_1name", adapterUser.get().getName());
    }

}
