package ch.kellerbaur;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import ch.kellerbaur.model.Method;
import ch.kellerbaur.model.Rule;
import ch.kellerbaur.model.RuleGroup;
import ch.kellerbaur.model.AdapterUser;

@Configuration
@ConfigurationProperties(value = "adapter", ignoreUnknownFields = true, ignoreInvalidFields = false)
public class AdapterProperties {

    private final List<Method> methods = new ArrayList<>();

    private final List<RuleGroup> ruleGroups = new ArrayList<>();

    private final List<Rule> rules = new ArrayList<>();

    private final List<AdapterUser> users = new ArrayList<>();

    public List<Method> getMethods() {
        return methods;
    }

    public List<RuleGroup> getRuleGroups() {
        return ruleGroups;
    }

    public List<AdapterUser> getUsers() {
        return users;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public Optional<RuleGroup> getRuleGroup(final String adapterId, final String methodName) {
        final Optional<Method> method = getMethod(adapterId, methodName);
        return method.isPresent() ? getRuleGroup(method.get().getRuleGroupId()) : Optional.empty();
        //            if (ruleGroup.isPresent()) {
        //                expressions = ruleGroup.get().getRules().stream()
        //                        .map(ruleGroupRule -> getRule(ruleGroupRule.getRuleId()))
        //                        .filter(Optional::isPresent).map(Optional::get)
        //                        .collect(Collectors.toList());
        //            }
    }

    public Optional<Rule> getRule(final String ruleId) {
        return rules.stream().filter(rule -> rule.getId().equals(ruleId)).findFirst();
    }

    public Optional<Method> getMethod(final String adapterId, final String methodName) {
        return methods.stream().filter(method -> method.getMethodName().equals(methodName)).findFirst();
    }

    public Optional<RuleGroup> getRuleGroup(final String ruleGroupId) {
        return ruleGroups.stream().filter(ruleGroup -> ruleGroup.getId().equals(ruleGroupId)).findFirst();
    }

    public Optional<AdapterUser> getUser(final String userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }

}
