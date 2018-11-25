package ch.kellerbaur.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RuleGroup {

    private String id;

    private List<RuleGroupRule> rules = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<RuleGroupRule> getRules() {
        Collections.sort(rules);
        return rules;
    }

    public void setRules(final List<RuleGroupRule> rules) {
        this.rules = rules;
    }

    public Optional<RuleGroupAdapter> getRuleGroupAdapter(final String adapterId) {
        return rules.stream()
                .flatMap(rule -> rule.getAdapters().stream())
                .filter(adapter -> adapter.getAdapterId().equals(adapterId))
                .findFirst();
    }

    @Override
    public String toString() {
        return "ruleGroup = " + id + " (rules = " + rules + ")";
    }

}
