package ch.kellerbaur.model;

public class Rule {

    private String id;

    private String expression;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(final String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return id + " (" + expression + ")";
    }

}
