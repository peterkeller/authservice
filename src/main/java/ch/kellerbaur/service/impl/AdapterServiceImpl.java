package ch.kellerbaur.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udojava.evalex.Expression;

import ch.kellerbaur.AdapterProperties;
import ch.kellerbaur.model.AdapterUser;
import ch.kellerbaur.model.Rule;
import ch.kellerbaur.model.RuleGroup;
import ch.kellerbaur.model.RuleGroupAdapter;
import ch.kellerbaur.model.RuleGroupRule;
import ch.kellerbaur.model.User;
import ch.kellerbaur.service.AdapterService;

@Component
public class AdapterServiceImpl implements AdapterService {

    @Autowired
    private AdapterProperties adapterProperties;

    @Override
    public Optional<AdapterUser> getUser(final String adapterId, final String methodName, final User user) {
        final Optional<RuleGroup> ruleGroup = adapterProperties.getRuleGroup(adapterId, methodName);
        if (!ruleGroup.isPresent()) {
            return Optional.empty();
        }
        for (final RuleGroupRule ruleGroupRule : ruleGroup.get().getRules()) {
            final Optional<Rule> rule = adapterProperties.getRule(ruleGroupRule.getRuleId());
            if (rule.isPresent()) {
                if (check(rule.get().getExpression(), user)) {
                    final Optional<RuleGroupAdapter> ruleGroupAdapter = ruleGroupRule.getRuleGroupAdapter(adapterId);
                    if (ruleGroupAdapter.isPresent()) {
                        final String userId = ruleGroupAdapter.get().getUserId();
                        return Optional.ofNullable(adapterProperties.getUser(userId).get());
                    } else {
                        System.out.println("No ruleGroupAdapter");
                    }
                }
            } else {
                System.out.println("No rule");
            }
        }
        return Optional.empty();
    }

    public boolean check(final String ruleExpression, final User user) {
        final Expression expr = new Expression(normalize(ruleExpression));
        final int i = expr
                .with("C3", toString(user.isC3()))
                .with("CLEAR", toString(user.isClear()))
                .with("INFODIENST", toString(user.isInfodienst()))
                .with("TAX", toString(user.isTax()))
                .with("SONDA", toString(user.isSonda()))
                .with("SONDM", toString(user.isSondm()))
                .eval()
                .intValue();

        return i == 0 ? false : true;
    }

    protected static String toString(final Boolean b) {
        return b.toString();
    }

    protected static String normalize(final String s) {
        return s.replaceAll("C3\\.", "").toUpperCase();
    }

}
