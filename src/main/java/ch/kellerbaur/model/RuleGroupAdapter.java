package ch.kellerbaur.model;

public class RuleGroupAdapter {

    private String adapterId;

    private String userId;

    public String getAdapterId() {
        return adapterId;
    }

    public void setAdapterId(final String adapterId) {
        this.adapterId = adapterId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "adapter = " + adapterId + " (userId = " + userId + ")";
    }

}
