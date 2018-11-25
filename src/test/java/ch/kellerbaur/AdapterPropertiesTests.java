package ch.kellerbaur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ch.kellerbaur.model.Method;
import ch.kellerbaur.model.Rule;
import ch.kellerbaur.model.RuleGroup;
import ch.kellerbaur.model.AdapterUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdapterPropertiesTests {

    @Autowired
    private AdapterProperties properties;

    @Test
    public void testAdapterProperties() {
        assertNotNull(properties);

        final List<Method> methods = properties.getMethods();
        System.out.println("methods = " + methods);
        assertEquals(4, methods.size());

        final List<RuleGroup> ruleGroups = properties.getRuleGroups();
        System.out.println("ruleGroups = " + ruleGroups);
        assertEquals(2, ruleGroups.size());

        final RuleGroup ruleGroup0 = ruleGroups.get(0);
        assertNotNull(ruleGroup0.getId());
        assertEquals(1, ruleGroup0.getRules().size());
        assertEquals(1, ruleGroup0.getRules().get(0).getOrder().intValue());
        assertEquals("DEFAULT", ruleGroup0.getRules().get(0).getRuleId());
        assertEquals(2, ruleGroup0.getRules().get(0).getAdapters().size());

        final RuleGroup ruleGroup1 = ruleGroups.get(1);
        assertNotNull(ruleGroup1.getId());
        assertEquals(5, ruleGroup1.getRules().size());
        assertEquals(2, ruleGroup1.getRules().get(0).getAdapters().size());
        assertEquals(2, ruleGroup1.getRules().get(1).getAdapters().size());
        assertEquals(2, ruleGroup1.getRules().get(2).getAdapters().size());
        assertEquals(2, ruleGroup1.getRules().get(3).getAdapters().size());
        assertEquals(2, ruleGroup1.getRules().get(4).getAdapters().size());

        final List<Rule> rules = properties.getRules();
        System.out.println("rules = " + rules);
        assertEquals(6, rules.size());
        assertNotNull(rules.get(0).getId());
        assertNotNull(rules.get(0).getExpression());

        final List<AdapterUser> users = properties.getUsers();
        System.out.println("users = " + users);
        assertEquals(6, users.size());
    }

}
