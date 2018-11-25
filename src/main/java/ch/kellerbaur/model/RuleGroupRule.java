package ch.kellerbaur.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RuleGroupRule implements Comparable<RuleGroupRule> {

    private String ruleId;

    private Integer order;

    private List<RuleGroupAdapter> adapters = new ArrayList<>();

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(final String ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(final Integer order) {
        this.order = order;
    }

    public List<RuleGroupAdapter> getAdapters() {
        return adapters;
    }

    public Optional<RuleGroupAdapter> getRuleGroupAdapter(final String adapterId) {
        return adapters.stream()
                .filter(adapter -> adapter.getAdapterId().equals(adapterId))
                .findFirst();
    }

    public void setAdapters(final List<RuleGroupAdapter> adapters) {
        this.adapters = adapters;
    }

    @Override
    public String toString() {
        return "rule = " + ruleId + " (order = " + order + ", adapters = " + adapters + ")";
    }

    @Override
    public int compareTo(final RuleGroupRule o) {
        return getOrder().compareTo(o.getOrder());
    }

}
