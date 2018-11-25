package ch.kellerbaur.model;

public class Method {

    private String adapterId;

    private String methodName;

    private String ruleGroupId;

    public String getAdapterId() {
        return adapterId;
    }

    public void setAdapterId(final String adapterId) {
        this.adapterId = adapterId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(final String methodName) {
        this.methodName = methodName;
    }

    public String getRuleGroupId() {
        return ruleGroupId;
    }

    public void setRuleGroupId(final String ruleGroupId) {
        this.ruleGroupId = ruleGroupId;
    }

    @Override
    public String toString() {
        return adapterId + "#" + methodName + " (ruleGroupId = " + ruleGroupId + ")";
    }

}
